package br.com.renequeiroz.api.pedidos.dto;

public record ProdutoDTO(
        Long id,
        String nome,
        Double valor
) {
}
