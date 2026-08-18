package br.edu.ifsp.orderflow.domain;

import java.math.BigDecimal;

public class ItemPedido {
    private final Produto produto;
    private final int quantidade;

    //construtor
    public ItemPedido (Produto produto , int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    //getter
    public Produto getProduto() {return this.produto;}
    public int getQuantidade() {return this.quantidade;}

    public BigDecimal calcularSubtotal(){
        return this.produto.getPreco().multiply(BigDecimal.valueOf(this.quantidade));
    }

    @Override
    public String toString() {
        return this.quantidade + "x " + this.produto.getNome();
    }
}
