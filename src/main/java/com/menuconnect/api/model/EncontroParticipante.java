package com.menuconnect.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "encontro_participantes")
public class EncontroParticipante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "encontro_id", nullable = false)
    private Encontro encontro;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    // Ex: "CONVIDADO", "CONFIRMADO", "RECUSADO"
    @Column(nullable = false)
    private String statusPresenca;
}