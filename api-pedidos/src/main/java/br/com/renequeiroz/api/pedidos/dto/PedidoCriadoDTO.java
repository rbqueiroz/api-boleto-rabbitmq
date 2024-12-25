package br.com.renequeiroz.api.pedidos.dto;

import br.com.renequeiroz.api.pedidos.enums.Status;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record PedidoCriadoDTO(
        Long id,
        HttpStatus httpStatus,
        Status status,
        String dataPedido
) {
}
