package br.com.renequeiroz.api.pedidos.repository;

import br.com.renequeiroz.api.pedidos.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByNome(String nome);
    Cliente findByEmail(String email);
    Cliente findById(long id);
}
