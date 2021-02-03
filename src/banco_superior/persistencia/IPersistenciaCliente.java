package banco_superior.persistencia;

import banco_superior.excecao.CadastroNaoEncontradoException;
import banco_superior.excecao.ClienteJaCadastradoException;
import banco_superior.modelo.ICliente;

public interface IPersistenciaCliente {

	
	public void cadastrarCliente(ICliente obj) throws ClienteJaCadastradoException;
	
	public ICliente localizarClientePorCPF(String cpf) throws CadastroNaoEncontradoException;
	
	public ICliente localizarClientePorCNPJ(String cnpj) throws CadastroNaoEncontradoException;
	
	public void removerCliente(ICliente obj) throws CadastroNaoEncontradoException;
	
	public void atualizarCliente(ICliente obj) throws CadastroNaoEncontradoException;
}
