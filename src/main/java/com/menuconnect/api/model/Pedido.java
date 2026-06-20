package com.menuconnect.api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "comanda_id", nullable = false)
    private Comanda comanda;

    // Registra qual funcionário atendeu, ajudando no dashboard de RH e métricas
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @Column(nullable = false)
    private LocalDateTime dataHoraPedido;

    // Ex: "NA_FILA", "EM_PREPARO", "PRONTO", "ENTREGUE"
    @Column(nullable = false)
    private String statusCozinha;

    // Observações gerais do pedido, facilitando a praticidade no atendimento
    private String observacoesGerais; 
}