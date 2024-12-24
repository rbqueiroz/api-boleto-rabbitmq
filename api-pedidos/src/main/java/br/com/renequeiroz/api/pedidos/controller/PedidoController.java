package br.com.renequeiroz.api.pedidos.controller;

import br.com.renequeiroz.api.pedidos.entity.Pedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/v1/pedido")
public class PedidoController {

    private final Logger logger = LoggerFactory.getLogger(PedidoController.class);

    @PostMapping
    public ResponseEntity<Pedido> cricarPedido(@RequestBody Pedido pedido) {
        logger.info("Criando pedido {}", pedido);
        return ResponseEntity.ok(pedido);
    }
}
