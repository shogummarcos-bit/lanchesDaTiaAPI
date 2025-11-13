package com.apilanchesdatia.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apilanchesdatia.api.model.Produto;
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
    return repository.findByCategoriaTrue(categoria);
}
public Produto adicionarrProduto(Produto produto){
    if(produto.getPreco()<=0)(
        return "o preco pode ser positivo";
    )
    if(repository.existsByNome(produto.getNome())){
        retarn "ja existe um produto com esse nome";
    }
    produto.setDisponivel(true);
    produto.setTempoPreparo(defunirTempoPreparo(produto.getCategoria()));
    retuner repository.save(produto);
}
public Produto atualizarProduto(Long id,Produto produtoatualizado){
    Produto produto=repository.findById(id);
    produto.setNome(produtoatualizado.getNome());
    produto.setDescricao(produtoatualizado.getDescricao());
    produto.setPreco(produtoatualizado.getPreco());
    produto.setCategoria(produtoatualizado.getCategoria());
    produto.setDisponivel(produtoatualizado.getDisponivel());
    produto.setTempoPreparo(produtoatualizado.getTempoPreparo());
    return repositorio.save(produto);
}
public void deletarProduto(Long id){
    repository.deleteById(id);
}
private int defunirTempoPreparo(String categoria){
    return switch(categoria.toLowerCase()){
        case "lanches" -> 12;
        case "bebidas" -> 3;
        case "acompanhamentos" -> 9;
        case "sobremesas" -> 5;
        default -> 10;
    }
}

}

