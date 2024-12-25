package br.com.renequeiroz.api.pedidos.business.Impl;

import br.com.renequeiroz.api.pedidos.business.PedidoBusiness;
import br.com.renequeiroz.api.pedidos.dto.PedidoCriadoDTO;
import br.com.renequeiroz.api.pedidos.entity.ItemPedido;
import br.com.renequeiroz.api.pedidos.entity.Pedido;
import br.com.renequeiroz.api.pedidos.exceptions.ErrorAoSalvarException;
import br.com.renequeiroz.api.pedidos.repository.ItemPedidoRepository;
import br.com.renequeiroz.api.pedidos.repository.PedidoRepository;
import br.com.renequeiroz.api.pedidos.services.RabbitMqService;
import br.com.renequeiroz.api.pedidos.utils.MapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PedidoBusinessImpl implements PedidoBusiness {

    private final Logger logger = LoggerFactory.getLogger(PedidoBusinessImpl.class);
    private final PedidoRepository repository;
    private final RabbitMqService rabbitMqService;

    public PedidoBusinessImpl(PedidoRepository repository, ItemPedidoRepository itemPedidoRepository, RabbitMqService rabbitMqService) {
        this.repository = repository;
        this.rabbitMqService = rabbitMqService;
    }

    private Pedido salvarPedido(Pedido pedido){
        logger.info("Salvando pedido {}", pedido);
        return repository.save(pedido);
    }

    @Override
    public PedidoCriadoDTO processarPedido(Pedido pedido) throws ErrorAoSalvarException {
        if(pedido.getItensPedido() == null || pedido.getItensPedido().isEmpty()) {
            throw new ErrorAoSalvarException("Pedido sem itens");
        }
        setItemNoPedido(pedido);
        pedido.setDataPedido(LocalDateTime.now());
        pedido = salvarPedido(pedido);
        pedido = rabbitMqService.sendMessage(pedido);
        return new PedidoCriadoDTO(pedido.getId(), HttpStatus.CREATED, pedido.getStatus(), MapperUtils.formatarDataDTO(pedido.getDataPedido()));
    }

    private void setItemNoPedido(Pedido pedido) {
        Double valorTotal = 0.0;
        for (ItemPedido itemPedido : pedido.getItensPedido()) {
            if(itemPedido.getProduto() == null || itemPedido.getQuantidade() == null) {
                throw new ErrorAoSalvarException("A Itens invalidos no pedido");
            }
            itemPedido.setPedido(pedido);
            valorTotal += itemPedido.getProduto().getValor() * itemPedido.getQuantidade();
        }
        pedido.setValorTotal(valorTotal);
    }
}
