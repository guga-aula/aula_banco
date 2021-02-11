package banco_superior.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.text.MaskFormatter;

import banco_superior.excecao.ClienteJaCadastradoException;
import banco_superior.modelo.ClientePessoaFisica;
import banco_superior.modelo.ICliente;
import banco_superior.persistencia.PersistenciaEmArquivoCliente;

public class TelaCadastroPessoaFisica extends JDialog{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txfNome;
	private JFormattedTextField txfCpf;
	private JTextField txfData;
	private JTextField txfEmail;
	private JButton btnFechar;
	private JButton btnSalvar;
	private ICliente clientePf;
	
	public TelaCadastroPessoaFisica() {
		
		setSize(480, 320);
		setResizable(false);
		setTitle("Tela Cadastro Cliente Pessoa Física");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setModal(true);
		
		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente:");
		lblNomeDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeDoCliente.setBounds(10, 48, 107, 14);
		getContentPane().add(lblNomeDoCliente);
		
		txfNome = new JTextField();
		txfNome.setBounds(112, 46, 342, 20);
		getContentPane().add(txfNome);
		txfNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCpf.setBounds(10, 90, 46, 14);
		getContentPane().add(lblCpf);
		
		
		txfCpf = new JFormattedTextField();
		txfCpf.setBounds(44, 88, 126, 20);
		getContentPane().add(txfCpf);
		txfCpf.setColumns(10);
		
		try {
			MaskFormatter mf = new MaskFormatter("###.###.###-##");
			mf.install(txfCpf);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento: ");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataDeNascimento.setBounds(200, 90, 118, 14);
		getContentPane().add(lblDataDeNascimento);
		
		txfData = new JTextField();
		txfData.setBounds(328, 88, 107, 20);
		getContentPane().add(txfData);
		txfData.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail: ");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(10, 140, 46, 14);
		getContentPane().add(lblEmail);
		
		txfEmail = new JTextField();
		txfEmail.setBounds(54, 138, 322, 20);
		getContentPane().add(txfEmail);
		txfEmail.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 197, 444, 73);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientePf = new ClientePessoaFisica(txfCpf.getText(), txfNome.getText(), txfData.getText(), txfEmail.getText());
				try {
					PersistenciaEmArquivoCliente.pegarInstancia().cadastrarCliente(clientePf);
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
				} catch (ClienteJaCadastradoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(111, 11, 94, 57);
		panel.add(btnSalvar);
		
		btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(null, "Deseja Fechar a Janela?");
				if(a==0)
					dispose();
				else
				{
					
				}
			}
		});
		btnFechar.setBounds(229, 11, 86, 57);
		panel.add(btnFechar);
		setVisible(true);
		
		
	}

}
