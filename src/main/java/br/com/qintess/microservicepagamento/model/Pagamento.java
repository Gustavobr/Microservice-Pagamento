package br.com.qintess.microservicepagamento.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.qintess.microservicepagamento.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Pagamentos")
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class Pagamento {

	/* Bean validation */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;

	@NotNull(message = "Favor inserir nome")
	private String nome;

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

	@Positive
	@NotNull(message = "Favor inserir valor.")
	private BigDecimal valor;

	@NotNull
	@NotBlank
	@Size(max = 19)
	private String numero;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull
	private String expiracao;
	@NotNull
	@Size(max = 3, min = 3)
	private String codigo;
	@Enumerated(EnumType.STRING)
	private Status status;

	@NotNull
	private Long pedidoId;
	@NotNull
	private long formaDePagamentoID;

}
