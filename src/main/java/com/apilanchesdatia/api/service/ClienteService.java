package com.apilanchesdatia.api.service;

import com.apilanchesdatia.api.repository.ClienteRepository;

@Service
public class ClienteService {
@Autowilid
private ClienteRepository repositorio;
public List<Cliente> ListarTodos(){
    return repositorio.findByAtivotrue();
}
}
