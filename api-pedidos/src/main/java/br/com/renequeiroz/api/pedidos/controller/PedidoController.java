package br.com.renequeiroz.api.pedidos.controller;

import br.com.renequeiroz.api.pedidos.business.PedidoBusiness;
import br.com.renequeiroz.api.pedidos.dto.PedidoCriadoDTO;
import br.com.renequeiroz.api.pedidos.entity.Pedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/v1/pedido")
public class PedidoController {

    private final Logger logger = LoggerFactory.getLogger(PedidoController.class);

    private final PedidoBusiness business;

    public PedidoController(PedidoBusiness business) {
        this.business = business;
    }

    @PostMapping
    public ResponseEntity<PedidoCriadoDTO> cricarPedido(@RequestBody Pedido pedido) {
        PedidoCriadoDTO pedidoCriadoDTO = business.processarPedido(pedido);
        if(pedidoCriadoDTO == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.info("Novo pedido feito{}", pedido);
        return ResponseEntity.ok(pedidoCriadoDTO);
    }
}
