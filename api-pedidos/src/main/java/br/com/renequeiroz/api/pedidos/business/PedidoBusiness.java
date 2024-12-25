package br.com.renequeiroz.api.pedidos.business;

import br.com.renequeiroz.api.pedidos.dto.PedidoCriadoDTO;
import br.com.renequeiroz.api.pedidos.entity.Pedido;
import br.com.renequeiroz.api.pedidos.exceptions.ErrorAoSalvarException;

public interface PedidoBusiness {
    PedidoCriadoDTO processarPedido(Pedido pedido) throws ErrorAoSalvarException;
}
