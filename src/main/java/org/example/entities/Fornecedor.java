package org.example.entities;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Fornecedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FOR_ID")
    private Long forId;

    @OneToMany(mappedBy = "endFornecedor", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToMany(mappedBy = "conFornecedor", cascade = CascadeType.ALL)
    private List<Contato> contatos = new ArrayList<>();

    @Column(name = "FOR_NOME_FANTASIA", nullable = false, length = 100)
    private String forNomeFantasia;

    @Column(name = "FOR_RAZAO_SOCIAL", nullable = false, length = 100)
    private String forRazaoSocial;

    @Column(name = "FOR_TELEFONE", length = 20)
    private String forTelefone;

    @Column(name = "FOR_CPF", nullable = false, length = 15)
    private String forCpf;

    @Column(name = "FOR_STATUS", nullable = false, length = 60)
    private String forStatus;

    @Column(name = "FOR_DATA_CADASTRO", nullable = false)
    private LocalDateTime forDataCadastro;

    @Column(name = "FOR_RESPONSAVEL", nullable = false, length = 60)
    private String forResponsavel;

    public Fornecedor() {
    }

    public Fornecedor(Long forId, String forNomeFantasia, String forRazaoSocial, String forTelefone, String forCpf, String forStatus, LocalDateTime forDataCadastro, String forResponsavel) {
        this.forId = forId;
        this.forNomeFantasia = forNomeFantasia;
        this.forRazaoSocial = forRazaoSocial;
        this.forTelefone = forTelefone;
        this.forCpf = forCpf;
        this.forStatus = forStatus;
        this.forDataCadastro = forDataCadastro;
        this.forResponsavel = forResponsavel;
    }

    public Long getForId() {
        return forId;
    }

    public void setForId(Long forId) {
        this.forId = forId;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
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

    public String getForTelefone() {
        return forTelefone;
    }

    public void setForTelefone(String forTelefone) {
        this.forTelefone = forTelefone;
    }

    public String getForCpf() {
        return forCpf;
    }

    public void setForCpf(String forCpf) {
        this.forCpf = forCpf;
    }

    public String getForStatus() {
        return forStatus;
    }

    public void setForStatus(String forStatus) {
        this.forStatus = forStatus;
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