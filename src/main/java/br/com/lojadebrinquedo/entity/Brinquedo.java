package br.com.lojadebrinquedo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "T_LDB_BRINQUEDO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brinquedo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BRINQUEDO")
    private Long id;

    @Column(name = "NM_BRINQUEDO")
    private String nome;

    @Column(name = "TP_BRINQUEDO")
    private String tipo;

    @Column(name = "CL_BRINQUEDO")
    private String classificacao;

    @Column(name = "TM_BRINQUEDO")
    private String tamanho;

    @Column(name = "PR_BRINQUEDO")
    private BigDecimal preco;
}
