package org.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Contato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CON_ID")
    private Long conId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "CON_CLI_ID")
    private Cliente conCliente;

    @Pattern(regexp = "\\(\\d{2}\\)\\d{5}-\\d{4}", message = "Celular deve estar no formato (xx)xxxxx-xxxx")
    @Column(name = "CON_CELULAR", length = 14)
    private String conCelular;

    @Pattern(regexp = "\\(\\d{2}\\)\\d{4}-\\d{4}", message = "Telefone Comercial deve estar no formato (xx)xxxxx-xxxx")
    @Column(name = "CON_TELEFONE_COMERCIAL", length = 14)
    private String conTelefoneComercial;

    @Email(message = "E-mail deve ser válido")
    @Size(max = 55, message = "E-mail deve ter no máximo 55 caracteres")
    @Column(name = "CON_EMAIL", length = 55)
    private String conEmail;


    public Contato() {
    }

    public Contato(Long conId, Cliente conCliente, String conCelular, String conTelefoneComercial, String conEmail) {
        this.conId = conId;
        this.conCliente = conCliente;
        this.conCelular = conCelular;
        this.conTelefoneComercial = conTelefoneComercial;
        this.conEmail = conEmail;
    }

    public Long getConId() {
        return conId;
    }

    public void setConId(Long conId) {
        this.conId = conId;
    }

    public Cliente getConCliente() {
        return conCliente;
    }

    public void setConCliente(Cliente conCliente) {
        this.conCliente = conCliente;
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

    public String getConEmail() {
        return conEmail;
    }

    public void setConEmail(String conEmail) {
        this.conEmail = conEmail;
    }
}