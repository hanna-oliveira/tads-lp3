package br.edu.ifsp.orderflow.domain;

import java.math.BigDecimal;

public class Produto {
    private final String id;
    private final String nome;
    private final BigDecimal preco;

    //construtores
    public Produto(String id, String nome, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    //getters
    public String getId() {return this.id;}
    public String getNome() {return this.nome;}
    public BigDecimal getPreco() {return this.preco;}

    @Override
    public String toString () {
        return nome + "(R$" + this.preco + ")";
    }
}

