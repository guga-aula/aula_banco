package banco_superior.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaPrincipal extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JMenuBar menuBar;
	private JMenu mnCadastrar;
	private JMenuItem mntmCadastrarClientePf;
	
	public TelaPrincipal() 
	{
		setResizable(false);
		setSize(800, 600);
		setTitle("Tela Principal");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnCadastrar = new JMenu("Cadastrar");
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
		
		JMenu mnSair = new JMenu("Sair");
		menuBar.add(mnSair);
		setVisible(true);
	}
}
