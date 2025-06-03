package org.example.entities;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class FormaPagamento  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FPG_ID")
    private Long fpgId;

    @NotBlank(message = "Descrição é obrigatória")
    @Size(max = 100, message = "Descrição deve ter no máximo 100 caracteres")
    @Column(name = "FPG_DESCRICAO", nullable = false, length = 100)
    private String fpgDescricao;

    @NotBlank(message = "Status é obrigatório")
    @Size(max = 60, message = "Status deve ter no máximo 60 caracteres")
    @Column(name = "FPG_STATUS", nullable = false, length = 60)
    private String fpgStatus;

    @NotBlank(message = "Permitir Parcelamento é obrigatório")
    @Size(max = 3, message = "Valor deve ter no máximo 3 caracteres (Sim ou Não)")
    @Column(name = "FPG_PERMITE_PARCELAMENTO", nullable = false, length = 3)
    private String fpgPermiteParcelamento;

    @Min(value = 1, message = "Número máximo de parcelas deve ser no mínimo 1")
    @Column(name = "FPG_NUMERO_MAXIMO_PARCELAS")
    private Integer fpgNumeroMaximoParcelas;

    @NotBlank(message = "Tipo é obrigatório")
    @Size(max = 30, message = "Tipo deve ter no máximo 30 caracteres")
    @Column(name = "FPG_TIPO", nullable = false, length = 30)
    private String fpgTipo;

    @Min(value = 1, message = "Quantidade de parcelas deve ser no mínimo 1")
    @Column(name = "FPG_QTD_PARCELA")
    private Integer fpgQtdParcela;

    @DecimalMin(value = "0.0", inclusive = true, message = "Taxa adicional deve ser maior ou igual a zero")
    @Column(name = "FPG_TAXA_ADICIONA", precision = 10, scale = 2)
    private BigDecimal fpgTaxaAdiciona;


    public FormaPagamento() {
    }

    public FormaPagamento(Long fpgId, String fpgDescricao, String fpgStatus, String fpgPermiteParcelamento, Integer fpgNumeroMaximoParcelas, String fpgTipo, Integer fpgQtdParcela, BigDecimal fpgTaxaAdiciona) {
        this.fpgId = fpgId;
        this.fpgDescricao = fpgDescricao;
        this.fpgStatus = fpgStatus;
        this.fpgPermiteParcelamento = fpgPermiteParcelamento;
        this.fpgNumeroMaximoParcelas = fpgNumeroMaximoParcelas;
        this.fpgTipo = fpgTipo;
        this.fpgQtdParcela = fpgQtdParcela;
        this.fpgTaxaAdiciona = fpgTaxaAdiciona;
    }

    public Long getFpgId() {
        return fpgId;
    }

    public void setFpgId(Long fpgId) {
        this.fpgId = fpgId;
    }

    public String getFpgDescricao() {
        return fpgDescricao;
    }

    public void setFpgDescricao(String fpgDescricao) {
        this.fpgDescricao = fpgDescricao;
    }

    public String getFpgStatus() { return fpgStatus; }
    public void setFpgStatus(String fpgStatus) { this.fpgStatus = fpgStatus; }

    public String getFpgPermiteParcelamento() {
        return fpgPermiteParcelamento;
    }

    public void setFpgPermiteParcelamento(String fpgPermiteParcelamento) {
        this.fpgPermiteParcelamento = fpgPermiteParcelamento;
    }

    public Integer getFpgNumeroMaximoParcelas() {
        return fpgNumeroMaximoParcelas;
    }

    public void setFpgNumeroMaximoParcelas(Integer fpgNumeroMaximoParcelas) {
        this.fpgNumeroMaximoParcelas = fpgNumeroMaximoParcelas;
    }

    public String getFpgTipo() {
        return fpgTipo;
    }

    public void setFpgTipo(String fpgTipo) {
        this.fpgTipo = fpgTipo;
    }

    public Integer getFpgQtdParcela() {
        return fpgQtdParcela;
    }

    public void setFpgQtdParcela(Integer fpgQtdParcela) {
        this.fpgQtdParcela = fpgQtdParcela;
    }

    public BigDecimal getFpgTaxaAdiciona() {
        return fpgTaxaAdiciona;
    }

    public void setFpgTaxaAdiciona(BigDecimal fpgTaxaAdiciona) {
        this.fpgTaxaAdiciona = fpgTaxaAdiciona;
    }
}