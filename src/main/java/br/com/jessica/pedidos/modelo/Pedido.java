package br.com.jessica.pedidos.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Pedido {


	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String descricao;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	@Enumerated(EnumType.STRING)
	private StatusPedido status = StatusPedido.RECEBIDO;
	@ManyToOne
	private Cliente cliente;
	@ManyToOne
	private Categoria categoria;
	
	public Pedido() {
	
	}
	
	public Pedido(String titulo, String descricao, Categoria categoria) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.categoria = categoria;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Cliente getAutor() {
		return cliente;
	}

	public void setAutor(Cliente autor) {
		this.cliente = autor;
	}

	public Categoria getCurso() {
		return categoria;
	}

	public void setCurso(Categoria categoria) {
		this.categoria = categoria;
	}


}
