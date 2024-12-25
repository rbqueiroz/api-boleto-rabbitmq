package br.com.renequeiroz.api.pedidos.business;

import br.com.renequeiroz.api.pedidos.dto.ProdutoDTO;
import br.com.renequeiroz.api.pedidos.exceptions.ErrorAoSalvarException;

public interface ProdutoBusiness {
    ProdutoDTO salvarProduto(ProdutoDTO produtoDTO) throws ErrorAoSalvarException;
}
