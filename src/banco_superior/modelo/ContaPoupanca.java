package banco_superior.modelo;

import java.io.Serializable;

import banco_superior.excecao.SaldoInsuficienteException;

public class ContaPoupanca implements IConta, Serializable{

	String numeroConta;
	String agencia;
	private float saldo;
	boolean status;
	String dataAbertura;
	
	
	
	public ContaPoupanca(String numeroConta, String agencia, String dataAbertura) {
		
	}

	@Override
	public void transferencia(IConta contaDestino, float valorTransferido) throws SaldoInsuficienteException{
		// TODO Auto-generated method stub
		
		if(contaDestino instanceof ContaCorrente || contaDestino instanceof ContaInvestimento)
		{
			if(valorTransferido > 0 && this.saldo >= 
					(valorTransferido+(valorTransferido*TAXA_ADMINISTRACAO)) && this.status)
			{
				this.saldo -= (valorTransferido+(valorTransferido*TAXA_ADMINISTRACAO));
			}
			else if((valorTransferido+(valorTransferido*TAXA_ADMINISTRACAO))>saldo)
			{
				throw new SaldoInsuficienteException("Saldo insuficiente para a quantia de R$"+valorTransferido+". Saldo disponível para saque R$"+saldo);
			}
		}
		
	}

	@Override
	public void sacar(float valorSacado) throws SaldoInsuficienteException{
		
		if(valorSacado > 0 && this.saldo >= 
				(valorSacado+(valorSacado*CUSTO_SACAR_CONTA_POUPANCA)) && this.status)
		{
			this.saldo -= (valorSacado+(valorSacado*CUSTO_SACAR_CONTA_POUPANCA));
		}
		else if((valorSacado+(valorSacado*CUSTO_SACAR_CONTA_POUPANCA))>saldo)
		{
			throw new SaldoInsuficienteException("Saldo insuficiente!");
		}
	}

	@Override
	public void depositar(float valorDepositado) {
		if(valorDepositado>0 && this.status)
		{
			this.saldo += valorDepositado;
		}
		
	}

	@Override
	public void desativarConta() {
		this.status = false;
	}

	@Override
	public void ativarConta() {
		this.status = true;
	}

	@Override
	public String toString() {
		return "ContaPoupanca [numeroConta=" + numeroConta + ", agencia=" + agencia + ", saldo=" + saldo + ", status="
				+ status + ", dataAbertura=" + dataAbertura + "]";
	}
	
	

}
