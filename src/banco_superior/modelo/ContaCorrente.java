package banco_superior.modelo;

import java.io.Serializable;
import java.util.Date;

import banco_superior.excecao.SaldoInsuficienteException;

public class ContaCorrente implements IConta, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String numeroConta;
	String agencia;
	private float saldo;
	boolean status;
	Date dataAbertura;
	
	static final float TAXA_MANUTENCAO = 0.01f;
	
	public ContaCorrente(String numeroConta, String agencia,Date dataAbertura) {
		
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.saldo = 0f;
		this.status = true;
		this.dataAbertura = dataAbertura;
	}

	@Override
	public void transferencia(IConta contaDestino, float valorTransferido) throws SaldoInsuficienteException{
		// TODO Auto-generated method stub
		
		if(contaDestino instanceof ContaPoupanca || contaDestino instanceof ContaInvestimento)
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
	public void sacar(float valorSacado) {
		if(valorSacado > 0 && this.saldo >= 
				(valorSacado+(valorSacado*CUSTO_SACAR_CONTA_CORRENTE)) && this.status)
		{
			this.saldo -= (valorSacado+(valorSacado*CUSTO_SACAR_CONTA_CORRENTE));
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
		return "ContaCorrente [numeroConta=" + numeroConta + ", agencia=" + agencia + ", saldo=" + saldo + ", status="
				+ status + ", dataAbertura=" + dataAbertura + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroConta == null) ? 0 : numeroConta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaCorrente other = (ContaCorrente) obj;
		if (numeroConta == null) {
			if (other.numeroConta != null)
				return false;
		} else if (!numeroConta.equals(other.numeroConta))
			return false;
		return true;
	}

	@Override
	public String getAgencia() {
		// TODO Auto-generated method stub
		return agencia;
	}

	@Override
	public float getSaldo() {
		// TODO Auto-generated method stub
		return saldo;
	}

	@Override
	public boolean getStatus() {
		// TODO Auto-generated method stub
		return status;
	}

	@Override
	public String getConta() {
		// TODO Auto-generated method stub
		return numeroConta;
	}
	
	
	
	

}
