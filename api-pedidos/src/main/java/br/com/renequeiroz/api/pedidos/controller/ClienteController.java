package br.com.renequeiroz.api.pedidos.controller;

import br.com.renequeiroz.api.pedidos.business.ClienteBusiness;
import br.com.renequeiroz.api.pedidos.dto.ClienteDTO;
import br.com.renequeiroz.api.pedidos.entity.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    private final Logger logger = LoggerFactory.getLogger(ClienteController.class);
    private final ClienteBusiness business;

    public ClienteController(ClienteBusiness business) {
        this.business = business;
    }

    @GetMapping
    public ResponseEntity<Cliente> findById(@RequestParam Long id) {
        Cliente cliente = business.findById(id);
        if (cliente == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> save(ClienteDTO clienteDTO) {
        ClienteDTO c = business.save(clienteDTO);
        if (c == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.info("Novo cliente salvo {}", c);
        return ResponseEntity.ok(c);
    }
}
