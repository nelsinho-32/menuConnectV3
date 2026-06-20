package com.menuconnect.api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "cupons")
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estabelecimento_id", nullable = false)
    private Estabelecimento estabelecimento;

    // O código que o cliente digita. Ex: "PROMO10", "NIVER20"
    @Column(nullable = false, unique = true)
    private String codigo;

    // Pode ser um valor fixo (R$ 10) ou uma porcentagem (10%)
    @Column(nullable = false)
    private BigDecimal valorDesconto;

    @Column(nullable = false)
    private Boolean isPorcentagem;

    private LocalDateTime dataValidade;

    // Limita quantas vezes o cupom pode ser usado no total
    private Integer limiteUsosGlobais;

    // Quantas vezes já foi utilizado
    private Integer usosAtuais;
}