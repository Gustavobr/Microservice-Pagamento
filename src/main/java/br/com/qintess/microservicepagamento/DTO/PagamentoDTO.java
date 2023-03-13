package br.com.qintess.microservicepagamento.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.qintess.microservicepagamento.enums.Status;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PagamentoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getExpiracao() {
		return expiracao;
	}

	public void setExpiracao(String expiracao) {
		this.expiracao = expiracao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public long getFormaDePagamentoID() {
		return formaDePagamentoID;
	}

	public void setFormaDePagamentoID(long formaDePagamentoID) {
		this.formaDePagamentoID = formaDePagamentoID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private Integer id;

	private String nome;

	private BigDecimal valor;

	private String numero;

	private String expiracao;

	private String codigo;

	private Status status;

	private Long pedidoId;

	private long formaDePagamentoID;

}
