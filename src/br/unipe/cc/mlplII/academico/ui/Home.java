package br.unipe.cc.mlplII.academico.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Home extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setTitle("Sistema Acadêmico Source - Home");
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\Ico.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 0));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
		);
		
		JButton button = new JButton("");
		button.setBounds(322, 228, 164, 147);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				String[] args = null;
				Disciplina.main(args);
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				String[] args = null;
				Disciplina.main(args);
			}
		});
		button.setIcon(new ImageIcon("images\\ic_description_black_48dp.png"));
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBackground(new Color(0, 0, 0, 0));
		
		JButton button_1 = new JButton("");
		button_1.setBounds(138, 228, 164, 147);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				String[] args = null;
				Aluno.main(args);
			}
		});
		button_1.setIcon(new ImageIcon("images\\ic_supervisor_account_black_48dp.png"));
		button_1.setOpaque(false);
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.setBackground(new Color(0, 0, 0, 0));
		
		JLabel label = new JLabel("Alunos");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(138, 167, 164, 37);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				String[] args = null;
				Aluno.main(args);
			}
		});
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel label_1 = new JLabel("Disciplinas");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(322, 172, 164, 27);
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				String[] args = null;
				Disciplina.main(args);
			}
		});
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 634, 99);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.YELLOW));
		panel_1.setBackground(new Color(255, 204, 0));
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setFont(new Font("Tahoma", Font.BOLD, 31));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(253)
					.addComponent(lblHome)
					.addContainerGap(286, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(23)
					.addComponent(lblHome)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panel.add(panel_1);
		panel.add(button_1);
		panel.add(label);
		panel.add(label_1);
		panel.add(button);
		contentPane.setLayout(gl_contentPane);
	}

}
