package br.com.renequeiroz.api.pedidos.controller;

import br.com.renequeiroz.api.pedidos.business.ProdutoBusiness;
import br.com.renequeiroz.api.pedidos.dto.ProdutoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/produto")
public class ProdutoController {

    private final Logger logger = LoggerFactory.getLogger(ProdutoController.class);
    private final ProdutoBusiness business;

    public ProdutoController(ProdutoBusiness business) {
        this.business = business;
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> salvarProduto(ProdutoDTO produtoDTO) {
        ProdutoDTO p = business.salvarProduto(produtoDTO);
        if(p == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.info("Novo produto salvo {}", p);
        return ResponseEntity.ok(p);
    }
}