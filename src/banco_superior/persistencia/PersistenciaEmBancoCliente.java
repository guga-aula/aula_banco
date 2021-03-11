package banco_superior.persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import banco_superior.excecao.CadastroNaoEncontradoException;
import banco_superior.excecao.ClienteJaCadastradoException;
import banco_superior.modelo.ClientePessoaFisica;
import banco_superior.modelo.ICliente;

public class PersistenciaEmBancoCliente implements IPersistenciaCliente{

	private static PersistenciaEmBancoCliente instance;
	
	private PersistenciaEmBancoCliente() {
		// TODO Auto-generated constructor stub
	}
	
	public static PersistenciaEmBancoCliente pegarInstancia()
	{
		if(instance != null)
			return instance;
		else
		{
			return instance = new PersistenciaEmBancoCliente();
		}
	}
	@Override
	public void cadastrarCliente(ICliente obj) throws ClienteJaCadastradoException {
		// TODO Auto-generated method stub
		if(obj instanceof ClientePessoaFisica)
		{
			String sqlInserirCliente = "insert into clientepessoafisica (cpf, nome, data, email)"
					+ " values (?,?,?,?);";
			
			try 
			{
				PreparedStatement pstmt = FabricaConexao.getConnection().prepareStatement(sqlInserirCliente);
				pstmt.setString(1, ((ClientePessoaFisica)obj).getCpf());
				pstmt.setString(2, ((ClientePessoaFisica)obj).getNome());
				pstmt.setString(3, ((ClientePessoaFisica)obj).getDataNascimento());
				pstmt.setString(4, ((ClientePessoaFisica)obj).getEmail());
				
				pstmt.execute();
				pstmt.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
	}

	@Override
	public ICliente localizarClientePorCPF(String cpf) throws CadastroNaoEncontradoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICliente localizarClientePorCNPJ(String cnpj) throws CadastroNaoEncontradoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removerCliente(ICliente obj) throws CadastroNaoEncontradoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarCliente(ICliente obj) throws CadastroNaoEncontradoException {
		// TODO Auto-generated method stub
		
	}

}
