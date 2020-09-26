package com.example.sweater.config;

import com.example.sweater.domains.AppUser;
import com.example.sweater.domains.Role;
import io.jsonwebtoken.*;
//import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private String expirationTime;

    public String extractUsername3(String authToken) {
        return null;
//        return getClaimsFromToken(authToken)
//                .getSubject();
    }

    public Claims getClaimsFromToken2(String authToken) {
        return null;
//        String key = Base64.getEncoder().encodeToString(secret.getBytes());
//
//        return Jwts.parserBuilder()
//                .setSigningKey(key)
//                .build()
//                .parseClaimsJws(authToken)
//                .getBody();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(authToken);
            return true;
        } catch (ExpiredJwtException expEx) {
            //log.severe("Token expired");
            System.out.println("Token expired");
        } catch (UnsupportedJwtException unsEx) {
            //log.severe("Unsupported jwt");
            System.out.println("Unsupported jwt");
        } catch (MalformedJwtException mjEx) {
            //log.severe("Malformed jwt");
            System.out.println("Malformed jwt");
        } catch (SignatureException sEx) {
            //log.severe("Invalid signature");
            System.out.println("Invalid signature");
        } catch (Exception e) {
            //log.severe("invalid token");
            System.out.println("invalid token");
        }
        return false;
    }

    public String getLoginFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }


    public String generateToken(AppUser appUser) {
        HashMap<String, Object> claims = new HashMap<>();

        long expirationSeconds = Long.parseLong(expirationTime);
        Date creationDate = new Date();
        Date expirationDate = new Date(creationDate.getTime() + expirationSeconds * 1000);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(appUser.getUsername())
                .setIssuedAt(creationDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }
}