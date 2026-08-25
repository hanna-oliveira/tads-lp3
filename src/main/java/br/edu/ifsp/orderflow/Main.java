package br.edu.ifsp.orderflow;

import br.edu.ifsp.orderflow.domain.Cliente;
import br.edu.ifsp.orderflow.domain.ItemPedido;
import br.edu.ifsp.orderflow.domain.Pedido;
import br.edu.ifsp.orderflow.domain.Produto;
import br.edu.ifsp.orderflow.infra.InMemoryEstoqueService;
import br.edu.ifsp.orderflow.service.IEstoqueService;

import java.math.BigDecimal;
import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {

        IEstoqueService estoqueService = new InMemoryEstoqueService();

        Produto mouse = new Produto(
                "SKU-1",
                "Mouse sem fio",
                new BigDecimal("120.00")
        );

        Produto teclado = new Produto(
                "SKU-2",
                "Teclado Mecânico",
                new BigDecimal("350.00")
        );

        Produto monitor = new Produto(
                "SKU-3",
                "Monitor 27 pol",
                new BigDecimal("1800.00")
        );

        estoqueService.adicionarEstoque(mouse, 10);
        estoqueService.adicionarEstoque(teclado, 6);
        estoqueService.adicionarEstoque(monitor, 2);

        Cliente ana = new Cliente("Ana", "ana@email.com");
        Cliente bruno = new Cliente("Bruno", "bruno@email.com");

        Pedido pedido1 = new Pedido(ana);
        pedido1.adicionarItem(new ItemPedido(mouse, 2));
        pedido1.adicionarItem(new ItemPedido(teclado, 2));

        boolean reservado = estoqueService.reservar(pedido1);

        if (reservado == false) {
            System.out.println("Não foi reservado.");
        }

        Pedido pedido2 = new Pedido(bruno);
        pedido2.adicionarItem(new ItemPedido(monitor, 2));
        pedido2.adicionarItem(new ItemPedido(teclado, 5));

        InMemoryEstoqueService estoque = new InMemoryEstoqueService();

        estoque.adicionarEstoque(mouse, 1);
        estoque.adicionarEstoque(mouse, 1);
        System.out.println(pedido1);
    }
}