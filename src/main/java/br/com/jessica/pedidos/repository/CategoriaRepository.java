package br.com.jessica.pedidos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jessica.pedidos.modelo.Categoria;
import br.com.jessica.pedidos.modelo.Pedido;

public interface CategoriaRepository extends  JpaRepository<Categoria, Long> {
	Categoria findByNome(String nomeCategoria);
}
