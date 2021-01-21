package banco_superior.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import banco_superior.excecao.ClienteJaCadastradoException;
import banco_superior.modelo.ClientePessoaFisica;
import banco_superior.modelo.ClientePessoaJuridica;
import banco_superior.modelo.ICliente;

public class PersistenciaEmArquivoCliente implements IPersistenciaCliente {

	private List<ICliente> clientesCadastrados = new ArrayList<ICliente>();

	public PersistenciaEmArquivoCliente() {
		lerConteudoArquivo();
	}

	@Override
	public void cadastrarCliente(ICliente obj) throws ClienteJaCadastradoException{
		// TODO Auto-generated method stub
		if (!clientesCadastrados.contains(obj)) {
			clientesCadastrados.add(obj);
			salvarEmArquivo();
		}
		else
			throw new ClienteJaCadastradoException("Cliente do tipo "+obj.getClass().getName()+" já cadastrado no banco!");

	}

	@Override
	public ICliente localizarClientePorCPF(String cpf) {
		// TODO Auto-generated method stub
		ICliente cliente = new ClientePessoaFisica(cpf);

		if (clientesCadastrados.contains(cliente)) {
			int index = clientesCadastrados.indexOf(cliente);
			cliente = clientesCadastrados.get(index);
		}
		return cliente;
	}

	@Override
	public ICliente localizarClientePorCNPJ(String cnpj) {
		
		ICliente cliente = new ClientePessoaJuridica(cnpj);

		if (clientesCadastrados.contains(cliente)) {
			int index = clientesCadastrados.indexOf(cliente);
			cliente = clientesCadastrados.get(index);
		}
		return cliente;
	}

	@Override
	public void removerCliente(ICliente obj) {
		// TODO Auto-generated method stub
		if (clientesCadastrados.contains(obj)) {
			clientesCadastrados.remove(obj);
			salvarEmArquivo();
		}

	}

	private void salvarEmArquivo() {
		try {
			FileOutputStream fos = new FileOutputStream("persistencia_cliente.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(clientesCadastrados);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void lerConteudoArquivo() {
		try {
			FileInputStream fis = new FileInputStream("persistencia_cliente.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			clientesCadastrados = (ArrayList<ICliente>) obj;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
