package com.apilanchesdatia.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.apilanchesdatia.api.models.Cliente;
import com.apilanchesdatia.api.service.ClienteService;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
private final ClienteService service;
public ClienteController(ClienteService service){
    this.service = service;
}

@GetMapping
public List<Cliente> listaTodos(){
    return service.listarTodos();
}
@GetMapping("/id")
public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
    Cliente cliente=service.buscarPorId(id);
    if(cliente == null)return ResponseEntity.notFound().build();
    return ResponseEntity.ok(cliente);
}
@GetMapping("/email/{email}")
public ResponseEntity<Cliente> buscarPorEmail(@PathVariable String email){
    Cliente cliente=service.buscarPorEmail(email);
    if(cliente == null)return ResponseEntity.notFound().build();
    return ResponseEntity.ok(cliente);
}

@PostMapping
public ResponseEntity<Cliente> adicionar(@RequestBody Cliente cliente ){
    return ResponseEntity.ok(service.adicionarCliente(cliente));
}
@PutMapping("/{id}")
public ResponseEntity<Cliente> atualizar(@PathVariable Long id,@RequestBody Cliente cliente ){
    return ResponseEntity.ok(service.atualizarCliente(id,cliente));
}
}
