package br.com.qintess.microservicepagamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.qintess.microservicepagamento.model.Pagamento;

@Repository(value = "repository")
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
