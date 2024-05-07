package com.dragon.dungeon.services.security.filter;

import java.util.Objects;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.dragon.dungeon.dao.UserDao;
import com.dragon.dungeon.dto.models.UserModel;
import com.dragon.dungeon.services.security.jwt.JwtService;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import static org.springframework.util.ObjectUtils.isEmpty;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    private final UserDao userDao;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException, java.io.IOException {


        String jwt = getToken(request);

        if(Objects.isNull(jwt)){
            filterChain.doFilter(request, response);
            return;
        }

        UserModel user;

        user = jwtService.parseToken(jwt);

        if(Objects.isNull(user)){
            filterChain.doFilter(request, response);
            return;
        }



        if(!userDao.userExistByEmail(user.getUMail())){
            filterChain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                user.getUsername(), null, user.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(token);

        filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request) {
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (isEmpty(header) || !header.startsWith("Bearer ")) {
            return null;
        }

        final String[] strs = header.split(" ");
        if (strs.length != 2) {
            return null;
        }

        return strs[1].trim();
    }
}
