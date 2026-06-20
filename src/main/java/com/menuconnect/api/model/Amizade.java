package com.menuconnect.api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "amizades")
public class Amizade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "amigo_id", nullable = false)
    private Cliente amigo;

    // Ex: "PENDENTE", "ACEITO", "BLOQUEADO"
    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private LocalDateTime dataHoraConexao;
}