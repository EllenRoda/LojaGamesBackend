package org.example.services;

import org.example.entities.Produto;
import org.example.repositories.ProdutoRepository;
import org.example.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> getAll() {
        return repository.findAll();
    }

    public Produto findById(Long id) {
        Optional<Produto> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Produto insert(Produto produto) {
        return repository.save(produto);
    }

    public boolean update(Long id, Produto produto) {
        Optional<Produto> optionalProduto = repository.findById(id);
        if (optionalProduto.isPresent()) {
            Produto produtoSistema = optionalProduto.get();
            produtoSistema.setProNome(produto.getProNome());
            produtoSistema.setProPrecoCusto(produto.getProPrecoCusto());
            produtoSistema.setProPrecoVenda(produto.getProPrecoVenda());
            produtoSistema.setProMarca(produto.getProMarca());
            produtoSistema.setProModelo(produto.getProModelo());
            produtoSistema.setProEstoque(produto.getProEstoque());
            produtoSistema.setProCor(produto.getProCor());
            produtoSistema.setProMaterial(produto.getProMaterial());
            produtoSistema.setProFabricante(produto.getProFabricante());
            produtoSistema.setProDescricao(produto.getProDescricao());
            produtoSistema.setProCategoria(produto.getProCategoria());
            produtoSistema.setProCodigoBarras(produto.getProCodigoBarras());
            produtoSistema.setProDataCadastro(produto.getProDataCadastro());
            produtoSistema.setProDataAtualizacao(produto.getProDataAtualizacao());
            produtoSistema.setProAtivo(produto.getProAtivo());
            produtoSistema.setProFreteGratis(produto.getProFreteGratis());
            repository.save(produtoSistema);
            return true;
        }
        return false;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}