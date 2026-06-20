package com.menuconnect.api.controller;

import com.menuconnect.api.dto.LoginDTO;
import com.menuconnect.api.model.Usuario;
import com.menuconnect.api.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<String> efetuarLogin(@RequestBody @Valid LoginDTO dados) {
        // 1. Cria um token temporário só com o que o usuário digitou
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.getEmail(), dados.getSenha());
        
        // 2. O Spring vai no banco de dados, criptografa a senha digitada e compara com a do banco
        var authentication = manager.authenticate(authenticationToken);
        
        // 3. Se deu certo, geramos o Crachá Digital (JWT)
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        
        // 4. Devolve o Token para o React/App
        return ResponseEntity.ok(tokenJWT);
    }
}