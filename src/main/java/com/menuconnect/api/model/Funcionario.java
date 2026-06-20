package com.menuconnect.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private Usuario usuario;

    @Column(nullable = false)
    private String nome;

    // Ex: "GARCOM", "COZINHEIRO", "GERENTE"
    @Column(nullable = false)
    private String cargo;

    // Vínculo obrigatório: Um funcionário pertence a UM estabelecimento
    @ManyToOne
    @JoinColumn(name = "estabelecimento_id", nullable = false)
    private Estabelecimento estabelecimento;

    // Métrica de performance para o RH
    private Integer totalPedidosAtendidos;
}