package br.com.jessica.pedidos.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.jessica.pedidos.modelo.Pedido;
import br.com.jessica.pedidos.modelo.StatusPedido;

public class DetalhesDoPedidoDto {
	
	private Long id;
	private String titulo;
	private String descricao;
	private LocalDateTime dataCriacao;
	private String nomeCliente;
	private StatusPedido status;
	
	
	public DetalhesDoPedidoDto(Pedido pedido) {
		this.id = pedido.getId();
		this.titulo = pedido.getTitulo();
		this.descricao = pedido.getDescricao();
		this.dataCriacao = pedido.getDataCriacao();
		this.nomeCliente = pedido.getAutor().getNome();
		this.status = pedido.getStatus();
		
	}

	public StatusPedido getStatus() {
		return status;
	}


	public void setStatus(StatusPedido status) {
		this.status = status;
	}


	public Long getId() {
		return id;
	}


	public String getTitulo() {
		return titulo;
	}


	public String getDescricao() {
		return descricao;
	}


	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}


	public String getNomeCliente() {
		return nomeCliente;
	}




	
}
