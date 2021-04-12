package br.com.jessica.pedidos.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.jessica.pedidos.controller.dto.DetalhesDoPedidoDto;
import br.com.jessica.pedidos.controller.dto.PedidoDto;
import br.com.jessica.pedidos.controller.form.AtualizacaoPedidoForm;
import br.com.jessica.pedidos.controller.form.PedidoForm;
import br.com.jessica.pedidos.modelo.Pedido;
import br.com.jessica.pedidos.repository.CategoriaRepository;
import br.com.jessica.pedidos.repository.PedidoRepository;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	@GetMapping
	public Page<PedidoDto> lista(@RequestParam (required = false)String categoria,@PageableDefault(sort = "dataCriacao", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
	// paginação com spring data
		
		
		if (categoria == null) {
			Page<Pedido> pedidos =  pedidoRepository.findAll(paginacao);
		return PedidoDto.converter(pedidos);
		}else{
			Page<Pedido> pedidos =  pedidoRepository.findByCategoria(categoria, paginacao);
			return PedidoDto.converter(pedidos);
		}
	
	}
	
	// usando beanValidation para validação dos camp0os
	@PostMapping
	public ResponseEntity<PedidoDto> cadastrar (@RequestBody @Valid PedidoForm pedidoForm, UriComponentsBuilder uriBuilder) {
		Pedido pedido = pedidoForm.converter(categoriaRepository);
		pedidoRepository.save(pedido);
		URI uri = uriBuilder.path("/pedido/{id}").buildAndExpand(pedido.getId()).toUri();
		return ResponseEntity.created(uri).body(new PedidoDto(pedido));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoPedidoDto> detalhar(@PathVariable Long id) {
		Optional<Pedido> topico = pedidoRepository.findById(id);
		if (topico.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoPedidoDto(topico.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PedidoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoPedidoForm form) {
		Optional<Pedido> optional = pedidoRepository.findById(id);
		if (optional.isPresent()) {
			Pedido pedido = form.atualizar(id, pedidoRepository);
			return ResponseEntity.ok(new PedidoDto(pedido));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Pedido> optional = pedidoRepository.findById(id);
		if (optional.isPresent()) {
			pedidoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

	
}

