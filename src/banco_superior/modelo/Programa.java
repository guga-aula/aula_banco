package banco_superior.modelo;

import javax.swing.JOptionPane;

import banco_superior.excecao.ClienteJaCadastradoException;
import banco_superior.excecao.SaldoInsuficienteException;
import banco_superior.persistencia.PersistenciaEmArquivoCliente;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PersistenciaEmArquivoCliente pac = new PersistenciaEmArquivoCliente();
		
		ICliente cliente1 = pac.localizarClientePorCPF("000");
		
		try {
			cliente1.buscarContaInvestimento("1A").sacar(99f);
		} catch (SaldoInsuficienteException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		System.out.println(cliente1);
		
		cliente1.buscarContaInvestimento("1A").depositar(10f);
		
		try 
		{
			cliente1.buscarContaInvestimento("1A").sacar(100f);
		} 
		catch (SaldoInsuficienteException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getStackTrace());
		}
		
		
		
	}

}
