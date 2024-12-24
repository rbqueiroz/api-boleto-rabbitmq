package br.com.renequeiroz.api.pedidos.business.Impl;

import br.com.renequeiroz.api.pedidos.business.ClienteBusiness;
import br.com.renequeiroz.api.pedidos.entity.Cliente;
import br.com.renequeiroz.api.pedidos.exceptions.ClienteNaoEncontradoException;
import br.com.renequeiroz.api.pedidos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteBusinessImpl implements ClienteBusiness {

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> findAll() {
        return List.of();
    }

    @Override
    public Cliente findById(Long id) throws ClienteNaoEncontradoException {
        return repository.findById(id).orElseThrow(ClienteNaoEncontradoException::new);
    }

    @Override
    public Cliente save(Cliente cliente) {

        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
