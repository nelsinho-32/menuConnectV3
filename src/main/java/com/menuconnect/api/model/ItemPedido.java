package com.menuconnect.api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "itens_pedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @Column(nullable = false)
    private Integer quantidade;

    // É crucial salvar o preço aqui. Se o valor do Produto subir no cardápio amanhã, 
    // o histórico financeiro do cliente ou da comanda antiga não pode ser alterado.
    @Column(nullable = false)
    private BigDecimal precoUnitario;

    // Observações específicas, ex: "Sem cebola"
    private String observacaoItem; 
}