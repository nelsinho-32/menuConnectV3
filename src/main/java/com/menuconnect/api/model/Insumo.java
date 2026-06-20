package com.menuconnect.api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "insumos")
public class Insumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estabelecimento_id", nullable = false)
    private Estabelecimento estabelecimento;

    @Column(nullable = false)
    private String nome;

    // Ex: "KG", "GRAMAS", "LITRO", "ML", "UNIDADE"
    @Column(nullable = false)
    private String unidadeMedida;

    // A quantidade real que tem na despensa agora
    @Column(nullable = false)
    private BigDecimal quantidadeAtual;
    
    // Alerta para o gerente saber quando precisa fazer compras
    private BigDecimal estoqueMinimoAlerta; 
}