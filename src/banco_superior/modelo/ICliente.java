package banco_superior.modelo;

import java.util.List;

public interface ICliente {

	
	public void adicionarContaCliente(IConta contaCliente);
	
	public void adicionarTelefone(String telefone);
	
	public void removerTelefone(String telefone);
	
	public IConta buscarContaInvestimento(String numeroConta);
}
