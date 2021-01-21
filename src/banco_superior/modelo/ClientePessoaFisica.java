package banco_superior.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ClientePessoaFisica implements ICliente, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String cpf;
	String nome;
	String dataNascimento;
	String email;
	
	HashSet<String> telefones = new HashSet<String>();
	
	private List<IConta> contas = new ArrayList<IConta>();
	
	public ClientePessoaFisica(String cpf, String nome, String dataNascimento) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
	
	public ClientePessoaFisica(String cpf)
	{
		this.cpf = cpf;
	}

	

	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", telefones="
				+ telefones + ", contas=" + contas + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		ClientePessoaFisica other = (ClientePessoaFisica) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	public void adicionarContaCliente(IConta contaCliente)
	{
		this.contas.add(contaCliente);
	}
	
	public boolean contemContaCliente(IConta conta)
	{
		return this.contas.contains(conta);
	}
	
	public void removerConta(IConta conta)
	{
		if(contas.contains(conta))
		{
			contas.remove(conta);
			System.out.println("Conta removida com sucesso!");
		}
		else
		{
			System.out.println("Conta inexistente!");
		}
	}
	
	public void adicionarTelefone(String telefone)
	{
		this.telefones.add(telefone);
	}
	
	public void removerTelefone(String telefone)
	{
		if(telefones.contains(telefone))
		{
			telefones.remove(telefone);
		}
		else
		{
			System.out.println("Cliente não tem o referido telefone");
		}
	}

	
	public IConta buscarContaInvestimento(String numeroConta)
	{
		IConta conta = new ContaInvestimento(numeroConta);
		if(contas.contains(conta))
		{
			int index = contas.indexOf(conta);
			conta = contas.get(index);
		}
		
		return conta;
	}
	
}
