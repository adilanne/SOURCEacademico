package br.unipe.cc.mlplII.academico.ui;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import br.unipe.cc.mlpIII.academico.facade.Academico;

public class CadastroDisciplina extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFormattedTextField data_criacao;
	private JTextField descricao;
	private JTextField nome;
	private JTextField semestre;
	private JComboBox<String> situacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroDisciplina frame = new CadastroDisciplina();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public CadastroDisciplina() {
		setTitle("Sistema Acad�mico Source - Cadastrar Disciplina");
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\Ico.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//Menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setEnabled(false);
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
		
		//Painel para conte�do
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 634, 99);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.YELLOW));
		panel_1.setBackground(new Color(255, 204, 0));
		
		JLabel lblCadastrarAluno = new JLabel("Cadastrar Disciplina");
		lblCadastrarAluno.setFont(new Font("Tahoma", Font.BOLD, 31));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(160, Short.MAX_VALUE)
					.addComponent(lblCadastrarAluno)
					.addGap(158))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(28)
					.addComponent(lblCadastrarAluno)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(83, 153, 34, 15);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		nome = new JTextField();
		nome.setBounds(83, 166, 439, 20);
		((JTextField) nome).setColumns(10);
		
		JLabel lblMatricula = new JLabel("Descri\u00E7\u00E3o");
		lblMatricula.setBounds(83, 197, 66, 15);
		lblMatricula.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		descricao = new JTextField();
		descricao.setBounds(83, 211, 439, 41);
		descricao.setColumns(10);
		
		JLabel lblNDeIndentificao = new JLabel("Semestre");
		lblNDeIndentificao.setBounds(265, 263, 126, 15);
		lblNDeIndentificao.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		semestre = new JTextField();
		semestre.setBounds(265, 276, 145, 20);
		semestre.setColumns(10);
		
		JLabel lblNascionalida = new JLabel("Situa\u00E7\u00E3o");
		lblNascionalida.setBounds(420, 262, 102, 15);
		lblNascionalida.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				String[] args = null;
				Disciplina.main(args);
			}
		});
		btnCancelar.setBounds(169, 464, 94, 23);
		btnCancelar.setBackground(new Color(255, 255, 255));
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BtnCadastarActionPerformed(e);
				JOptionPane.showMessageDialog(null, "Cadastro Efetuado com Sucesso");
				dispose();
				String[] args = null;
				Disciplina.main(args);
			}
		});
		btnCadastrar.setBounds(358, 464, 94, 23);
		btnCadastrar.setBackground(new Color(255, 255, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, 634, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 634, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 529, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(null);
		panel.add(nome);
		panel.add(lblNome);
		panel.add(lblNascionalida);
		panel.add(lblMatricula);
		panel.add(descricao);
		panel.add(lblNDeIndentificao);
		panel.add(semestre);
		panel.add(panel_1);
		panel.add(btnCancelar);
		panel.add(btnCadastrar);
		
		JLabel lblDataDaCriao = new JLabel("Data da Cria\u00E7\u00E3o");
		lblDataDaCriao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataDaCriao.setBounds(83, 263, 133, 15);
		panel.add(lblDataDaCriao);
		
		data_criacao = new JFormattedTextField();
		data_criacao.setBounds(83, 276, 168, 20);
		try {
			data_criacao.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		panel.add(data_criacao);
		
		situacao = new JComboBox();
		situacao.setModel(new DefaultComboBoxModel(new String[] {"Dispon\u00EDvel", "N\u00E3o dispon\u00EDvel"}));
		situacao.setBounds(420, 276, 102, 20);
		panel.add(situacao);
		contentPane.setLayout(gl_contentPane);
	}

	protected void BtnCadastarActionPerformed(ActionEvent e) {
		br.unipe.cc.mlpIII.academico.model.Disciplina disciplina = new br.unipe.cc.mlpIII.academico.model.Disciplina();
		disciplina.setData_criacao(data_criacao.getText());
		disciplina.setDescricao(descricao.getText());
		disciplina.setNome(nome.getText());
		disciplina.setSemestre(semestre.getText());
		disciplina.setSituacao((situacao.getSelectedItem()).toString());
		
		Academico academico = new Academico();
		academico.salvarDisciplina(disciplina);
	}
}