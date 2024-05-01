package com.dragon.dungeon.services;

import javax.security.auth.login.CredentialException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.dragon.dungeon.dao.UserDao;
import com.dragon.dungeon.dto.models.UserModel;
import com.dragon.dungeon.dto.request.LoginRequest;
import com.dragon.dungeon.dto.request.RegisterRequest;
import com.dragon.dungeon.dto.response.LoginResponse;
import com.dragon.dungeon.dto.response.RegisterResponse;
import com.dragon.dungeon.services.security.jwt.JwtService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    
    private final UserDao userDao;

    private final JwtService jwtService;


    @Override
    public RegisterResponse register(RegisterRequest request) {
        if(userDao.getUserByEmail(request.getUMail()) != null){
            throw new RuntimeException("This email is already taken");
        }

        UserModel newUser = UserModel.builder()
                .uName(request.getUName())
                .uMail(request.getUMail())
                .uPwd(request.getUPwd())
                .build();
        UserModel savedUser = userDao.registerUser(newUser);

        return RegisterResponse.builder()
            .id(savedUser.getId())
            .uMail(savedUser.getUMail())
        .build();
    }


    @Override
    public LoginResponse login(LoginRequest request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws CredentialException {
        if (!userDao.validateUser(request.getUMail(), request.getUPwd())){
            throw new CredentialException("Wrong password!");
        }

        UserModel user = userDao.getUserByEmail(request.getUMail());

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                user.getUsername(), user.getPassword(), user.getAuthorities());

        SecurityContext context = SecurityContextHolder.createEmptyContext();

        context.setAuthentication(token);

        SecurityContextHolder.setContext(context);

        String userJwt = jwtService.generateToken(user);

        return LoginResponse.builder()
                .token(userJwt)
                .build();
    }

}


