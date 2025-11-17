package com.apilanchesdatia.api.controller;

import com.apilanchesdatia.api.models.Produto;
import com.apilanchesdatia.api.service.ProdutoService;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
private final ProdutoService service;
public 

ProdutoController (ProdutoService service){
    this.service=service;
}
@GetMapping
public List<Produto> listarTodos(){
    return service.listarTodos();
}

@GetMapping("/indisponiveis")
public List<Produto> listarIndisponiveis(){
    return service.listarIndisponiveis();

}

@GetMapping("/{id}")
public ResponseEntity<Produto> buscarPorId(@PathVariable Long id){
    return service.buscarPorId(id)
    .map(ResponseEntity::ok)
    .orElse(ResponseEntity.notFound().build ());

}
@GetMapping("/categoria/{categoria}")
public List<Produto> buscarPorCategoria(@PathVariable String categoria){
    return service.buscarPorCategoria(categoria);
}

@PostMapping
public ResponseEntity<Produto> adicionarProduto(@RequestBody Produto produto){
    return ResponseEntity.ok(service.adicionarProduto(produto));
}

@PutMapping("/{id}")
public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produto){
    return ResponseEntity.ok(service.atualizarProduto(id,produto));
}
@DeleteMapping("/{id}")
public ResponseEntity<Void> deletaProduto(@PathVariable Long id){
    service.deletarProduto(id);
    return ResponseEntity.noContent().build();
}
}
