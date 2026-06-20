package com.menuconnect.api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "encontros")
public class Encontro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeEncontro;

    @ManyToOne
    @JoinColumn(name = "criador_id", nullable = false)
    private Cliente criador;

    @ManyToOne
    @JoinColumn(name = "estabelecimento_id", nullable = false)
    private Estabelecimento estabelecimento;

    @Column(nullable = false)
    private LocalDateTime dataHoraEncontro;

    // Controla se os amigos podem modificar o planejamento previamente
    @Column(nullable = false)
    private Boolean permiteModificacaoAmigos; 
}