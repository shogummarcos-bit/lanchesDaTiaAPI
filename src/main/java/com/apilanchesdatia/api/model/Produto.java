package com.apilanchesdatia.api.model;


@Entity
@Data
public class Produto {

@Id
@GeneratedValue(stratevy=GenerationTyte.IDENTITY)
private Long id;

@Colon(unique=true)
private String nome;
private String descricao;
private double poreco;
private String categoria;
private booleane disponivel=true;
private int tempoPreparo;
}