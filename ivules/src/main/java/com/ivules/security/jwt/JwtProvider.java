package com.ivules.security.jwt;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.ivules.security.entity.UsuarioPrincipal;
import com.ivules.util.exceptions.IvulesException;

import java.util.Date;

@Component
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    public String generateToken(Authentication authentication){
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        System.out.println("EXPIRADO----------------- " + new Date().getTime() + expiration);
        return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getNombreUsuarioFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) throws IvulesException{
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException e){
            logger.error("token mal formado");
            throw new IvulesException("token mal formado");
        }catch (UnsupportedJwtException e){
            logger.error("token no soportado");
            throw new IvulesException("token no soportado");
        }catch (ExpiredJwtException e){
            logger.error("token expirado");
            throw new IvulesException("token expirado");
        }catch (IllegalArgumentException e){
            logger.error("token vacío");
            throw new IvulesException("token vacío");
        }catch (SignatureException e){
            logger.error("fail en la firma");
            throw new IvulesException("fail en la firma");
        }
    }
}
