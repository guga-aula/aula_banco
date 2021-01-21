package banco_superior.modelo;

import java.io.Serializable;

public class ContaCorrente implements IConta, Serializable{

	String numeroConta;
	String agencia;
	private float saldo;
	boolean status;
	String dataAbertura;
	
	static final float TAXA_MANUTENCAO = 0.01f;
	
	public ContaCorrente(String numeroConta, String agencia,String dataAbertura) {
		
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.saldo = 0f;
		this.status = true;
		this.dataAbertura = dataAbertura;
	}

	@Override
	public void transferencia(IConta contaDestino, float valorTransferido) {
		// TODO Auto-generated method stub
		
		if(contaDestino instanceof ContaPoupanca)
		{
			this.sacar(valorTransferido+(valorTransferido*TAXA_ADMINISTRACAO));
			contaDestino.depositar(valorTransferido);
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
	
	
	
	

}
