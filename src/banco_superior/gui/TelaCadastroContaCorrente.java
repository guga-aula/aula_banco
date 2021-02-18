package banco_superior.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import banco_superior.excecao.CadastroNaoEncontradoException;
import banco_superior.modelo.ClientePessoaFisica;
import banco_superior.modelo.ContaCorrente;
import banco_superior.modelo.ICliente;
import banco_superior.modelo.IConta;
import banco_superior.persistencia.PersistenciaEmArquivoCliente;

public class TelaCadastroContaCorrente extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txfConta;
	private JTextField txfAgencia;
	private JComboBox<ICliente> cbCliente;
	private JPanel panel;
	private JButton btnSalvar;
	private JButton btnFechar;
	private IConta contaCorrente;
	private ICliente cliente;
	
	public TelaCadastroContaCorrente()
	{
		setTitle("Cadastrar Conta Corrente - Pessoa F\u00EDsica");
		setSize(640, 350);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblSelecionarCliente = new JLabel("Selecionar Cliente:");
		lblSelecionarCliente.setBounds(21, 44, 106, 14);
		getContentPane().add(lblSelecionarCliente);
		
		
		cbCliente = new JComboBox<ICliente>();
		cbCliente.setBounds(125, 40, 451, 22);
		
		for(ICliente c : PersistenciaEmArquivoCliente.pegarInstancia().listaClientesCadastradosPF())
		{
			cbCliente.addItem(c);
		}
		getContentPane().add(cbCliente);
		
		JLabel lblNmeroDaConta = new JLabel("N\u00FAmero da Conta:");
		lblNmeroDaConta.setBounds(21, 103, 95, 14);
		getContentPane().add(lblNmeroDaConta);
		
		txfConta = new JTextField();
		txfConta.setBounds(117, 100, 106, 20);
		getContentPane().add(txfConta);
		txfConta.setColumns(10);
		
		JLabel lblAgncia = new JLabel("Ag\u00EAncia: ");
		lblAgncia.setBounds(271, 103, 62, 14);
		getContentPane().add(lblAgncia);
		
		txfAgencia = new JTextField();
		txfAgencia.setBounds(326, 100, 86, 20);
		getContentPane().add(txfAgencia);
		txfAgencia.setColumns(10);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 204, 604, 96);
		getContentPane().add(panel);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				contaCorrente = new ContaCorrente(txfConta.getText(), txfAgencia.getText(), new Date());
				cliente = (ClientePessoaFisica)cbCliente.getSelectedItem();
				cliente.adicionarContaCliente(contaCorrente);
				try 
				{
					PersistenciaEmArquivoCliente.pegarInstancia().atualizarCliente(cliente);
					System.out.println(cliente);
				} catch (CadastroNaoEncontradoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnSalvar);
		
		btnFechar = new JButton("Fechar");
		panel.add(btnFechar);
		setResizable(false);
		setVisible(true);
	}
}
