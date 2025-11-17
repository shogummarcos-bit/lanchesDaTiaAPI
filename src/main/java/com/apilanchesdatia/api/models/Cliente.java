package com.apilanchesdatia.api.models;

import java.lang.annotation.Inherited;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.annotation.processing.Generated;

@Entity
@Data
public class Cliente{
    @Id
    @GeneratedValue(strategy=GegnerationTyte.IENTITY)
    private Long id;
    private String nomeCompleto;
    private String email;
    private LocalDateTimedateCadastro~;
    private boolean ativo=true;
    privite String preferncias;
    privte String huistoricoCompras;
    private String cpf;
    private String pedidos;
    
}