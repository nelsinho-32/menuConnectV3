package com.menuconnect.api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notas_fiscais")
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "comanda_id", nullable = false, unique = true)
    private Comanda comanda;

    @ManyToOne
    @JoinColumn(name = "estabelecimento_id", nullable = false)
    private Estabelecimento estabelecimento;

    // A chave de acesso gigante gerada pela SEFAZ
    @Column(unique = true)
    private String chaveAcessoSefaz;

    // O número da nota e a série
    private Integer numeroNota;
    private Integer serieNota;

    // Ex: "EMITIDA", "CANCELADA", "FALHA_NA_EMISSAO"
    @Column(nullable = false)
    private String statusSefaz;

    // O link ou o XML puro para o cliente baixar ou a contabilidade usar
    @Column(columnDefinition = "TEXT")
    private String xmlNota;

    @Column(nullable = false)
    private LocalDateTime dataHoraEmissao;
}