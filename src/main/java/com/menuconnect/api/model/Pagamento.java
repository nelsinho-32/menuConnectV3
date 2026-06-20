package com.menuconnect.api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pagamentos")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "comanda_id", nullable = false)
    private Comanda comanda;

    @Column(nullable = false)
    private BigDecimal valorPago;

    // Ex: "PIX", "CARTAO_CREDITO", "CARTAO_DEBITO", "DINHEIRO"
    @Column(nullable = false)
    private String metodoPagamento;

    @Column(nullable = false)
    private LocalDateTime dataHoraPagamento;

    // Ex: "APROVADO", "RECUSADO", "PENDENTE"
    @Column(nullable = false)
    private String status;
}