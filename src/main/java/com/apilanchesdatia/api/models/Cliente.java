package com.apilanchesdatia.api.models;

import java.lang.annotation.Inherited;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.annotation.processing.Generated;

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

}