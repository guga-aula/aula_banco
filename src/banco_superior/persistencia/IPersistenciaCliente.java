package banco_superior.persistencia;

import banco_superior.modelo.ICliente;

public interface IPersistenciaCliente {

	
	public void cadastrarCliente(ICliente obj);
	
	public ICliente localizarClientePorCPF(String cpf);
	
	public ICliente localizarClientePorCNPJ(String cnpj);
	
	public void removerCliente(ICliente obj);
}
