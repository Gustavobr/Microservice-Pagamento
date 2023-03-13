package br.com.qintess.microservicepagamento.enums;

public enum Status {

	CRIADO, CONFIRMADO, CANCELADO;

	private Status status;

	public String setStatus(Status status) {
		this.status = status;
		return this.status.toString();

	}

}