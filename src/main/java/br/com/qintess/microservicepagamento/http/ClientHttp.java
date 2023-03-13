package br.com.qintess.microservicepagamento.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "pedidos-ms", url = "localhost:8081/pedidos")
public interface ClientHttp {

	@RequestMapping(method = RequestMethod.PUT, value = "/pedidos/{id}/pago")

	static void atualizaPagamento(@PathVariable Integer id) {

	}

}
