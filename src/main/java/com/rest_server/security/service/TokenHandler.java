package com.rest_server.security.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 17.08.2017
 *
 * @author Roman Hayda
 */
@Component
public class TokenHandler {
//    private final SecretKey secretKey;
    private final String secretKey = "userSecretKey";
    private Long expiration = 14L;

    public TokenHandler() {
//        String jwtKey = "userSecretKey"; //your secret key
//        byte[] decodedKey = Base64.getDecoder().decode(jwtKey);
//        secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
    }

    public String getUsernameFromToken(String token) {
        String username;
        try {
            final Claims claims = this.getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            return null;
        }
        return username;
    }

    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = this.getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            return null;
        }
        return expiration;
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(this.secretKey)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return claims;
    }

//    private Boolean isTokenExpired(String token) {
//        final Date expiration = this.getExpirationDateFromToken(token);
//        return expiration.before(new Date(System.currentTimeMillis()));
//    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", userDetails.getUsername());

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(Date.from(LocalDateTime.now().plusDays(expiration).atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(SignatureAlgorithm.HS512, this.secretKey)
                .compact();
    }
}
