package org.example.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRO_ID")
    private Long proId;

    @ManyToOne
    @JoinColumn(name = "FOR_ID")
    private Fornecedor idFornecedor;

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
    @Column(name = "PRO_NOME", length = 100, nullable = false)
    private String proNome;

    @NotNull(message = "Preço de Custo é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "Preço de Custo deve ser maior que zero")
    @Column(name = "PRO_PRECO_CUSTO", precision = 10, scale = 2, nullable = false)
    private Double proPrecoCusto;

    @NotNull(message = "Preço de Venda é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "Preço de Venda deve ser maior que zero")
    @Column(name = "PRO_PRECO_VENDA", precision = 10, scale = 2, nullable = false)
    private Double proPrecoVenda;

    @NotBlank(message = "Marca obrigatorio ")
    @Size(max = 50, message = "Marca deve ter no máximo 50 caracteres")
    @Column(name = "PRO_MARCA", length = 50, nullable = false)
    private String proMarca;

    @NotNull(message = "Estoque obrigatorio")
    @Min(value = 0, message = "Estoque não pode ser negativo")
    @Column(name = "PRO_ESTOQUE", nullable = false)
    private Integer proEstoque;

    @NotBlank(message = "Descrição é obrigatória")
    @Size(max = 255, message = "Descrição deve ter no máximo 255 caracteres")
    @Column(name = "PRO_DESCRICAO", length = 255, nullable = false)
    private String proDescricao;

    @NotBlank(message = "Categoria é obrigatória")
    @Size(max = 50, message = "Categoria deve ter no máximo 50 caracteres")
    @Column(name = "PRO_CATEGORIA", length = 50, nullable = false)
    private String proCategoria;

    @NotBlank(message = "Código de Barras é obrigatória")
    @Size(max = 30, message = "Código de Barras deve ter no máximo 30 caracteres")
    @Column(name = "PRO_CODIGO_BARRAS", length = 30, nullable = false)
    private String proCodigoBarras;

    @Column(name = "PRO_DATA_CADASTRO", nullable = false)
    private Date proDataCadastro;

    @Column(name = "PRO_DATA_ATUALIZACAO", nullable = false)
    private Date proDataAtualizacao;

    @NotBlank(message = "Status Ativo é obrigatório")
    @Size(max = 10, message = "Status Ativo deve ter no máximo 10 caracteres")
    @Column(name = "PRO_ATIVO", nullable = false, length = 10)
    private String proAtivo;

    @NotNull(message = "Campo frete grátis é obrigatório")
    @Column(name = "PRO_FRETE_GRATIS", nullable = false)
    private String proFreteGratis;

    public Produto() {
    }

    public Produto(Long proId, Fornecedor idFornecedor, String proNome, Double proPrecoCusto, Double proPrecoVenda, String proMarca, Integer proEstoque, String proDescricao, String proCategoria, String proCodigoBarras, Date proDataCadastro, Date proDataAtualizacao, String proAtivo, String proFreteGratis) {
        this.proId = proId;
        this.idFornecedor = idFornecedor;
        this.proNome = proNome;
        this.proPrecoCusto = proPrecoCusto;
        this.proPrecoVenda = proPrecoVenda;
        this.proMarca = proMarca;
        this.proEstoque = proEstoque;
        this.proDescricao = proDescricao;
        this.proCategoria = proCategoria;
        this.proCodigoBarras = proCodigoBarras;
        this.proDataCadastro = proDataCadastro;
        this.proDataAtualizacao = proDataAtualizacao;
        this.proAtivo = proAtivo;
        this.proFreteGratis = proFreteGratis;
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public Fornecedor getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Fornecedor idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getProNome() {
        return proNome;
    }

    public void setProNome(String proNome) {
        this.proNome = proNome;
    }

    public Double getProPrecoCusto() {
        return proPrecoCusto;
    }

    public void setProPrecoCusto(Double proPrecoCusto) {
        this.proPrecoCusto = proPrecoCusto;
    }

    public Double getProPrecoVenda() {
        return proPrecoVenda;
    }

    public void setProPrecoVenda(Double proPrecoVenda) {
        this.proPrecoVenda = proPrecoVenda;
    }

    public String getProMarca() {
        return proMarca;
    }

    public void setProMarca(String proMarca) {
        this.proMarca = proMarca;
    }

    public Integer getProEstoque() {
        return proEstoque;
    }

    public void setProEstoque(Integer proEstoque) {
        this.proEstoque = proEstoque;
    }

    public String getProDescricao() {
        return proDescricao;
    }

    public void setProDescricao(String proDescricao) {
        this.proDescricao = proDescricao;
    }

    public String getProCategoria() {
        return proCategoria;
    }

    public void setProCategoria(String proCategoria) {
        this.proCategoria = proCategoria;
    }

    public String getProCodigoBarras() {
        return proCodigoBarras;
    }

    public void setProCodigoBarras(String proCodigoBarras) {
        this.proCodigoBarras = proCodigoBarras;
    }

    public Date getProDataCadastro() {
        return proDataCadastro;
    }

    public void setProDataCadastro(Date proDataCadastro) {
        this.proDataCadastro = proDataCadastro;
    }

    public Date getProDataAtualizacao() {
        return proDataAtualizacao;
    }

    public void setProDataAtualizacao(Date proDataAtualizacao) {
        this.proDataAtualizacao = proDataAtualizacao;
    }

    public String getProAtivo() {
        return proAtivo;
    }

    public void setProAtivo(String proAtivo) {
        this.proAtivo = proAtivo;
    }

    public String getProFreteGratis() {
        return proFreteGratis;
    }

    public void setProFreteGratis(String proFreteGratis) {
        this.proFreteGratis = proFreteGratis;
    }
}