package br.com.lojadebrinquedo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Data
public class BrinquedoDTO {

    @NotBlank
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String tipo;

    private String classificacao;

    private String tamanho;

    private BigDecimal preco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
