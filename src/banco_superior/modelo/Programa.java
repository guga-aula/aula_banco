package banco_superior.modelo;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import banco_superior.gui.TelaPrincipal;
import banco_superior.util.ConstantesUtil;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JOptionPane.showMessageDialog(null, "Endereco banco de dados: "+ConstantesUtil.BANCO_SUPERIOR_DATABASE_IP);
		System.out.println(ConstantesUtil.containsKey("teste2"));
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new TelaPrincipal();
			}
		});
		
	}

}
