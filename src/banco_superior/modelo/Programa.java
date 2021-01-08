package banco_superior.modelo;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IConta conta1 = new ContaCorrente("123", "AA", "24-12-2020");

		IConta conta2 = new ContaPoupanca("321", "BB", "31/12/2020");
		
		IConta conta3 = new ContaInvestimento("444", "CC", "31/12/2020");
		
		ContaSalario conta4 = new ContaSalario("555", "DD", "01/01/2021"); 
		
		
		Cliente cliente1 = new Cliente("000", "Gustavo", "13/01/2020");
		
		
		cliente1.adicionarContaCliente(conta1);
		
		cliente1.adicionarContaCliente(conta2);
		
		cliente1.adicionarTelefone("83-99999-9999");
		
		cliente1.adicionarTelefone("82-99999-9999");
		
		cliente1.adicionarTelefone("81-99999-9999");
		
		cliente1.removerTelefone("88-99999-9999");
		
		cliente1.adicionarContaCliente(conta3);		
		
		cliente1.adicionarContaCliente(conta4);
		
		System.out.println(cliente1.contemContaCliente(conta3));
		System.out.println(cliente1);
		
		conta4.transferencia(null, 0f);
		
	}

}
