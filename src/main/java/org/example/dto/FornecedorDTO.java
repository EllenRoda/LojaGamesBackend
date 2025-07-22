package org.example.dto;



import javax.persistence.Column;
import java.time.LocalDateTime;

public class FornecedorDTO {
    private Long forId;
    private String forNomeFantasia;
    private String forRazaoSocial;
    private String forStatus;
    private LocalDateTime forDataCadastro;
    private String forResponsavel;

    // Endereco
    private String endRua;
    private String endNumero;
    private String endCidade;
    private String endBairro;
    private String endCep;
    private String endEstado;
    private String endPais;
    private String endComplemento;
    private String endTipoResidencia;

    // Contato
    private String conCelular;
    private String conTelefoneComercial;
    private String conEmail;

    public FornecedorDTO() {
    }

    public Long getForId() {
        return forId;
    }

    public void setForId(Long forId) {
        this.forId = forId;
    }

    public String getForNomeFantasia() {
        return forNomeFantasia;
    }

    public void setForNomeFantasia(String forNomeFantasia) {
        this.forNomeFantasia = forNomeFantasia;
    }

    public String getForRazaoSocial() {
        return forRazaoSocial;
    }

    public void setForRazaoSocial(String forRazaoSocial) {
        this.forRazaoSocial = forRazaoSocial;
    }

    public String getForStatus() {
        return forStatus;
    }

    public void setForStatus(String forStatus) {
        this.forStatus = forStatus;
    }

    public String getEndRua() {
        return endRua;
    }

    public void setEndRua(String endRua) {
        this.endRua = endRua;
    }

    public String getEndNumero() {
        return endNumero;
    }

    public void setEndNumero(String endNumero) {
        this.endNumero = endNumero;
    }

    public String getEndCidade() {
        return endCidade;
    }

    public void setEndCidade(String endCidade) {
        this.endCidade = endCidade;
    }

    public String getEndBairro() {
        return endBairro;
    }

    public void setEndBairro(String endBairro) {
        this.endBairro = endBairro;
    }

    public String getEndCep() {
        return endCep;
    }

    public void setEndCep(String endCep) {
        this.endCep = endCep;
    }

    public String getEndEstado() {
        return endEstado;
    }

    public void setEndEstado(String endEstado) {
        this.endEstado = endEstado;
    }

    public String getEndPais() {
        return endPais;
    }

    public void setEndPais(String endPais) {
        this.endPais = endPais;
    }

    public String getConCelular() {
        return conCelular;
    }

    public void setConCelular(String conCelular) {
        this.conCelular = conCelular;
    }

    public String getConTelefoneComercial() {
        return conTelefoneComercial;
    }

    public void setConTelefoneComercial(String conTelefoneComercial) {
        this.conTelefoneComercial = conTelefoneComercial;
    }

    public String getEndComplemento() {
        return endComplemento;
    }

    public void setEndComplemento(String endComplemento) {
        this.endComplemento = endComplemento;
    }

    public String getEndTipoResidencia() {
        return endTipoResidencia;
    }

    public void setEndTipoResidencia(String endTipoResidencia) {
        this.endTipoResidencia = endTipoResidencia;
    }

    public String getConEmail() {
        return conEmail;
    }

    public void setConEmail(String conEmail) {
        this.conEmail = conEmail;
    }

    public LocalDateTime getForDataCadastro() {
        return forDataCadastro;
    }

    public void setForDataCadastro(LocalDateTime forDataCadastro) {
        this.forDataCadastro = forDataCadastro;
    }

    public String getForResponsavel() {
        return forResponsavel;
    }

    public void setForResponsavel(String forResponsavel) {
        this.forResponsavel = forResponsavel;
    }
}
