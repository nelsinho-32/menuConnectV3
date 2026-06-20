package com.menuconnect.api.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class UploadService {

    // Cria uma pasta chamada "uploads" na raiz do seu projeto
    private final String diretorioDestino = "uploads";

    public String salvarImagem(MultipartFile arquivo) {
        try {
            Path pathDiretorio = Paths.get(diretorioDestino);
            if (!Files.exists(pathDiretorio)) {
                Files.createDirectories(pathDiretorio);
            }

            // Gera um nome único para a imagem para evitar sobrescrever fotos com o mesmo nome
            String nomeArquivoOriginal = arquivo.getOriginalFilename();
            String extensao = nomeArquivoOriginal.substring(nomeArquivoOriginal.lastIndexOf("."));
            String novoNome = UUID.randomUUID().toString() + extensao;

            Path pathArquivo = pathDiretorio.resolve(novoNome);
            
            // Copia o arquivo da requisição para a pasta
            Files.copy(arquivo.getInputStream(), pathArquivo, StandardCopyOption.REPLACE_EXISTING);

            // Retorna o caminho para ser salvo no banco de dados
            return "/uploads/" + novoNome;

        } catch (IOException e) {
            throw new RuntimeException("Falha ao salvar a imagem", e);
        }
    }
}