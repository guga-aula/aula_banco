package banco_superior.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class TelaPrincipal extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JMenuBar menuBar;
	private JMenu mnCadastrar;
	private JMenuItem mntmCadastrarClientePf;
	private JMenuItem mntmCadastrarContaCorrente;
	private JMenu mnConsultarContas;
	private JMenuItem mntmListarContasCliente;
	private JMenu mnSair;
	
	public TelaPrincipal() 
	{
		setResizable(false);
		setSize(800, 600);
		setTitle("Tela Principal");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnCadastrar = new JMenu("Cadastrar Cliente");
		menuBar.add(mnCadastrar);
		
		mntmCadastrarClientePf = new JMenuItem("Cadastrar Cliente PF");
		mnCadastrar.add(mntmCadastrarClientePf);
		mntmCadastrarClientePf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new TelaCadastroPessoaFisica();
			}
		});
		
		JMenuItem mntmCadastrarClientePj = new JMenuItem("Cadastrar Cliente PJ");
		mnCadastrar.add(mntmCadastrarClientePj);
		
		JMenu mnCadastrarContas = new JMenu("Cadastrar Contas");
		menuBar.add(mnCadastrarContas);
		
		mntmCadastrarContaCorrente = new JMenuItem("Cadastrar Conta Corrente");
		mntmCadastrarContaCorrente.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new TelaCadastroContaCorrente();
			}
		});
		mnCadastrarContas.add(mntmCadastrarContaCorrente);
		
		mnSair = new JMenu("Sair");
		mnSair.addMenuListener(new MenuListener() {
			
			@Override
			public void menuSelected(MenuEvent e) {
				// TODO Auto-generated method stub
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair da aplicação?");
				if(resposta == 0)
				{
					System.exit(0);
				}
				else
				{
					
				}
			}
			
			@Override
			public void menuDeselected(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void menuCanceled(MenuEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mnConsultarContas = new JMenu("Consultar Contas");
		menuBar.add(mnConsultarContas);
		
		mntmListarContasCliente = new JMenuItem("Listar Contas Cliente PF");
		mntmListarContasCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new TelaConsultaContaClientePF();
			}
		});
		mnConsultarContas.add(mntmListarContasCliente);
		menuBar.add(mnSair);
		setVisible(true);
	}
}
