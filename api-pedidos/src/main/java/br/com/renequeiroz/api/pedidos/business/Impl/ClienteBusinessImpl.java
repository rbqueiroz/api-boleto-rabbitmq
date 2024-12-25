package br.com.renequeiroz.api.pedidos.business.Impl;

import br.com.renequeiroz.api.pedidos.business.ClienteBusiness;
import br.com.renequeiroz.api.pedidos.dto.ClienteDTO;
import br.com.renequeiroz.api.pedidos.entity.Cliente;
import br.com.renequeiroz.api.pedidos.exceptions.ClienteNaoEncontradoException;
import br.com.renequeiroz.api.pedidos.exceptions.ErrorAoSalvarException;
import br.com.renequeiroz.api.pedidos.repository.ClienteRepository;
import br.com.renequeiroz.api.pedidos.utils.MapperUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteBusinessImpl implements ClienteBusiness {

    private final Logger logger = org.slf4j.LoggerFactory.getLogger(ClienteBusinessImpl.class);
    private final ClienteRepository repository;

    public ClienteBusinessImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Cliente> findAll() {
        return List.of();
    }

    @Override
    public Cliente findById(Long id) throws ClienteNaoEncontradoException {
        return repository.findById(id).orElseThrow(ClienteNaoEncontradoException::new);
    }

    @Override
    public ClienteDTO save(ClienteDTO clienteDTO) throws ErrorAoSalvarException {
        Cliente cliente = MapperUtils.converterParaEntidade(clienteDTO, Cliente.class);
        Cliente clienteSalvo = repository.save(cliente);
        if(clienteSalvo.getId() == null) {
            throw new ClienteNaoEncontradoException();
        }
        logger.info("Cliente salvo com sucesso {}", clienteSalvo.getId());
       return MapperUtils.converterClienteParaDTO(clienteSalvo);
    }

    @Override
    public void delete(Long id) { }
}
