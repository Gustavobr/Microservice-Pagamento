package br.com.qintess.microservicepagamento.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.qintess.microservicepagamento.DTO.PagamentoDTO;
import br.com.qintess.microservicepagamento.enums.Status;
import br.com.qintess.microservicepagamento.model.Pagamento;
import br.com.qintess.microservicepagamento.repository.PagamentoRepository;

@Service
public class PagamentoService {

	@Autowired(required = true)

	private PagamentoRepository repository;

	@Autowired

	private ModelMapper modelMapper;

	public Page<PagamentoDTO> obterTodos(Pageable paginacao) {
		return repository.findAll(paginacao).map(p -> modelMapper.map(p, PagamentoDTO.class));
	}

	public PagamentoDTO findPagamentoById(@PathVariable(required = true) Integer id) {
		Pagamento pagamento = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());

		return modelMapper.map(pagamento, PagamentoDTO.class);
	}

	public PagamentoDTO criarPagamento(PagamentoDTO pagamentoDTO) {
		Pagamento pagamento = modelMapper.map(pagamentoDTO, Pagamento.class);
		pagamento.setStatus(Status.CRIADO);
		repository.save(pagamento);

		return modelMapper.map(pagamento, PagamentoDTO.class);
	}

	public PagamentoDTO atualizarPagamento(Integer id, PagamentoDTO pagamentoDTO) {
		Pagamento pagamento = modelMapper.map(pagamentoDTO, Pagamento.class);
		pagamento.setId(id);
		pagamento = repository.save(pagamento);
		return modelMapper.map(pagamento, PagamentoDTO.class);

	}

	public void removePagamento(Integer id) {
		repository.deleteById(id);
	}

	public void confirmarPagamento(Integer id) {
		Optional<Pagamento> pagamento = repository.findById(id);
		if (!pagamento.isPresent()) {
			throw new EntityNotFoundException("Pagamento não existe.");
		}

		pagamento.get().setStatus(Status.CONFIRMADO);
		repository.save(pagamento.get());

	}

}
