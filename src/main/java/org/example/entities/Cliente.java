package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLI_ID")
    private Long cliId;

    @OneToMany(mappedBy = "endCliente", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToMany(mappedBy = "conCliente", cascade = CascadeType.ALL)
    private List<Contato> contatos = new ArrayList<>();

    @Column(name = "CLI_NOME", nullable = false, length = 100)
    private String cliNome;

    @Column(name = "CLI_CPF", nullable = false, unique = true, length = 15)
    private String cliCpf;

    @Column(name = "CLI_STATUS", nullable = false, length = 60)
    private String cliStatus;

    @Column(name = "CLI_DATA_NASCIMENTO", nullable = false, length = 60)
    private String dataNascimento;
    @Column(name = "CLI_FORMA_PAGAMENTO", nullable = false, length = 60)
    private String formaPagamento;


    public Cliente() {
    }

    public Cliente(Long cliId, String cliNome, String cliCpf, String cliStatus, String dataNascimento, String formaPagamento) {
        this.cliId = cliId;
        this.cliNome = cliNome;
        this.cliCpf = cliCpf;
        this.cliStatus = cliStatus;
        this.dataNascimento = dataNascimento;
        this.formaPagamento = formaPagamento;
    }

    public Long getCliId() {
        return cliId;
    }

    public void setCliId(Long cliId) {
        this.cliId = cliId;
    }

    public String getCliNome() {
        return cliNome;
    }

    public void setCliNome(String cliNome) {
        this.cliNome = cliNome;
    }

    public String getCliCpf() {
        return cliCpf;
    }

    public void setCliCpf(String cliCpf) {
        this.cliCpf = cliCpf;
    }

    public String getCliStatus() { return cliStatus; }

    public void setCliStatus(String cliStatus) { this.cliStatus = cliStatus; }

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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}