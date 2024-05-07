package com.dragon.dungeon.services.security.jwt;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.dragon.dungeon.dto.models.UserModel;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {

    private final TokenProperties tokenProperties;
    
    @Override
    public UserModel parseToken(String jwtToken) {
        try {
            JwtParser jwtParser = Jwts.parserBuilder()
                   .setSigningKey(getSigninKey())
                   .build();
    
            Jws<Claims> parsedJwt = jwtParser.parseClaimsJws(jwtToken);
    
            Claims claims = parsedJwt.getBody();
    
            return UserModel.builder()
                   .uMail((String) claims.get("uMail"))
                   .id(UUID.fromString(claims.getSubject()))
                   .build();
        } catch (ExpiredJwtException e){
            // log.info("Jwt is expired: {}", e.getMessage());
            throw new ExpiredJwtException(e.getHeader(), e.getClaims(), e.getMessage());
        }
    }

    @Override
    public String generateToken(UserModel user) {
        Claims claims = Jwts.claims();
        claims.setSubject(user.getId().toString());
        claims.put("uMail", user.getUMail());
        claims.setExpiration(getExpirationDate());

        return Jwts.builder()
                .addClaims(claims)
                .signWith(getSigninKey())
                .compact();
    }

    private Key getSigninKey() {
        byte[] keyBytes = Base64.getDecoder().decode(tokenProperties.getSecret());
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Date getExpirationDate(){
        Date now = new Date();
        now.setTime(now.getTime() + tokenProperties.getTimeToLive() * 1000);
        return now;
    }

}
