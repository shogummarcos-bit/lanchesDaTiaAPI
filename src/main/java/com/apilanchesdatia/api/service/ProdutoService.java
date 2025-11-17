package com.apilanchesdatia.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apilanchesdatia.api.models.Produto;
import com.apilanchesdatia.api.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;


@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listarTodos(){
        return repository.findByDisponivelTrue();
    }

    public List<Produto> listarIndisponiveis(){
        return repository.findByDisponivelFalse();
    }

    public Optional<Produto> buscarPorId(Long id){
        return repository.findById(id);
    }

    public List<Produto> buscarPorCategoria(String categoria){
        return repository.findByCategoria(categoria);
    }

    public Produto adicionarProduto(Produto produto){

        if(produto.getPreco() <= 0){
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }

        if(repository.existsByNome(produto.getNome())){
            throw new IllegalArgumentException("Já existe um produto com esse nome.");
        }

        produto.setDisponivel(true);
        produto.setTempoPreparo(definirTempoPreparo(produto.getCategoria()));

        return repository.save(produto);
    }

    public Produto atualizarProduto(Long id, Produto produtoAtualizado){

        Produto produto = repository.findById(id).orElse(null);
        if(produto == null) return null;

        produto.setNome(produtoAtualizado.getNome());
        produto.setDescricao(produtoAtualizado.getDescricao());
        produto.setPreco(produtoAtualizado.getPreco());
        produto.setCategoria(produtoAtualizado.getCategoria());
        produto.setDisponivel(produtoAtualizado.isDisponivel());
        produto.setTempoPreparo(produtoAtualizado.getTempoPreparo());

        return repository.save(produto);
    }

    public void deletarProduto(Long id){
        repository.deleteById(id);
    }

    private int definirTempoPreparo(String categoria){
        return switch (categoria.toLowerCase()) {
            case "lanches" -> 12;
            case "bebidas" -> 3;
            case "acompanhamentos" -> 9;
            case "sobremesas" -> 5;
            default -> 10;
        };
    }
}
