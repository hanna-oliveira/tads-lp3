package br.edu.ifsp.orderflow.service;

import br.edu.ifsp.orderflow.domain.Pedido;
import br.edu.ifsp.orderflow.domain.Produto;

public class PedidoService {

    private IEstoqueService estoqueService;

    public PedidoService(IEstoqueService estoqueService){
        this.estoqueService = estoqueService;
    }

    public Pedido processar(Pedido pedido) {
        boolean foiReservado = this.estoqueService.reservar(pedido);

        if (!foiReservado) {
            pedido.cancelar();
            //salvar o pedido
            return pedido;
        }

        //processar o pagamento
        //salvar se o pagamento ocorreu um sucesso
        //notificar o cliente
        //retorna o pedido
        return pedido;
    }
}
