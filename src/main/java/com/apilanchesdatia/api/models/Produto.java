package com.apilanchesdatia.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Data
public class Produto {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

@Column(unique=true)
private String nome;
private String descricao;
private double preco;
private String categoria;
private boolean disponivel=true;
private int tempoPreparo;
}