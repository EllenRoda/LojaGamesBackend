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

    @NotBlank(message = "Crédito é obrigatória")
    @Size(max = 100, message = "Crédito deve ter no máximo 100 caracteres")
    @Column(name = "FPG_CREDITO", nullable = false, length = 10)
    private String fpgCredito;

    @NotBlank(message = "Fechamento é obrigatória")
    @Size(max = 10, message = "Fechamento deve ter no máximo 100 caracteres")
    @Column(name = "FPG_FECHAMENTO", nullable = false, length = 10)
    private String fpgFechamento;

    @NotBlank(message = "Descrição é obrigatória")
    @Size(max = 100, message = "Descrição deve ter no máximo 100 caracteres")
    @Column(name = "FPG_DESCRICAO", length = 100)
    private String fpgDescricao;

    @NotBlank(message = "Status é obrigatório")
    @Size(max = 15, message = "Status deve ter no máximo 60 caracteres")
    @Column(name = "FPG_STATUS", nullable = false, length = 15)
    private String fpgStatus;

    public FormaPagamento() {
    }

    public FormaPagamento(Long fpgId, String fpgCredito, String fpgFechamento, String fpgDescricao, String fpgStatus) {
        this.fpgId = fpgId;
        this.fpgCredito = fpgCredito;
        this.fpgFechamento = fpgFechamento;
        this.fpgDescricao = fpgDescricao;
        this.fpgStatus = fpgStatus;
    }

    public Long getFpgId() {
        return fpgId;
    }

    public void setFpgId(Long fpgId) {
        this.fpgId = fpgId;
    }

    public String getFpgCredito() {
        return fpgCredito;
    }

    public void setFpgCredito(String fpgCredito) {
        this.fpgCredito = fpgCredito;
    }

    public String getFpgFechamento() {
        return fpgFechamento;
    }

    public void setFpgFechamento(String fpgFechamento) {
        this.fpgFechamento = fpgFechamento;
    }

    public String getFpgDescricao() {
        return fpgDescricao;
    }

    public void setFpgDescricao(String fpgDescricao) {
        this.fpgDescricao = fpgDescricao;
    }

    public String getFpgStatus() {
        return fpgStatus;
    }

    public void setFpgStatus(String fpgStatus) {
        this.fpgStatus = fpgStatus;
    }
}