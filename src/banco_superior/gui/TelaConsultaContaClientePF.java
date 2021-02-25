package banco_superior.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import banco_superior.modelo.ICliente;
import banco_superior.modelo.IConta;
import banco_superior.persistencia.PersistenciaEmArquivoCliente;

public class TelaConsultaContaClientePF extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCliente;
	private JComboBox<ICliente> cbCliente;
	private JTable table;
	private String[] colunasTabela = {"N Conta", "Agência", "Saldo", "Status"};
	private final int QUANTIDADE_MAX_CONTAS = 10;
	private Object[][] elementos = new Object[QUANTIDADE_MAX_CONTAS][QUANTIDADE_MAX_CONTAS];

	public TelaConsultaContaClientePF() {
		// TODO Auto-generated constructor stub
		setSize(480, 360);
		setTitle("Tela de Consulta - Contas Cliente PF");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setModal(true);
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		lblCliente = new JLabel("Cliente: ");
		lblCliente.setBounds(10, 52, 46, 14);
		getContentPane().add(lblCliente);
		
		cbCliente = new JComboBox();
		
		for(ICliente c : PersistenciaEmArquivoCliente.pegarInstancia().listaClientesCadastradosPF())
		{
			cbCliente.addItem(c);
		}
		
		cbCliente.addActionListener(new TabelaAtualizarEvent());
		
		cbCliente.setBounds(66, 48, 388, 22);
		getContentPane().add(cbCliente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 92, 444, 218);
		getContentPane().add(scrollPane);
		
		table = new JTable(elementos, colunasTabela);
		table.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(table);
		setVisible(true);
	}
	
	private class TabelaAtualizarEvent implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			for(int i = 0; i<QUANTIDADE_MAX_CONTAS; i++)
			{
				elementos[i][0] = "";
				elementos[i][1] = "";
				elementos[i][2] = "";
				elementos[i][3] = "";
			}
			int i = 0;
			for(IConta c : ((ICliente)cbCliente.getSelectedItem()).getContasCliente())
			{
				elementos[i][0] = c.getConta();
				elementos[i][1] = c.getAgencia();
				elementos[i][2] = c.getSaldo();
				elementos[i][3] = c.getStatus();
				i++;
			}
			
			table.updateUI();
		}
		
	}
}


