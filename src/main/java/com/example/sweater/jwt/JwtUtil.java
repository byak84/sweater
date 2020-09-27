package com.example.sweater.jwt;

import com.example.sweater.domains.AppUser;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private String expirationTime;


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
            System.out.println("Token expired");
        } catch (UnsupportedJwtException unsEx) {
            System.out.println("Unsupported jwt");
        } catch (MalformedJwtException mjEx) {
            System.out.println("Malformed jwt");
        } catch (SignatureException sEx) {
            System.out.println("Invalid signature");
        } catch (Exception e) {
            System.out.println("invalid token");
        }
        return false;
    }

    public String getSubjectFromToken(String token) {
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