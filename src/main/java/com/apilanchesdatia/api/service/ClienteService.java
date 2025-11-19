package com.apilanchesdatia.api.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apilanchesdatia.api.models.Cliente;
import com.apilanchesdatia.api.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repositorio;

    public List<Cliente> listarTodos() {
        return repositorio.findByAtivoTrue();
    }

    public Cliente buscarPorId(Long id) {

        if (id == null) return null; // ✅ remove warning

        return repositorio.findById(id).orElse(null);
    }

    public Cliente buscarPorEmail(String email) {
        return repositorio.findByEmail(email);
    }

    public Cliente adicionarCliente(Cliente cliente) {

        cliente.setAtivo(true);
        cliente.setDataCadastro(LocalDateTime.now());
        cliente.setPedidos("");
        cliente.setHistoricoCompras("");

        return repositorio.save(cliente);
    }

    public Cliente atualizarCliente(Long id, Cliente atualizar) {

        if (id == null) return null; // ✅ remove warning

        Cliente cliente = repositorio.findById(id).orElse(null);
        if (cliente == null) return null;

        cliente.setNomeCompleto(atualizar.getNomeCompleto());
        cliente.setTelefone(atualizar.getTelefone());
        cliente.setEndereco(atualizar.getEndereco());
        cliente.setPreferencias(atualizar.getPreferencias());
        cliente.setEmail(atualizar.getEmail());
        cliente.setCpf(atualizar.getCpf());
        cliente.setAtivo(atualizar.isAtivo());

        return repositorio.save(cliente);
    }
}
