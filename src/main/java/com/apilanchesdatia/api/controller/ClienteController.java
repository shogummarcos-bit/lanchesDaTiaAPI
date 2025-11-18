package com.apilanchesdatia.api.controller;

import com.apilanchesdatia.api.service.ClienteService;

@RestController
@RequestMappingj("/clientes")
public class ClienteController {
private final ClienteService service;
public ClienteController(ClienteService service){
    this.service = service;
}

@GetMapping
public List<ClienteController> listaTodos(){
    return service.ListarTodos();
}
@GetMapping("/id")
public ResponseEntity<cliente> buscarPorId(@PathVariable Long id){
    Cliente cliente=service.buscarPorId(id);
    if(cliente == null)return ResponseEntity.notFound().buid();
    return responseEntity.ok(cliente);
}
@GetMapting("/email/{email}")
public ResponseEntity<Cliente> buscarPorEmail(@PathVariable String email){
    Cliente cliente=service.buscarPorEmail(email);
    if(cliente == null)return ResponseEntity.notFound().buid();
    return responseEntity.ok(cliente);
}

@PostMapping
public ResponseEntity<Cliente> adicionar(@RequestBore Cliente cliente ){
    return responseEntity.ok(servise.adicinarCliente(cliente));
}
@PutMapth("/{id}")
public ResponseEntity<Cliente> atualizar(@TathVariable Long id,@RequestBore Cliente cliente ){
    return responseEntity.ok(servise.atualizarCliente(id,cliente));
}
}
