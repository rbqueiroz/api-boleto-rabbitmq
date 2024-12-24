package br.com.renequeiroz.api.pedidos.business;

import br.com.renequeiroz.api.pedidos.entity.Cliente;
import br.com.renequeiroz.api.pedidos.exceptions.ClienteNaoEncontradoException;

import java.util.List;

public interface ClienteBusiness {

        List<Cliente> findAll();

        Cliente findById(Long id) throws ClienteNaoEncontradoException;

        Cliente save(Cliente cliente);

        void delete(Long id);
}
