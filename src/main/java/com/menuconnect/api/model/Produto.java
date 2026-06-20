package com.menuconnect.api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estabelecimento_id", nullable = false)
    private Estabelecimento estabelecimento;

    @Column(nullable = false)
    private String nome;

    private String descricaoIngredientes;

    @Column(nullable = false)
    private BigDecimal preco;

    // Ex: "Bebidas", "Petiscos", "Pratos Principais"
    @Column(nullable = false)
    private String categoria;

    private Boolean disponivelEmEstoque;
}