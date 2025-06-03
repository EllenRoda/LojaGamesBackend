package org.example.entities;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLI_ID")
    private Long cliId;

    @NotBlank(message = "Nome é Obrigatório")
    @Size(max = 100, message = "Nome deve ter no máximo 100 Caracteres")
    @Column(name = "CLI_NOME", nullable = false, length = 100)
    private String cliNome;

    @NotBlank(message = "CPF é Obrigatório")
    @CPF(message = "CPF Inválido")
    @Column(name = "CLI_CPF", nullable = false, unique = true, length = 15)
    private String cliCpf;

    @NotBlank(message = "Email é Obrigatório")
    @Email(message = "Email Inválido")
    @Size(max = 50, message = "Email deve ter no máximo 50 Caracteres")
    @Column(name = "CLI_EMAIL", nullable = false, length = 50)
    private String cliEmail;

    @NotBlank(message = "Telefone é Obrigatório")
    @Size(max = 14, message = "Telefone deve ter no máximo 14 Caracteres")
    @Column(name = "CLI_TELEFONE", nullable = false, length = 14)
    private String cliTelefone;

    @NotBlank(message = "Status é Obrigatório")
    @Size(max = 60, message = "Status deve ter no máximo 60 Caracteres")
    @Column(name = "CLI_STATUS", nullable = false, length = 60)
    private String cliStatus;

    public Cliente() {
    }

    public Cliente(Long cliId, String cliNome, String cliCpf, String cliEmail, String cliTelefone, String cliStatus) {
        this.cliId = cliId;
        this.cliNome = cliNome;
        this.cliCpf = cliCpf;
        this.cliEmail = cliEmail;
        this.cliTelefone = cliTelefone;
        this.cliStatus = cliStatus;
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

    public String getCliEmail() {
        return cliEmail;
    }

    public void setCliEmail(String cliEmail) {
        this.cliEmail = cliEmail;
    }

    public String getCliTelefone() {
        return cliTelefone;
    }

    public void setCliTelefone(String cliTelefone) {
        this.cliTelefone = cliTelefone;
    }

    public String getCliStatus() { return cliStatus; }

    public void setCliStatus(String cliStatus) { this.cliStatus = cliStatus; }
}