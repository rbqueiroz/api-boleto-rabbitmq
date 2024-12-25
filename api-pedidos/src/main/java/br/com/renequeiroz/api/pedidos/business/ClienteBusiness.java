package br.com.renequeiroz.api.pedidos.business;

import br.com.renequeiroz.api.pedidos.dto.ClienteDTO;
import br.com.renequeiroz.api.pedidos.entity.Cliente;
import br.com.renequeiroz.api.pedidos.exceptions.ClienteNaoEncontradoException;
import br.com.renequeiroz.api.pedidos.exceptions.ErrorAoSalvarException;

import java.util.List;

public interface ClienteBusiness {

        List<Cliente> findAll();

        Cliente findById(Long id) throws ClienteNaoEncontradoException;

        ClienteDTO save(ClienteDTO clienteDTO) throws ErrorAoSalvarException;

        void delete(Long id);
}
