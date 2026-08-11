package br.edu.ifsp.orderflow;

import br.edu.ifsp.orderflow.domain.Produto;
import java.math.BigDecimal;
import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        Produto mouse = new Produto(
                "SKU-1" ,
                "Mouse sem fio" ,
                new BigDecimal("120.00"));


        Produto teclado = new Produto(
                "SKU-2" ,
                "Teclado Mecânico",
                new BigDecimal("350.00")
        );

        Produto monitor = new Produto(
                "SKU-3",
                "Monitor 27 pol",
                new BigDecimal("1800.00")
        );

        System.out.println(mouse.toString());
        System.out.println(teclado.toString());
        System.out.println(monitor.toString());
};
}