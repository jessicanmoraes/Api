package br.com.jessica.pedidos.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.jessica.pedidos.modelo.Pedido;
import br.com.jessica.pedidos.repository.PedidoRepository;

public class AtualizacaoPedidoForm {
	
	@NotNull @NotEmpty @Length(min = 5)
	private String titulo;
	
	@NotNull @NotEmpty @Length(min = 10)
	private String descricao;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pedido atualizar(Long id, PedidoRepository pedidoRepository) {
		Pedido pedido = pedidoRepository.getOne(id);
		
		pedido.setTitulo(this.titulo);
		pedido.setDescricao(this.descricao);
		
		return pedido;
	}
	
}
