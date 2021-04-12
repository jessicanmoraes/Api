package br.com.jessica.pedidos.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jessica.pedidos.modelo.Pedido;


// na interface jpa repository ja tem os metodos comuns do crud;
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	Page<Pedido> findByCategoria(String categoria, Pageable paginacao);

}
