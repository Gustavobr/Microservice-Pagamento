package br.com.qintess.microservicepagamento.controller;

import java.net.URI;
	

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.qintess.microservicepagamento.DTO.PagamentoDTO;
import br.com.qintess.microservicepagamento.service.PagamentoService;

@RestController
@RequestMapping(path = "/pagamentos")
public class PagamentoController {

	@Autowired

	private PagamentoService service;

	@GetMapping
	public Page<PagamentoDTO> listar(@PageableDefault(size = 10) Pageable paginacao) {
		return service.obterTodos(paginacao);

	}

	@GetMapping("/{id}")

	public ResponseEntity<PagamentoDTO> detalhar(@PathVariable(required = true) Integer id) {
		PagamentoDTO pagamentoDTO = service.findPagamentoById(id);

		return ResponseEntity.ok(pagamentoDTO);
	}

	@DeleteMapping("/pagamentos/{id}")
	public ResponseEntity<PagamentoDTO> excluir(@PathVariable(required = true) Integer id) {
		service.removePagamento(id);
		return ResponseEntity.noContent().build();
	}

	@PostMapping

	public ResponseEntity<PagamentoDTO> cadastrar(@RequestBody @Valid PagamentoDTO pagamentoDTO,

			UriComponentsBuilder uriBuilder) {
		/*
		 * Uri endereco =
		 * UriBuilder.path(path).buildandexpand(pagamento.getId().toUri());
		 */
		PagamentoDTO pagamento = service.criarPagamento(pagamentoDTO);
		URI endereco = uriBuilder.path("/pagamentos/{id}").buildAndExpand(pagamento.getId()).toUri();

		return ResponseEntity.created(endereco).body(pagamento);

	}

	/* Load Balance */
	@GetMapping("/porta")
	public String retornaPorta(@Value("${local.server.port}") String port) {
		return String.format("Requisição respondida pela instância executando na porta %s", port);
	}

	@PutMapping("/{id}")

	public ResponseEntity<PagamentoDTO> atualizar(@Valid @RequestBody PagamentoDTO pagamentoDTO,
			@PathVariable(required = true) Integer id) {
		PagamentoDTO DTO = service.atualizarPagamento(id, pagamentoDTO);
		return ResponseEntity.ok(DTO);

	}

}
