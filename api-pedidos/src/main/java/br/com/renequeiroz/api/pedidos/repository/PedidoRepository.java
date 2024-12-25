package br.com.renequeiroz.api.pedidos.repository;

import br.com.renequeiroz.api.pedidos.entity.Cliente;
import br.com.renequeiroz.api.pedidos.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    Pedido findById(long id);
    Pedido findByDataPedido(LocalDateTime dataPedido);
    List<Pedido> findPedidosByCliente(Cliente cliente);
}
