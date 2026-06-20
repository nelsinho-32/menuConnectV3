package com.menuconnect.api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "lancamentos_fiado")
public class LancamentoFiado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "conta_fiado_id", nullable = false)
    private ContaFiado contaFiado;

    // Se a dívida veio de uma comanda específica do salão
    @ManyToOne
    @JoinColumn(name = "comanda_id")
    private Comanda comanda;

    // Ex: "COMPRA" (aumenta a dívida) ou "PAGAMENTO_PARCIAL" (diminui a dívida)
    @Column(nullable = false)
    private String tipoLancamento;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private LocalDateTime dataHoraLancamento;
}