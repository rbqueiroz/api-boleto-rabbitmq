package br.com.renequeiroz.api.pedidos.controller;

import br.com.renequeiroz.api.pedidos.business.ClienteBusiness;
import br.com.renequeiroz.api.pedidos.entity.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

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
}
