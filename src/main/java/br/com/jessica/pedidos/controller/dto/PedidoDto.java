package br.com.jessica.pedidos.controller.dto;

import java.time.LocalDateTime;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import br.com.jessica.pedidos.modelo.Pedido;


public class PedidoDto {
	
	private String titulo;
	private String descricao;
	private LocalDateTime dataCriacao ;
	
	public PedidoDto (Pedido pedido) {
		this.id = pedido.getId();
		this.descricao = pedido.getDescricao();
		this.dataCriacao = pedido.getDataCriacao();
		this.titulo=pedido.getTitulo();
	}
	
	private long id ;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public static Page<PedidoDto> converter(Page<Pedido> pedidos) {
		// converter de pedido para pedido dto JAVA 8, Versoes anteriores era necessário fazer um for para preencher a lista dto
		return pedidos.map(PedidoDto::new);
	}


		
}
