package com.menuconnect.api.controller;

import com.menuconnect.api.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/uploads")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("/imagem")
    public ResponseEntity<String> uploadImagem(@RequestParam("file") MultipartFile arquivo) {
        String caminhoImagem = uploadService.salvarImagem(arquivo);
        return ResponseEntity.ok(caminhoImagem); // Retorna a URL pública da foto
    }
}