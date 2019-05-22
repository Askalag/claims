package com.askalag.claims.security;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@PropertySource("classpath:jwtToken.properties")
public class JwtAuthProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthProvider.class);
    @Value("${jwt.token.expiration.minutes}")
    private int tokenExpiration;
    @Value("${jwt.token.secret}")
    private String tokenSecret;

    public String generateJwtToken(Authentication authentication) {

        CustomUserDetails userDetails = (CustomUserDetails)authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + (tokenExpiration * 60000)))
                .signWith(SignatureAlgorithm.HS512, tokenSecret)
                .compact();
    }
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(tokenSecret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    public boolean validateJwtToken(String token) {

        try {
            Jwts.parser().setSigningKey(tokenSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature -> Message: {} ", e);
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token -> Message: {}", e);
        } catch (ExpiredJwtException e) {
            logger.error("Expired JWT token -> Message: {}", e);
        } catch (UnsupportedJwtException e) {
            logger.error("Unsupported JWT token -> Message: {}", e);
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty -> Message: {}", e);
        }
        return false;
    }

}
