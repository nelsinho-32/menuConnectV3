package com.menuconnect.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "favoritos")
public class Favorito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    // Pode ser nulo se o favorito for um prato específico
    @ManyToOne
    @JoinColumn(name = "estabelecimento_id")
    private Estabelecimento estabelecimento;

    // Pode ser nulo se o favorito for o local inteiro
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
}