package com.apilanchesdatia.api.models;


import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cliente{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto;
    private String email;
    private LocalDateTime dataCadastro;
    private boolean ativo=true;
    private String preferencias;
    private String historicoCompras;
    private String cpf;
    private String pedidos;
    public Object getTelefone() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getTelefone'");
    }
    public Object getEndereco() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getEndereco'");
    }
    public void setEndereco(Object endereco) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setEndereco'");
    }
    public void setTelefone(Object telefone) {
    
        throw new UnsupportedOperationException("Unimplemented method 'setTelefone'");
    }

}