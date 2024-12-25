package br.com.renequeiroz.api.pedidos.repository;

import br.com.renequeiroz.api.pedidos.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Produto findById(long id);
    Produto findByNome(String nome);
}
