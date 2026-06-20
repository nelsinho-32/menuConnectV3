package com.menuconnect.api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "comandas")
public class Comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estabelecimento_id", nullable = false)
    private Estabelecimento estabelecimento;

    // Pode ser nulo caso seja um delivery ou venda de balcão
    @ManyToOne
    @JoinColumn(name = "mesa_id")
    private Mesa mesa;

    // Vincula ao perfil do cliente, útil para o histórico do Dashboard Financeiro
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    // Ex: "ABERTA", "AGUARDANDO_PAGAMENTO", "PAGA", "CANCELADA"
    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private LocalDateTime dataHoraAbertura;

    private LocalDateTime dataHoraFechamento;
}