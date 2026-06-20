package com.menuconnect.api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "contas_fiado")
public class ContaFiado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estabelecimento_id", nullable = false)
    private Estabelecimento estabelecimento;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    // O limite máximo que o gerente permite que esse cliente "pendure" [cite: 17]
    @Column(nullable = false)
    private BigDecimal limiteCredito;

    // O valor atual que ele está devendo
    @Column(nullable = false)
    private BigDecimal saldoDevedorAtual;

    @Column(nullable = false)
    private Boolean bloqueada; // Caso o cliente não pague, o gerente bloqueia novos fiados
}