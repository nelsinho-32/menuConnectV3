package com.menuconnect.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data // O Lombok usa isso para gerar os Getters e Setters invisivelmente
@Entity
@Table(name = "mesas")
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estabelecimento_id", nullable = false)
    private Estabelecimento estabelecimento;

    @Column(nullable = false, unique = true)
    private Integer numero;

    // Pode ser: "LIVRE", "OCUPADA", "RESERVADA"
    @Column(nullable = false)
    private String status;

    private Integer capacidadePessoas;
}