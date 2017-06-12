package br.unipe.cc.mlplII.academico.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.unipe.cc.mlpIII.academico.facade.Academico;

import javax.swing.SwingConstants;

public class Login extends JFrame {

	/**
	 * Class for login frame
	 * @author Adilanne;
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application: main method
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		/**
		 * frame configuration: icons, size, containers.
		 */
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\Ico.png"));
		setTitle("Sistema Acadêmico Source");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 650, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("images\\Ico6.png"));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(153)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(179)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(169, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(label_1)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(95, Short.MAX_VALUE))
		);
		
		/**
		 * Labels and login/password fields
		 * Access button and verifications
		 */
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(26, 66, 38, 17);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(26, 115, 43, 17);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textField = new JTextField();
		textField.setBounds(26, 89, 248, 20);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(26, 138, 248, 20);
		
		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.setBounds(181, 192, 93, 23);
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BtnAcessarActionPerformed(e);
			}
		});
		btnAcessar.setBackground(Color.LIGHT_GRAY);
		
		JButton btnEsqueceuASenha = new JButton("Esqueceu a Senha?");
		btnEsqueceuASenha.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEsqueceuASenha.setHorizontalAlignment(SwingConstants.LEFT);
		btnEsqueceuASenha.setBounds(10, 232, 159, 23);
		btnEsqueceuASenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BtnEsqueceuASenhaActionPerformed(e);
			}
		});
		panel.setLayout(null);
		btnEsqueceuASenha.setBackground(new Color(0,0,0,0));
		btnEsqueceuASenha.setOpaque(false);
		btnEsqueceuASenha.setContentAreaFilled(false);
		btnEsqueceuASenha.setBorderPainted(false);
		panel.add(btnEsqueceuASenha);
		panel.add(btnAcessar);
		panel.add(lblSenha);
		panel.add(lblLogin);
		panel.add(passwordField);
		panel.add(textField);
		contentPane.setLayout(gl_contentPane);
	}

	protected void BtnEsqueceuASenhaActionPerformed(ActionEvent e) {
		String cpf = JOptionPane.showInputDialog("Insira seu CPF");
		Academico academico = new Academico();
		boolean retorno = academico.cpf(cpf);
		if(retorno){
			JOptionPane.showMessageDialog(null, "Acesso autorizado\nBem vindo");
			dispose();
			String[] args = null;
			Home.main(args);
		}else{
			JOptionPane.showMessageDialog(null, "Acesso negado");
		}
	}

	protected void BtnAcessarActionPerformed(ActionEvent e) {
		String user = textField.getText();
		String password = String.valueOf(passwordField.getPassword());
		
		Academico academico = new Academico();
		br.unipe.cc.mlpIII.academico.model.Login login = new br.unipe.cc.mlpIII.academico.model.Login();
		login.setUser(user);
		login.setPassword(password);
		boolean retorno = academico.login(login);
		if(retorno){
			dispose();
			String[] args = null;
			Home.main(args);
		}else{
			JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválidos");
		}
	}
}
