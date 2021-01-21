package banco_superior.modelo;

import banco_superior.excecao.SaldoInsuficienteException;

public interface IConta {

	float CUSTO_SACAR_CONTA_CORRENTE = 0.01f;
	float CUSTO_SACAR_CONTA_INVESTIMENTO = 0.01f;
	float CUSTO_SACAR_CONTA_POUPANCA = 0.01f;
	float RENDIMENTO_POUPANCA = 0.03f;
	float TAXA_ADMINISTRACAO = 0.05f;
	
	public float saldo = 0f;
	
	public void sacar(float valorSacado) throws SaldoInsuficienteException;
	
	public void depositar(float valorDepositado);
	
	public void desativarConta();
	
	public void transferencia(IConta contaDestino, float valorTransferido) throws SaldoInsuficienteException;
	
	public void ativarConta();
	
	public String toString();
}
