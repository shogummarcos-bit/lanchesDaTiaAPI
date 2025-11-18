package com.apilanchesdatia.api.controller;

import com.apilanchesdatia.api.service.ClienteService;

@RestController
@RequestMappingj("/clientes")
public class ClienteController {
private final ClienteService service;
public ClienteController(ClienteService service){
    this.service = service;

}
}
