package com.example.produto.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.produto.model.Produto;
import com.example.produto.repository.ProdutoRepository;

@Service
public class ProdutoService {
    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public Produto atualizar(Long id, Produto produtoAtualizado) {
        Produto produto = repository.findById(id).orElse(null);
        if (produto != null) {
            produto.setNome(produtoAtualizado.getNome());
            produto.setPreco(produtoAtualizado.getPreco());
            return repository.save(produto);
        }
        return null;
    }

    public String deletar(Long id){
        Produto produto = repository.findById(id).orElse(null);
        if (produto != null) {
            repository.deleteById(id);
            return "Produto deletado!";
        }
        return "Produto não encontrado";
    }
}
