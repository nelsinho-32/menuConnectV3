package com.menuconnect.api.security;

import com.menuconnect.api.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class TokenService {

    // Chave secreta usada para assinar o token. Em produção, isso deve vir das variáveis de ambiente!
    private static final Key CHAVE_SECRETA = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    
    // Tempo de validade do token (Ex: 2 horas)
    private static final long EXPIRATION_TIME = 7200000;

    public String gerarToken(Usuario usuario) {
        return Jwts.builder()
                .setSubject(usuario.getEmail())
                .claim("perfil", usuario.getPerfilAcesso()) // Guarda se é GERENTE, CLIENTE, etc.
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(CHAVE_SECRETA)
                .compact();
    }

    public String extrairEmailDoToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(CHAVE_SECRETA)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean isTokenValido(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(CHAVE_SECRETA).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}