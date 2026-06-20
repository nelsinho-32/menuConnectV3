package com.menuconnect.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private Usuario usuario;

    @Column(nullable = false)
    private String nomeCompleto;

    private String telefone;

    // Garante a regra de que o perfil pode ser aberto ou privado
    private Boolean perfilPrivado;
    
    // O endereço sensível que será protegido
    private String enderecoPadrao;
}