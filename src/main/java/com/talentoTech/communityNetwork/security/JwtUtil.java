package com.talentoTech.communityNetwork.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {
    private final SecretKey SECRET_KEY = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);

    public String generateToken(String correo){
        return Jwts.builder()
                .setSubject(correo)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SECRET_KEY)
                .compact();
    }

    public String extractCorreo(String token){
        return Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token, String correo){
        final String username = extractCorreo(token);
        return (username.equals(correo) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token){
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    // Método para extraer todos los claims (declaraciones) del token JWT
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)          // Usamos la misma clave secreta para validar la firma
                .build()
                .parseClaimsJws(token)              // Analiza el token
                .getBody();                         // Devuelve el cuerpo (payload) del token
    }
}
