package br.edu.ifsp.orderflow.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pedido {
    private final String id;
    private final Cliente cliente;
    private final List<ItemPedido> itens;
    private EStatusPedido status;


    public Pedido(Cliente cliente) {
        this.id = (UUID.randomUUID()).toString();
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.status = EStatusPedido.CRIADO;
    }

    public void adicionarItem (ItemPedido itens) {
        this.itens.add(itens);
    }
    public BigDecimal calcularTotal(){

        BigDecimal total = BigDecimal.ZERO;

        for (int indice = 0; indice < this.itens.size(); indice++) {
            ItemPedido item = this.itens.get(indice);
            total = total.add(item.calcularSubtotal());
        }

        return total;
    }

    public void marcarComoPago(){
        this.status = EStatusPedido.PAGO;
    }

    public void cancelar(){
        this.status = EStatusPedido.CANCELADO;
    }

    //*GETTERS
    public String getId() {return id;}
    public Cliente getCliente() {return cliente;}
    public List<ItemPedido> getItens() {return itens;}
    public EStatusPedido getStatus() {return status;}

    @Override
    public String toString(){
        return "Pedido[" + this.id + ", " + this.status + ", " + this.calcularTotal() + "]";
    }
}
