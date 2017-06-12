package br.unipe.cc.mlplII.academico.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import br.unipe.cc.mlpIII.academico.facade.Academico;
import br.unipe.cc.mlpIII.academico.model.Professor;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;

public class EditarProfessor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nome;
	private JTextField matricula;
	private JTextField identidade;
	private JTextField profissao;
	private JTextField email;
	private JTextField endereco;
	private JTextField bairro;
	private JTextField cidade;
	private JTextField estado;
	private JFormattedTextField data_nascimento;
	private JFormattedTextField data_contratacao;
	private JTextField titularidade;
	private JComboBox<String> sexo;
	private JComboBox<String> estado_civil;
	private JFormattedTextField telefone;
	private JComboBox<String> situacao;
	private JFormattedTextField cpf;
	private JFormattedTextField cep;
	private JComboBox<String> disciplina;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, br.unipe.cc.mlpIII.academico.model.Professor professor) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarProfessor frame = new EditarProfessor(professor);
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
	public EditarProfessor(Professor professor) {
		setTitle("Sistema Acad\u00EAmico Source - Editar Professor");
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
				br.unipe.cc.mlplII.academico.ui.Professor.main(args);
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
		
		//Painel para conteúdo
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 634, 99);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.YELLOW));
		panel_1.setBackground(new Color(255, 204, 0));
		
		JLabel lblCadastrarAluno = new JLabel("Editar Professor");
		lblCadastrarAluno.setFont(new Font("Tahoma", Font.BOLD, 31));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(193, Short.MAX_VALUE)
					.addComponent(lblCadastrarAluno)
					.addGap(189))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(28)
					.addComponent(lblCadastrarAluno)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(169, 464, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				String[] args = null;
				br.unipe.cc.mlplII.academico.ui.Professor.main(args);
			}
		});
		btnCancelar.setBackground(new Color(255, 255, 255));
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(358, 464, 103, 23);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BtnCadastarActionPerformed(e);
				JOptionPane.showMessageDialog(null, "Cadastro Efetuado com Sucesso");
				dispose();
				String[] args = null;
				br.unipe.cc.mlplII.academico.ui.Professor.main(args);
			}
		});
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
		panel.add(panel_1);
		panel.add(btnCancelar);
		panel.add(btnCadastrar);
		
		JLabel label = new JLabel("Nome");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(96, 110, 248, 15);
		panel.add(label);
		
		nome = new JTextField();
		nome.setText(professor.getNome());
		nome.setColumns(10);
		nome.setBounds(96, 126, 266, 20);
		panel.add(nome);
		
		JLabel label_1 = new JLabel("Matr\u00EDcula");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(372, 110, 66, 15);
		panel.add(label_1);
		
		matricula = new JTextField();
		matricula.setText(professor.getMatricula());
		matricula.setColumns(10);
		matricula.setBounds(373, 126, 163, 20);
		panel.add(matricula);
		
		JLabel label_2 = new JLabel("Identidade");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(96, 157, 136, 15);
		panel.add(label_2);
		
		identidade = new JTextField();
		identidade.setText(professor.getIdentidade());
		identidade.setColumns(10);
		identidade.setBounds(96, 171, 136, 20);
		panel.add(identidade);
		
		JLabel label_3 = new JLabel("CPF");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(242, 157, 133, 15);
		panel.add(label_3);
		
		cpf = new JFormattedTextField();
		cpf.setText(professor.getCpf());
		cpf.setBounds(242, 171, 133, 20);
		panel.add(cpf);
		
		JLabel label_4 = new JLabel("Sexo");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(382, 157, 153, 15);
		panel.add(label_4);
		
		sexo = new JComboBox();
		sexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		sexo.setSelectedItem(professor.getSexo());
		sexo.setBounds(382, 171, 153, 20);
		panel.add(sexo);
		
		JLabel label_5 = new JLabel("Estado Civil");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(96, 202, 153, 15);
		panel.add(label_5);
		
		estado_civil = new JComboBox();
		estado_civil.setModel(new DefaultComboBoxModel(new String[] {"Solteiro(a)", "Casado(a)", "Vi\u00FAvo(a)", "Uni\u00E3o Est\u00E1vel", "Divorciado(a)"}));
		estado_civil.setSelectedItem(professor.getEstado_civil());
		estado_civil.setBounds(96, 217, 133, 20);
		panel.add(estado_civil);
		
		JLabel label_6 = new JLabel("Data de nascimento");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(242, 202, 133, 15);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Profiss\u00E3o");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setBounds(411, 202, 66, 15);
		panel.add(label_7);
		
		profissao = new JTextField();
		profissao.setText(professor.getProfissao());
		profissao.setColumns(10);
		profissao.setBounds(411, 217, 124, 20);
		panel.add(profissao);
		
		email = new JTextField();
		email.setText(professor.getEmail());
		email.setColumns(10);
		email.setBounds(268, 262, 266, 20);
		panel.add(email);
		
		JLabel label_8 = new JLabel("Email");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_8.setBounds(270, 248, 136, 15);
		panel.add(label_8);
		
		telefone = new JFormattedTextField();
		telefone.setText(professor.getTelefone());
		telefone.setBounds(96, 262, 162, 20);
		panel.add(telefone);
		
		JLabel label_9 = new JLabel("Telefone");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_9.setBounds(97, 248, 133, 15);
		panel.add(label_9);
		
		endereco = new JTextField();
		endereco.setText(professor.getEndereco());
		endereco.setColumns(10);
		endereco.setBounds(96, 308, 196, 20);
		panel.add(endereco);
		
		JLabel label_10 = new JLabel("Endere\u00E7o");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10.setBounds(96, 293, 136, 15);
		panel.add(label_10);
		
		bairro = new JTextField();
		bairro.setText(professor.getBairro());
		bairro.setColumns(10);
		bairro.setBounds(298, 308, 124, 20);
		panel.add(bairro);
		
		JLabel label_11 = new JLabel("Bairro");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_11.setBounds(298, 293, 66, 15);
		panel.add(label_11);
		
		cidade = new JTextField();
		cidade.setText(professor.getCidade());
		cidade.setColumns(10);
		cidade.setBounds(432, 308, 103, 20);
		panel.add(cidade);
		
		JLabel label_12 = new JLabel("Cidade");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_12.setBounds(432, 293, 66, 15);
		panel.add(label_12);
		
		estado = new JTextField();
		estado.setText(professor.getEstado());
		estado.setColumns(10);
		estado.setBounds(96, 351, 153, 20);
		panel.add(estado);
		
		JLabel label_13 = new JLabel("Estado");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_13.setBounds(96, 339, 66, 15);
		panel.add(label_13);
		
		cep = new JFormattedTextField();
		cep.setText(professor.getCep());
		cep.setBounds(259, 351, 133, 20);
		panel.add(cep);
		
		JLabel label_14 = new JLabel("CEP");
		label_14.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_14.setBounds(259, 339, 133, 15);
		panel.add(label_14);
		
		situacao = new JComboBox();
		situacao.setModel(new DefaultComboBoxModel(new String[] {"Matriculado(a)", "N\u00E3o Matriculado(a)"}));
		situacao.setBounds(402, 351, 133, 20);
		situacao.setSelectedItem(professor.getSituacao());
		panel.add(situacao);
		
		JLabel label_15 = new JLabel("Situa\u00E7\u00E3o");
		label_15.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_15.setBounds(402, 339, 133, 15);
		panel.add(label_15);
		
		JLabel lblDataDaContratao = new JLabel("Data da Contrata\u00E7\u00E3o");
		lblDataDaContratao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDataDaContratao.setBounds(96, 382, 133, 15);
		panel.add(lblDataDaContratao);
		
		titularidade = new JTextField();
		titularidade.setText(professor.getTitularidade());
		titularidade.setBounds(268, 395, 267, 20);
		panel.add(titularidade);
		
		JLabel lblTitularidade = new JLabel("Titularidade");
		lblTitularidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitularidade.setBounds(268, 382, 133, 15);
		panel.add(lblTitularidade);
		
		data_nascimento = new JFormattedTextField();
		data_nascimento.setText(professor.getData_nascimento());
		data_nascimento.setBounds(242, 217, 159, 20);
		panel.add(data_nascimento);
		
		data_contratacao = new JFormattedTextField();
		data_contratacao.setText(professor.getData_contratacao());
		data_contratacao.setBounds(96, 395, 159, 20);
		panel.add(data_contratacao);
		
		disciplina = new JComboBox();
		disciplina.setBounds(96, 439, 267, 20);
		Academico academico = new Academico();
		List<br.unipe.cc.mlpIII.academico.model.Disciplina> disciplinas = new ArrayList<>();
		disciplinas = academico.listarDisciplina();
		for(int i = 0; i < disciplinas.size(); i++){
			br.unipe.cc.mlpIII.academico.model.Disciplina disc = new br.unipe.cc.mlpIII.academico.model.Disciplina();
			disc = disciplinas.get(i);
			disciplina.addItem(disc.getNome());
		}
		panel.add(disciplina);
		
		JLabel label_16 = new JLabel("Disciplina");
		label_16.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_16.setBounds(96, 426, 133, 15);
		panel.add(label_16);
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
		academico.atualizarProfessor(professor);
	}
}
