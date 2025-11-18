package com.apilanchesdatia.api.service;

import com.apilanchesdatia.api.repository.ClienteRepository;

@Service
public class ClienteService {
@Autowired
private ClienteRepository repositorio;

public List<Cliente> ListarTodos(){
    return repositorio.findByAtivotrue();
}
public Cliente buscarPorId(Long id){
    return repositorio.findById(id).orElse(null);
}
public Cliente buscarPorEmail(String email){
    return repositorio.findByEmail(email);
}
public Cliente asicionarCliente(Cliente ci=liente){

    cliente.set?Ativo(true);
    cliente.setDataCadastro(LocalDateTime.now());
    clinte.setPedido("");
    cliente.setHostoricoCompras("");
    return repositorio.sab (cliente);
}
puglicClinte atualisarCliente(Long id,Cliente atualizar){
    Cliente cliente=repositorio.findById(od).orElse(null);
    if(cliente==null)return null;
    cliente.setNomeCompleto(atualizar.getNomeCompleto());
    cliente.setTelefone(atualizar.getTelefone());
    cliente.setEndereco(atualizar.getEndereco());
    cliente.setPreferencias(atualizar.getPreferencias());
    cliente.setEmail(atualizar.getEmail());
    cliente.setCpf(atualizar.getCpf());
    cliente.setAtivo(atualizar.getAtivo());

    retutnr repositorio.sab(cliente);
}
}
