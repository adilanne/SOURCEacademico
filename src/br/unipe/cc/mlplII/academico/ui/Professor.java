package br.unipe.cc.mlplII.academico.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import br.unipe.cc.mlpIII.academico.facade.Academico;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Professor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Professor frame = new Professor();
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
	public Professor() {
		setTitle("Sistema Acad\u00EAmico Source - Professor");
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\Ico.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 0, 0, 0));
		menuBar.setOpaque(false);
		contentPane.add(menuBar, BorderLayout.NORTH);
		
		JMenu mnAlunos = new JMenu("Aluno");
		mnAlunos.setBackground(Color.DARK_GRAY);
		mnAlunos.setForeground(Color.ORANGE);
		mnAlunos.setBorderPainted(false);
		menuBar.add(mnAlunos);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastrar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				String[] args = null;
				Cadastro.main(args);
			}
		});
		mntmNewMenuItem.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem.setForeground(Color.ORANGE);
		mntmNewMenuItem.setBorderPainted(false);
		mnAlunos.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listar");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				String[] args = null;
				Aluno.main(args);
			}
		});
		mntmNewMenuItem_1.setBackground(Color.DARK_GRAY);
		mntmNewMenuItem_1.setForeground(Color.ORANGE);
		mntmNewMenuItem_1.setBorderPainted(false);
		mnAlunos.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu = new JMenu("Disciplina");
		mnNewMenu.setBackground(Color.DARK_GRAY);
		mnNewMenu.setForeground(Color.ORANGE);
		mnNewMenu.setBorderPainted(false);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmCadastra = new JMenuItem("Cadastrar");
		mntmCadastra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				String[] args = null;
				CadastroDisciplina.main(args);
			}
		});
		mntmCadastra.setBackground(Color.DARK_GRAY);
		mntmCadastra.setForeground(Color.ORANGE);
		mntmCadastra.setBorderPainted(false);
		mnNewMenu.add(mntmCadastra);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				String[] args = null;
				Disciplina.main(args);
			}
		});
		mntmListar.setBackground(Color.DARK_GRAY);
		mntmListar.setForeground(Color.ORANGE);
		mntmListar.setBorderPainted(false);
		mnNewMenu.add(mntmListar);
		
		JMenu mnNewMenu1 = new JMenu("Professor");
		mnNewMenu1.setBackground(Color.DARK_GRAY);
		mnNewMenu1.setForeground(Color.ORANGE);
		mnNewMenu1.setBorderPainted(false);
		menuBar.add(mnNewMenu1);
		
		JMenuItem mntmCadastra1 = new JMenuItem("Cadastrar");
		mntmCadastra1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				String[] args = null;
				CadastroProfessor.main(args);
			}
		});
		mntmCadastra1.setBackground(Color.DARK_GRAY);
		mntmCadastra1.setForeground(Color.ORANGE);
		mntmCadastra1.setBorderPainted(false);
		mnNewMenu1.add(mntmCadastra1);
		
		JMenuItem mntmListar1 = new JMenuItem("Listar");
		mntmListar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				String[] args = null;
				Professor.main(args);
			}
		});
		mntmListar1.setBackground(Color.DARK_GRAY);
		mntmListar1.setForeground(Color.ORANGE);
		mntmListar1.setBorderPainted(false);
		mnNewMenu1.add(mntmListar1);
		
		JMenu mnSair = new JMenu("Sair");
		mnSair.setForeground(Color.ORANGE);
		mnSair.setBorderPainted(false);
		mnSair.setBackground(Color.DARK_GRAY);
		menuBar.add(mnSair);
		
		JMenuItem mntmSairDoSistema = new JMenuItem("Sair do Sistema");
		mntmSairDoSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				String[] args = null;
				Login.main(args);
			}
		});
		mntmSairDoSistema.setForeground(Color.ORANGE);
		mntmSairDoSistema.setBorderPainted(false);
		mntmSairDoSistema.setBackground(Color.DARK_GRAY);
		mnSair.add(mntmSairDoSistema);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		mnAjuda.setForeground(Color.ORANGE);
		mnAjuda.setBorderPainted(false);
		mnAjuda.setBackground(Color.DARK_GRAY);
		menuBar.add(mnAjuda);
		
		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mntmAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Para ver, excluir ou editar um professor,"
						+ "\nclique duas vezes sobre a linha que o corresponde."
						+ "\nPara gerar relatório de todos os professores,"
						+ "\nclique no botão 'Gerar Relatório' abaixo."
						+ "\nPara gerar relatório de alguns professores,"
						+ "\nselecione as linhas pressionando a tecla"
						+ "\n'Ctrl' ou 'Shift' e clique duas vezes."
						+ "\nOs relatórios são salvos na pasta 'relatorios'.");
			}
		});
		mntmAjuda.setForeground(Color.ORANGE);
		mntmAjuda.setBorderPainted(false);
		mntmAjuda.setBackground(Color.DARK_GRAY);
		mnAjuda.add(mntmAjuda);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		contentPane.add(panel, BorderLayout.EAST);
		
		table = new ReadOnlyTable();
		table.addMouseListener(new MouseAdapter() {
			private int linha;
			private String opcoes[] = {"Ver", "Editar", "Excluir"};
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2){
					int[] idx = table.getSelectedRows();
					if(idx.length > 1){
						Academico academico = new Academico();
						String opcoes[] = {"Salvar Relatório no Computador", "Salvar e Enviar Relatório por Email"};
						int i = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "Opções", -1, -1,null, opcoes, 0);
						if(i == 0){
							boolean exists = (new File("relatorios\\relatorioProfessor.csv")).exists();
							if(exists){
								(new File("relatorios\\relatorioProfessor.csv")).delete();
								criaArquivo(academico, idx, linha);
								JOptionPane.showMessageDialog(null, "Relatório gerado");
							}else{
								criaArquivo(academico, idx, linha);
								JOptionPane.showMessageDialog(null, "Relatório gerado");
							}
						}else if(i == 1){//Enviar por email
							boolean exists = (new File("relatorios\\relatorioProfessor.csv")).exists();
							if(exists){
								(new File("relatorios\\relatorioProfessor.csv")).delete();
								criaArquivo(academico, idx, linha);
							}else{
								criaArquivo(academico, idx, linha);
							}
							
							String emailAdress = JOptionPane.showInputDialog("Insira email");

							boolean resultado = academico.enviarEmail(emailAdress, "relatorioProfessor");
							if(resultado){
								JOptionPane.showMessageDialog(null, "Enviado por email");
							}	
						}
					}else{
						int i = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "Opções", -1, -1,null, opcoes, 0);
						 if(i == 0){
							 linha = table.getSelectedRow();
							 String nome = (String) table.getValueAt(linha, 1);
							 String sql = "SELECT * FROM professor WHERE nome LIKE '" + nome + "';";
							 br.unipe.cc.mlpIII.academico.model.Professor professor = new br.unipe.cc.mlpIII.academico.model.Professor();
							 Academico academico = new Academico();
							 professor = academico.buscarProfessor(sql);
							 JOptionPane.showMessageDialog(null, "Professor(a): " + professor.getNome() + "\n"
							 		+ "Matricula: " + professor.getMatricula() + "\n"
							 		+ "Identidade: " + professor.getIdentidade() + "\n"
							 		+ "CPF: " + professor.getCpf() + "\n"
							 		+ "Data de Nascimento: " + professor.getData_nascimento() + "\n"
							 		+ "Sexo: " + professor.getSexo() + "\n"
							 		+ "Estado Civil: " + professor.getEstado_civil() + "\n"
					 				+ "Telefone: " + professor.getTelefone() + "\n"
			 						+ "Email: " + professor.getEmail() + "\n"
	 								+ "Endereço: " + professor.getEndereco() + "\n"
	 		 						+ "Bairro: " + professor.getBairro() + "\n"
	 								+ "Cidade: " + professor.getCidade() + "\n"
	 								+ "Estado: " + professor.getEstado() + "\n"
	 								+ "CEP: " + professor.getCep() + "\n"
							 		+ "Profissão: " + professor.getProfissao() + "\n"
							 		+ "Titularidade: " + professor.getTitularidade() + "\n"
	 								+ "Data de Contratação: " + professor.getData_contratacao() + "\n"
	 								+ "Situação: " + professor.getSituacao() + "\n");
						 }else if(i == 1){
							 br.unipe.cc.mlpIII.academico.model.Professor professor = new br.unipe.cc.mlpIII.academico.model.Professor();
							 linha = table.getSelectedRow();
							 String nome = (String) table.getValueAt(linha, 1);
							 String sql = "SELECT * FROM professor WHERE nome LIKE '" + nome + "';";
							 Academico academico = new Academico();
							 professor = academico.buscarProfessor(sql);
							 dispose();
							 String[] args = null;
							 EditarProfessor.main(args, professor);
						 }else if(i == 2){
							 br.unipe.cc.mlpIII.academico.model.Professor professor = new br.unipe.cc.mlpIII.academico.model.Professor();
							 String nome = (String)table.getValueAt(table.getSelectedRow(), 1);
							 professor.setNome(nome);
							 Academico academico = new Academico();
							 boolean retorno = academico.deletarProfessor(professor);
							 if(retorno){
								 JOptionPane.showMessageDialog(null, "Professor " + nome + " excluido");
								 dispose();
								 String[] args = null;
								 Professor.main(args);
							 }else{
								 JOptionPane.showMessageDialog(null, "Erro ao excluir professor(a) " + nome);
							 }
						 }
					 }
				}
			}
		});
		table.setFillsViewportHeight(true);
		
		DefaultTableModel model = new DefaultTableModel();
		String[] nomeColunas = {"Matricula", "Nome"};
		model.setColumnIdentifiers(nomeColunas);
		
		List<br.unipe.cc.mlpIII.academico.model.Professor> lista = new ArrayList<>();
		Academico academico = new Academico();
		lista = academico.listarProfessor();
		
		List<String> nomes = new ArrayList<>();
		List<String> matriculas = new ArrayList<>();
		for(int i = 0; i < lista.size(); i++){
			br.unipe.cc.mlpIII.academico.model.Professor professor = new br.unipe.cc.mlpIII.academico.model.Professor();
			professor = lista.get(i);
			nomes.add(professor.getNome());
			matriculas.add(professor.getMatricula());
		}
		
		for(int i = 0; i < lista.size(); i++){
			model.addRow(new Object[]{matriculas.get(i), nomes.get(i)});
		}
		
		table.setModel(model);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 0));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.YELLOW));
		
		JButton btnGerarRelatrio = new JButton("Gerar Relat\u00F3rio");
		btnGerarRelatrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BtnGeraRelatorioActionPerformed(e);
			}
		});
		
		JLabel label = new JLabel("Matricula");
		
		JLabel label_1 = new JLabel("Nome");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnGerarRelatrio, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(132)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addGap(93)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
						.addComponent(table, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(131, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(label_1))
					.addGap(18)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 332, Short.MAX_VALUE)
					.addComponent(btnGerarRelatrio, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel lblAlunos = new JLabel("Professores");
		lblAlunos.setFont(new Font("Tahoma", Font.BOLD, 31));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(235, Short.MAX_VALUE)
					.addComponent(lblAlunos)
					.addGap(231))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(30, Short.MAX_VALUE)
					.addComponent(lblAlunos)
					.addGap(27))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
	}

	protected void criaArquivo(Academico academico, int[] idx, int linha) {
		for (int l = 0; l < idx.length; l++){
			linha = idx[l];
			String nome = (String) table.getValueAt(linha, 1);
			String sql = "SELECT * FROM professor WHERE nome LIKE '" + nome + "';";
			br.unipe.cc.mlpIII.academico.model.Professor professor = new br.unipe.cc.mlpIII.academico.model.Professor();
			professor = academico.buscarProfessor(sql);
			academico.relatorioProfessor(professor);
		}
	}

	protected void BtnGeraRelatorioActionPerformed(ActionEvent e) {
		Academico academico = new Academico();
		String opcoes[] = {"Salvar Relatório no Computador", "Salvar e Enviar Relatório por Email"};
		int i = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "Opções", -1, -1,null, opcoes, 0);
		if(i == 0){
			boolean result = academico.relatorioProfessor();
			if(result){
				JOptionPane.showMessageDialog(null, "Relatório gerado");
			}else{
				JOptionPane.showMessageDialog(null, "Erro em geração de relatório");
			}
		}else if(i == 1){
			boolean result = academico.relatorioProfessor();
			if(result){
				String emailAdress = JOptionPane.showInputDialog("Insira email");

				boolean resultado = academico.enviarEmail(emailAdress, "RelatorioProfessor");
				if(resultado){
					JOptionPane.showMessageDialog(null, "Enviado por email");
				}else{
					JOptionPane.showMessageDialog(null, "Erro ao enviar por email");
				}
			}
			
		}
	}
}
