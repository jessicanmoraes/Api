package br.com.jessica.pedidos.controller.form;




import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.jessica.pedidos.modelo.Categoria;
import br.com.jessica.pedidos.modelo.Pedido;
import br.com.jessica.pedidos.repository.CategoriaRepository;
import br.com.jessica.pedidos.repository.PedidoRepository;

public class PedidoForm {
	@NotNull @NotEmpty @Length(min =5)
	String titulo;
	@NotNull @NotEmpty
	String descricao;
	@NotNull @NotEmpty
	String nomeCategoria;
	
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
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	public Pedido converter(CategoriaRepository categoriaRepository) {
		Categoria cat = categoriaRepository.findByNome(nomeCategoria);
		return new Pedido (titulo, descricao,cat);
		
	}
	

}
