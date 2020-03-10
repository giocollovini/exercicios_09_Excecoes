package modelo.entidades;

import modelo.excecoes.excecoesDominio;

public class conta {

	private Integer numeroConta;
	private String titularConta;
	private Double saldoConta;
	private Double limiteSaque;
	
	public conta() {
		
	} 
	
	public conta(Integer numeroConta, String titularConta, Double saldoConta, Double limiteSaque) {
		this.numeroConta = numeroConta;
		this.titularConta = titularConta;
		this.saldoConta = saldoConta;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNumeroConta() {
		return numeroConta;
	}
	
	public String getTitularConta() {
		return titularConta;
	}

	public void setTitularConta(String titularConta) {
		this.titularConta = titularConta;
	}

	public Double getSaldoConta() {
		return saldoConta;
	}
	
	public Double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}
	
	public void deposito(double valor) {
		saldoConta += valor;
	}
	
	public void saque(double valor) { 
		
		if (limiteSaque < valor) {
			throw new excecoesDominio("Valor excede limite de saque.");
		}
		
		if  (saldoConta < valor) {
			throw new excecoesDominio("Não possui saldo suficiente para saque.");
		}
		
		saldoConta -= valor;
	}
	

	@Override
	public String toString() {
		return "Novo Saldo: "
			+  String.format("%.2f", getSaldoConta());
	}
	
}
