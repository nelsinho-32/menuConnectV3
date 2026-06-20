package com.menuconnect.api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "entregas")
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Uma entrega está diretamente ligada a uma comanda específica (Relação 1 para 1)
    @OneToOne
    @JoinColumn(name = "comanda_id", nullable = false, unique = true)
    private Comanda comanda;

    // O motoboy responsável (vinculado à tabela de funcionários)
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario entregador;

    // Dados do endereço
    @Column(nullable = false)
    private String logradouro;
    
    @Column(nullable = false)
    private String numero;
    
    private String complemento;
    
    @Column(nullable = false)
    private String bairro; // Útil para cruzar dados de taxas de entrega por região

    // Controle financeiro da logística
    @Column(nullable = false)
    private BigDecimal taxaEntrega;

    // Ex: "AGUARDANDO_MOTOBOY", "A_CAMINHO", "ENTREGUE", "CANCELADA"
    @Column(nullable = false)
    private String status;

    private LocalDateTime dataHoraSaida;
    
    private LocalDateTime dataHoraEntrega;
}