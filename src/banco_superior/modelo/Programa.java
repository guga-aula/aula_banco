package banco_superior.modelo;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("Taxa de adm: "+Conta.TAXA_ADMINISTRACAO);
		
		Conta c1 = new Conta("123", "AA", "Gustavo", "000", 'C', "24-12-2020");

		Conta c2 = new Conta("222", "AA", "Maria", "030", 'P', "24-12-2020");

		System.out.println("CONTAS CRIADAS SEM SALDO: ");
		System.out.println(c1);
		System.out.println(c2);

		c1.depositar(100f);
		c2.depositar(60f);
		
		System.out.println("CONTAS COM SALDO: ");
		System.out.println(c1);
		System.out.println(c2);
		
		
		c1.transferencia(c2, 25f);
		System.out.println("CONTAS APÓS TRANSFERÊNCIA: ");
		System.out.println(c1);

		System.out.println(c2);
		
		

	}

}
