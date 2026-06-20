package com.menuconnect.api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "fila_espera")
public class FilaEspera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estabelecimento_id", nullable = false)
    private Estabelecimento estabelecimento;

    // Se for um cliente já cadastrado no app
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    // Caso seja alguém sem o app, o funcionário anota o nome e o número na porta
    private String nomeClienteNaoCadastrado;
    private String telefoneContato;

    @Column(nullable = false)
    private Integer tamanhoGrupo;

    @Column(nullable = false)
    private LocalDateTime dataHoraEntrada;

    // Ex: "AGUARDANDO", "NOTIFICADO", "SENTADO", "DESISTIU"
    @Column(nullable = false)
    private String status;
}