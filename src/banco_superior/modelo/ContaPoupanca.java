package banco_superior.modelo;

public class ContaPoupanca implements IConta{

	String numeroConta;
	String agencia;
	private float saldo;
	boolean status;
	String dataAbertura;
	
	
	
	public ContaPoupanca(String numeroConta, String agencia, String dataAbertura) {
		
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
				(valorSacado+(valorSacado*CUSTO_SACAR_CONTA_POUPANCA)) && this.status)
		{
			this.saldo -= (valorSacado+(valorSacado*CUSTO_SACAR_CONTA_POUPANCA));
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
