package br.unipe.cc.mlplII.academico.ui;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

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

public class CadastroProfessor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField matricula;
	private JTextField identidade;
	private JTextField profissao;
	private JTextField email;
	private JTextField endereco;
	private JTextField bairro;
	private JTextField cidade;
	private JTextField estado;
	private JTextField nome;
	private JFormattedTextField data_nascimento;
	private JFormattedTextField data_contratacao;
	private JFormattedTextField telefone;
	private JTextField titularidade;
	private JComboBox<String> sexo;
	private JFormattedTextField cpf;
	private JComboBox<String> estado_civil;
	private JFormattedTextField cep;
	private JComboBox<String> situacao;
	private JComboBox<String> disciplina;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProfessor frame = new CadastroProfessor();
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
	public CadastroProfessor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\Ico.png"));
		setTitle("Sistema Acad\u00EAmico Source - Cadastro");
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
		
		//Painel para conteúdo
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 634, 99);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.YELLOW));
		panel_1.setBackground(new Color(255, 204, 0));
		
		JLabel lblCadastrarAluno = new JLabel("Cadastrar Professor");
		lblCadastrarAluno.setFont(new Font("Tahoma", Font.BOLD, 31));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(178)
					.addComponent(lblCadastrarAluno)
					.addContainerGap(201, Short.MAX_VALUE))
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
		lblNome.setBounds(83, 110, 248, 15);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblMatricula = new JLabel("Matr\u00EDcula");
		lblMatricula.setBounds(359, 110, 66, 15);
		lblMatricula.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		matricula = new JTextField();
		matricula.setBounds(360, 126, 163, 20);
		matricula.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento");
		lblDataDeNascimento.setBounds(229, 202, 133, 15);
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNDeIndentificao = new JLabel("Identidade");
		lblNDeIndentificao.setBounds(83, 157, 136, 15);
		lblNDeIndentificao.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		identidade = new JTextField();
		identidade.setBounds(83, 171, 136, 20);
		identidade.setColumns(10);
		
		sexo = new JComboBox();
		sexo.setBounds(369, 171, 153, 20);
		sexo.setModel(new DefaultComboBoxModel(new String[] {"", "Feminino", "Masculino"}));
		
		JLabel lblNascionalida = new JLabel("Sexo");
		lblNascionalida.setBounds(369, 157, 153, 15);
		lblNascionalida.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblCursos = new JLabel("Titularidade");
		lblCursos.setBounds(255, 382, 133, 15);
		lblCursos.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		titularidade = new JTextField();
		titularidade.setBounds(255, 395, 267, 20);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				String[] args = null;
				Professor.main(args);
			}
		});
		btnCancelar.setBounds(169, 485, 87, 23);
		btnCancelar.setBackground(new Color(255, 255, 255));
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BtnCadastarActionPerformed(e);
				JOptionPane.showMessageDialog(null, "Cadastro Efetuado com Sucesso");
				dispose();
				String[] args = null;
				Professor.main(args);
			}
		});
		btnCadastrar.setBounds(341, 485, 96, 23);
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
		panel.setLayout(null);
		panel.add(lblDataDeNascimento);
		panel.add(lblNome);
		panel.add(lblMatricula);
		panel.add(matricula);
		panel.add(lblNDeIndentificao);
		panel.add(identidade);
		panel.add(lblCursos);
		panel.add(titularidade);
		panel.add(sexo);
		panel.add(lblNascionalida);
		panel.add(panel_1);
		panel.add(btnCancelar);
		panel.add(btnCadastrar);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCpf.setBounds(229, 157, 133, 15);
		panel.add(lblCpf);
		
		cpf = new JFormattedTextField();
		cpf.setBounds(229, 171, 133, 20);
		try {
			cpf.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		panel.add(cpf);
		
		estado_civil = new JComboBox();
		estado_civil.setModel(new DefaultComboBoxModel(new String[] {"", "Solteiro(a)", "Casado(a)", "Vi\u00FAvo(a)", "Uni\u00E3o Est\u00E1vel", "Divorciado(a)"}));
		estado_civil.setBounds(83, 217, 133, 20);
		panel.add(estado_civil);
		
		JLabel lblEstadoCivil = new JLabel("Estado Civil");
		lblEstadoCivil.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEstadoCivil.setBounds(83, 202, 153, 15);
		panel.add(lblEstadoCivil);
		
		profissao = new JTextField();
		profissao.setColumns(10);
		profissao.setBounds(398, 217, 124, 20);
		panel.add(profissao);
		
		JLabel lblProfisso = new JLabel("Profiss\u00E3o");
		lblProfisso.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProfisso.setBounds(398, 202, 66, 15);
		panel.add(lblProfisso);
		
		telefone = new JFormattedTextField();
		telefone.setBounds(83, 262, 162, 20);
		try {
			telefone.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##) #####-####")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		panel.add(telefone);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefone.setBounds(84, 248, 133, 15);
		panel.add(lblTelefone);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(255, 262, 266, 20);
		
		panel.add(email);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(257, 248, 136, 15);
		panel.add(lblEmail);
		
		endereco = new JTextField();
		endereco.setColumns(10);
		endereco.setBounds(83, 308, 196, 20);
		panel.add(endereco);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEndereo.setBounds(83, 293, 136, 15);
		panel.add(lblEndereo);
		
		bairro = new JTextField();
		bairro.setColumns(10);
		bairro.setBounds(285, 308, 124, 20);
		panel.add(bairro);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBairro.setBounds(285, 293, 66, 15);
		panel.add(lblBairro);
		
		cidade = new JTextField();
		cidade.setColumns(10);
		cidade.setBounds(419, 308, 103, 20);
		panel.add(cidade);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCidade.setBounds(419, 293, 66, 15);
		panel.add(lblCidade);
		
		estado = new JTextField();
		estado.setColumns(10);
		estado.setBounds(83, 351, 153, 20);
		panel.add(estado);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEstado.setBounds(83, 339, 66, 15);
		panel.add(lblEstado);
		
		cep = new JFormattedTextField();
		cep.setBounds(246, 351, 133, 20);
		try {
			cep.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##.###-###")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		panel.add(cep);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCep.setBounds(246, 339, 133, 15);
		panel.add(lblCep);
		
		situacao = new JComboBox();
		situacao.setModel(new DefaultComboBoxModel(new String[] {"", "Matriculado(a)", "N\u00E3o Matriculado(a)"}));
		situacao.setBounds(389, 351, 133, 20);
		panel.add(situacao);
		
		JLabel lblSituao = new JLabel("Situa\u00E7\u00E3o");
		lblSituao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSituao.setBounds(389, 339, 133, 15);
		panel.add(lblSituao);
		
		JLabel lblDataContratacao = new JLabel("Data da Contrata\u00E7\u00E3o");
		lblDataContratacao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataContratacao.setBounds(83, 382, 133, 15);
		panel.add(lblDataContratacao);
		
		nome = new JTextField();
		nome.setColumns(10);
		nome.setBounds(83, 126, 266, 20);
		panel.add(nome);
		
		data_nascimento = new JFormattedTextField();
		data_nascimento.setBounds(229, 217, 159, 20);
		try {
			data_nascimento.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		panel.add(data_nascimento);
		
		data_contratacao = new JFormattedTextField();
		data_contratacao.setBounds(83, 395, 159, 20);
		try {
			data_contratacao.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		panel.add(data_contratacao);
		
		disciplina = new JComboBox();
		disciplina.setBounds(84, 439, 267, 20);
		Academico academico = new Academico();
		List<br.unipe.cc.mlpIII.academico.model.Disciplina> disciplinas = new ArrayList<>();
		disciplinas = academico.listarDisciplina();
		for(int i = 0; i < disciplinas.size(); i++){
			br.unipe.cc.mlpIII.academico.model.Disciplina disc = new br.unipe.cc.mlpIII.academico.model.Disciplina();
			disc = disciplinas.get(i);
			disciplina.addItem(disc.getNome());
		}
		panel.add(disciplina);
		
		JLabel label = new JLabel("Disciplina");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(84, 426, 133, 15);
		panel.add(label);
		contentPane.setLayout(gl_contentPane);
	}

	protected void BtnCadastarActionPerformed(ActionEvent e) {
		br.unipe.cc.mlpIII.academico.model.Professor professor = new br.unipe.cc.mlpIII.academico.model.Professor();
		professor.setBairro(bairro.getText());
		professor.setCep(cep.getText());
		professor.setCidade(cidade.getText());
		professor.setCpf(cpf.getText());
		professor.setData_contratacao(data_contratacao.getText());
		professor.setData_nascimento(data_nascimento.getText());
		professor.setEmail(email.getText());
		professor.setEndereco(endereco.getText());
		professor.setEstado(estado.getText());
		professor.setEstado_civil((estado_civil.getSelectedItem()).toString());
		professor.setIdentidade(identidade.getText());
		professor.setMatricula(matricula.getText());
		professor.setNome(nome.getText());
		professor.setProfissao(profissao.getText());
		professor.setSexo((sexo.getSelectedItem()).toString());
		professor.setSituacao((situacao.getSelectedItem()).toString());
		professor.setTelefone(telefone.getText());
		professor.setTitularidade(titularidade.getText());
		
		Academico academico = new Academico();
		int disciplina_id = academico.getDisciplinaId((disciplina.getSelectedItem()).toString());
		professor.setDisciplina_id(disciplina_id);
		academico.salvarProfessor(professor);
		
	}
}
