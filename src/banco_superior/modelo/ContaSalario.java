package banco_superior.modelo;

import java.io.Serializable;

public class ContaSalario implements IConta, Serializable{

	String numeroConta;
	String agencia;
	private float saldo;
	boolean status;
	String dataAbertura;
	
	
	public ContaSalario(String numeroConta, String agencia, String dataAbertura)
	{
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.dataAbertura = dataAbertura;
		this.saldo = 0f;
		this.status = true;
	}
	@Override
	public void sacar(float valorSacado) {
		// TODO Auto-generated method stub
		if(valorSacado<=this.saldo && this.status)
		{
			this.saldo -= valorSacado;
		}
	}

	@Override
	public void depositar(float valorDepositado) {
		// TODO Auto-generated method stub
		if(valorDepositado>0 && this.status)
		{
			this.saldo += valorDepositado;
		}
	}

	@Override
	public void desativarConta() {
		// TODO Auto-generated method stub
		this.status = false;
	}

	@Override
	public void transferencia(IConta contaDestino, float valorTransferido){
		// TODO Auto-generated method stub		
		if(contaDestino == null)
		{
			 System.err.println("Conta salário não faz transferência!!");
		}
	}

	@Override
	public void ativarConta() {
		// TODO Auto-generated method stub
		this.status = true;
	}
	@Override
	public String toString() {
		return "ContaSalario [numeroConta=" + numeroConta + ", agencia=" + agencia + ", saldo=" + saldo + ", status="
				+ status + ", dataAbertura=" + dataAbertura + "]";
	}
	
	

}
