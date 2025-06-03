package org.example.entities;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Fornecedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOR_ID")
    private Long forId;

    @NotBlank(message = "Nome Fantasia é Obrigatório")
    @Size(max = 100, message = "Nome Fantasia deve ter no máximo 100 Caracteres")
    @Column(name = "FOR_NOME_FANTASIA", nullable = false, length = 100)
    private String forNomeFantasia;

    @NotBlank(message = "CNPJ é Obrigatório")
    @CNPJ(message = "CNPJ Inválido")
    @Column(name = "FOR_CNPJ",nullable = false, unique = true, length = 18)
    private String forCnpj;

    @NotBlank(message = "Razão Social é Obrigatório")
    @Size(max = 100, message = "Razão Social deve ter no máximo 100 Caracteres")
    @Column(name = "FOR_RAZAO_SOCIAL", nullable = false, unique = true, length = 100)
    private String forRazaoSocial;

    @NotBlank(message = "Status é Obrigatório")
    @Size(max = 60, message = "Status deve ter no máximo 60 Caracteres")
    @Column(name = "FOR_STATUS", nullable = false, length = 60)
    private String forStatus;

    public Fornecedor() {
    }

    public Fornecedor(Long forId, String forNome, String forNomeFantasia, String forCnpj, String forRazaoSocial, String forStatus) {
        this.forId = forId;
        this.forNomeFantasia = forNomeFantasia;
        this.forCnpj = forCnpj;
        this.forRazaoSocial = forRazaoSocial;
        this.forStatus = forStatus;
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

    public String getForCnpj() {
        return forCnpj;
    }

    public void setForCnpj(String forCnpj) {
        this.forCnpj = forCnpj;
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
}