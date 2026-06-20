package com.menuconnect.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "estabelecimentos")
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeFantasia;

    @Column(nullable = false, unique = true)
    private String cnpj;

    // Ex: "Bistrô", "Lanchonete", "Bar", "Pizzaria"
    @Column(nullable = false)
    private String tipoLocal; 

    // O endereço é fundamental para o cliente visualizar no mapa
    private String enderecoCompleto;
    
    private String telefoneContato;
    
    private Boolean possuiMusicaAoVivo; // Para a agenda de eventos
}