package com.menuconnect.api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "registros_perdas")
public class RegistroPerda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estabelecimento_id", nullable = false)
    private Estabelecimento estabelecimento;

    // Quem reportou o erro/perda?
    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "insumo_id", nullable = false)
    private Insumo insumo;

    @Column(nullable = false)
    private BigDecimal quantidadePerdida;

    // Ex: "ERRO_DE_PREPARO", "PRODUTO_VENCIDO", "ACIDENTE", "FALTA_DE_ENERGIA"
    @Column(nullable = false)
    private String motivo;

    @Column(nullable = false)
    private LocalDateTime dataHoraRegistro;
}