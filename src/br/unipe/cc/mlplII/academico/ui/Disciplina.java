package br.unipe.cc.mlplII.academico.ui;


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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import br.unipe.cc.mlpIII.academico.facade.Academico;

public class Disciplina extends JFrame {
	
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
					Disciplina frame = new Disciplina();
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
	public Disciplina() {
		setTitle("Sistema Acadêmico Source - Disciplina");
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\Ico.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(0, 0, 0, 0));
		menuBar.setOpaque(false);
		
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		
		
		
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
						if(i == 0){//Salvar Relatório no Computador
							boolean exists = (new File("relatorios\\relatorioDisciplina.csv")).exists();
							if(exists){
								(new File("relatorios\\relatorioDisciplina.csv")).delete();
								criaArquivo(academico, idx, linha);
								JOptionPane.showMessageDialog(null, "Relatório gerado");
							}else{
								criaArquivo(academico, idx, linha);
								JOptionPane.showMessageDialog(null, "Relatório gerado");
							}							
						}else if(i == 1){//Enviar por email
							boolean exists = (new File("relatorios\\relatorioDisciplina.csv")).exists();
							if(exists){
								(new File("relatorios\\relatorioDisciplina.csv")).delete();
								criaArquivo(academico, idx, linha);
							}else{
								criaArquivo(academico, idx, linha);
							}
							
							String emailAdress = JOptionPane.showInputDialog("Insira email");

							boolean resultado = academico.enviarEmail(emailAdress, "relatorioDisciplina");
							if(resultado){
								JOptionPane.showMessageDialog(null, "Enviado por email");
							}	
						}
					}else{
						int i = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "Opções", -1, -1,null, opcoes, 0);
						 if(i == 0){
							 linha = table.getSelectedRow();
							 String nome = (String) table.getValueAt(linha, 1);
							 String sql = "SELECT * FROM disciplina WHERE nome LIKE '" + nome + "';";
							 br.unipe.cc.mlpIII.academico.model.Disciplina disciplina = new br.unipe.cc.mlpIII.academico.model.Disciplina();
							 Academico academico = new Academico();
							 disciplina = academico.buscarDisciplina(sql);
							 JOptionPane.showMessageDialog(null, "Disciplina " + disciplina.getNome() + "\n"
							 		+ "Descrição: " + disciplina.getDescricao() + "\n"
							 		+ "Semestre: " + disciplina.getSemestre() + "\n"
							 		+ "Situação: " + disciplina.getSituacao() + "\n"
							 		+ "Data de Criação: " + disciplina.getData_criacao());
						 }else if(i == 1){
							 br.unipe.cc.mlpIII.academico.model.Disciplina disciplina = new br.unipe.cc.mlpIII.academico.model.Disciplina();
							 linha = table.getSelectedRow();
							 String nome = (String) table.getValueAt(linha, 1);
							 String sql = "SELECT * FROM disciplina WHERE nome LIKE '" + nome + "';";
							 Academico academico = new Academico();
							 disciplina = academico.buscarDisciplina(sql);
							 dispose();
							 String[] args = null;
							 EditarDisciplina.main(args, disciplina);
						 }else if(i == 2){
							 br.unipe.cc.mlpIII.academico.model.Disciplina disciplina = new br.unipe.cc.mlpIII.academico.model.Disciplina();
							 String nome = (String)table.getValueAt(table.getSelectedRow(), 1);
							 disciplina.setNome(nome);
							 Academico academico = new Academico();
							 boolean retorno = academico.deletarDisciplina(disciplina);
							 if(retorno){
								 JOptionPane.showMessageDialog(null, "Disiciplina " + nome + " excluida");
								 dispose();
								 String[] args = null;
								 Disciplina.main(args);
							 }else{
								 JOptionPane.showMessageDialog(null, "Erro ao excluir disciplina " + nome);
							 }
						 }
					 
					 }
				}
			}
		});
		table.setFillsViewportHeight(true);
		
		DefaultTableModel model = new DefaultTableModel();
		String[] nomeColunas = {"Semestre", "Nome"};
		model.setColumnIdentifiers(nomeColunas);
		
		List<br.unipe.cc.mlpIII.academico.model.Disciplina> lista = new ArrayList<>();
		Academico academico = new Academico();
		lista = academico.listarDisciplina();
		
		List<String> nomes = new ArrayList<>();
		List<String> semestres = new ArrayList<>();
		for(int i = 0; i < lista.size(); i++){
			br.unipe.cc.mlpIII.academico.model.Disciplina disciplina = new br.unipe.cc.mlpIII.academico.model.Disciplina();
			disciplina = lista.get(i);
			nomes.add(disciplina.getNome());
			semestres.add(disciplina.getSemestre());
		}
		
		for(int i = 0; i < lista.size(); i++){
			model.addRow(new Object[]{semestres.get(i), nomes.get(i)});
		}
		
		table.setModel(model);
		
		
		
		JButton btnGeraRelatorio = new JButton("Gerar Relat\u00F3rio");
		btnGeraRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BtnGeraRelatorioActionPerformed(e);
			}
		});
		btnGeraRelatorio.setBackground(new Color(255, 255, 255));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 0));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.YELLOW));
		
		JLabel lblSemestre = new JLabel("Semestre");
		
		JLabel lblDisciplina = new JLabel("Disciplina");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(126)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(table, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblSemestre, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblDisciplina, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(125, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnGeraRelatorio)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSemestre)
						.addComponent(lblDisciplina))
					.addGap(18)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnGeraRelatorio)
					.addContainerGap())
		);
		panel_1.setLayout(null);
		
		JLabel lblAlunos = new JLabel("Disciplinas");
		lblAlunos.setBounds(236, 32, 166, 38);
		lblAlunos.setFont(new Font("Tahoma", Font.BOLD, 31));
		panel_1.add(lblAlunos);
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, 634, GroupLayout.PREFERRED_SIZE)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 540, GroupLayout.PREFERRED_SIZE))
		);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		mnAjuda.setForeground(Color.ORANGE);
		mnAjuda.setBorderPainted(false);
		mnAjuda.setBackground(Color.DARK_GRAY);
		menuBar.add(mnAjuda);
		
		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mntmAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Para ver, excluir ou editar uma disciplina,"
						+ "\nclique duas vezes sobre a linha que a corresponde."
						+ "\nPara gerar relatório de todas as disciplinas,"
						+ "\nclique no botão 'Gerar Relatório' abaixo."
						+ "\nPara gerar relatório de algumas disciplinas,"
						+ "\nselecione as linhas pressionando a tecla"
						+ "\n'Ctrl' ou 'Shift' e clique duas vezes."
						+ "\nOs relatórios são salvos na pasta 'relatorios'.");
			}
		});
		mntmAjuda.setForeground(Color.ORANGE);
		mntmAjuda.setBorderPainted(false);
		mntmAjuda.setBackground(Color.DARK_GRAY);
		mnAjuda.add(mntmAjuda);
		contentPane.setLayout(gl_contentPane);
	}

	protected void criaArquivo(Academico academico, int[] idx, int linha) {
		for (int l = 0; l < idx.length; l++){
			linha = idx[l];
			String nome = (String) table.getValueAt(linha, 1);
			String sql = "SELECT * FROM disciplina WHERE nome LIKE '" + nome + "';";
			br.unipe.cc.mlpIII.academico.model.Disciplina disciplina = new br.unipe.cc.mlpIII.academico.model.Disciplina();
			disciplina = academico.buscarDisciplina(sql);
			academico.relatorioDisciplina(disciplina);
		 }
	}

	protected void BtnGeraRelatorioActionPerformed(ActionEvent e) {
		Academico academico = new Academico();
		String opcoes[] = {"Salvar Relatório no Computador", "Salvar e Enviar Relatório por Email"};
		int i = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "Opções", -1, -1,null, opcoes, 0);
		if(i == 0){
			boolean result = academico.relatorioDisciplina();
			if(result){
				JOptionPane.showMessageDialog(null, "Relatório gerado");
			}else{
				JOptionPane.showMessageDialog(null, "Erro em geração de relatório");
			}
		}else if(i == 1){
			boolean result = academico.relatorioDisciplina();
			if(result){
				String emailAdress = JOptionPane.showInputDialog("Insira email");

				boolean resultado = academico.enviarEmail(emailAdress, "RelatorioDisciplina");
				if(resultado){
					JOptionPane.showMessageDialog(null, "Enviado por email");
				}else{
					JOptionPane.showMessageDialog(null, "Erro ao enviar por email");
				}
			}
			
		}
	}
}

class ReadOnlyTable extends JTable{
	private static final long serialVersionUID = 5474326340388431636L;
	public ReadOnlyTable(){
		super();
	}
	public boolean isCellEditable(int row, int column){
		return false;
	}
}
