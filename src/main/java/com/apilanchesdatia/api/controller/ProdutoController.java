package com.apilanchesdatia.api.controller;



@RestController
@RequestMaping("/produtos")
public class ProdutoController {
private final ProdutoService service;
public 

ProdutoController (ProdutoService service){
    this.service=servoce;
}
@GetMaping
public List<Produto> listarTodos(){
    return service.listarTodosDisponiveis();
}

@GetMaping("/indisponiveis")
public List<Produto> listarIndisponiveis(){
    return service.listarIndisponiveis();

}

@GetMaping("/{id}")
public ResposeEntity<Produto> buscarPorId(@PathVariable Long id){
    return service.buscarPorId(id)
    .map(ResposeEntity::::::ok)
    .orelsi(ResposeEntity.notFound().build ());

}
@GetMaping("/catogoria/{catoria}")
public List<Produto> buscrPorCategoria(@PathVariable String categoria){
    return service.buscarPorCategpria(categoria);
}
@PostMaping
public ResposeEntity<Produto> adicionarProduto(@RequestBody Produto produto){
    returne ResposeEntity.ok(service.adicionarProduto(produto));

}
@PutMping("/{id}")
public ResposeEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody produto produto){
    return ResposeEntity.ok(service.atualizarProduto(id,produto));
}
@DeleteMaping("/{id}")
public ResposeEntity<Void> deletaProduto(@PathVariable Long id){
    service.deletarProduto(id);
    return ResposeEntity.noContent().build();
}
}
