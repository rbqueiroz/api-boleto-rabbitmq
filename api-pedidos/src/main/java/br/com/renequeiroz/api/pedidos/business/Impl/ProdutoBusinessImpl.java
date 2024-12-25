package br.com.renequeiroz.api.pedidos.business.Impl;

import br.com.renequeiroz.api.pedidos.business.ProdutoBusiness;
import br.com.renequeiroz.api.pedidos.dto.ProdutoDTO;
import br.com.renequeiroz.api.pedidos.entity.Produto;
import br.com.renequeiroz.api.pedidos.exceptions.ErrorAoSalvarException;
import br.com.renequeiroz.api.pedidos.repository.ProdutoRepository;
import br.com.renequeiroz.api.pedidos.utils.MapperUtils;
import org.springframework.stereotype.Service;

@Service
public class ProdutoBusinessImpl implements ProdutoBusiness {

    private final ProdutoRepository repository;

    public ProdutoBusinessImpl(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProdutoDTO salvarProduto(ProdutoDTO produtoDTO) throws ErrorAoSalvarException {
        Produto produto = MapperUtils.converterParaEntidade(produtoDTO, Produto.class);
        produto = repository.save(produto);
        if (produto == null) {
            throw new ErrorAoSalvarException();
        }
        return MapperUtils.converterProdutoParaDTO(produto);
    }
}
