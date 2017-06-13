package br.unipe.cc.mlpIII.academico.persistence;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.unipe.cc.mlpIII.academico.model.Disciplina;

public class RepositorioDisciplina implements IDisciplina{
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	public Connection getConnection() throws ClassNotFoundException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://127.0.0.1/academico";
			String login = "root";
			String senha = "";
			
			conn = DriverManager.getConnection(url, login, senha);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return conn;
	}
	
	public void close(){
		try{
			if (conn != null)
				conn.close();
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	@Override
	public boolean inserir(Disciplina disciplina) throws EntidadeJaCadastradaException {
		boolean resultado = false;
		
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			
			String sql = "INSERT INTO disciplina(nome, descricao, data_criacao, situacao, semestre) "
					+ "VALUES ('" + disciplina.getNome() + "', '" + disciplina.getDescricao() +
					"', '" + disciplina.getData_criacao() + "', '" + disciplina.getSituacao() + 
					"', '" + disciplina.getSemestre() + "');";
			
			int linhas = stmt.executeUpdate(sql);
			if(linhas != 0){
				resultado = true;
			}
			close();
		}catch (ClassNotFoundException e) {
			throw new EntidadeJaCadastradaException("Disciplina já cadastrada");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return resultado;
	}
	
	public Disciplina buscar(String sql) throws EntidadeNaoEncontradaException{
		Disciplina disciplina = new Disciplina();
		try {
			conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");
				String semestre = rs.getString("semestre");
				String data_criacao = rs.getString("data_criacao");
				String situacao = rs.getString("situacao");
				disciplina.setNome(nome);
				disciplina.setSemestre(semestre);
				disciplina.setData_criacao(data_criacao);
				disciplina.setDescricao(descricao);
				disciplina.setSituacao(situacao);
			}
			close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (ClassNotFoundException e){
			throw new EntidadeNaoEncontradaException("Disciplina não encontrada");
		}
		return disciplina;
	}

	@Override
	public List<Disciplina> listar() {
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		try {
			conn = getConnection();
			Statement stmt = conn.createStatement();
			String sql = "SELECT semestre, nome FROM disciplina";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Disciplina disciplina = new Disciplina();
				String nome = rs.getString("nome");
				String semestre = rs.getString("semestre");
				disciplina.setNome(nome);
				disciplina.setSemestre(semestre);
				disciplinas.add(disciplina);
			}
			close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (ClassNotFoundException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return disciplinas;
	}

	@Override
	public boolean atualizar(Disciplina disciplina) {
		boolean resultado = false;
		
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			int id = 0;
			
			String nome = disciplina.getNome();
			String sql = "SELECT id FROM disciplina WHERE nome LIKE '" + nome + "';";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				id = rs.getInt("id");
			}
			
			sql = "UPDATE disciplina SET nome = '" + disciplina.getNome() + "', descricao = '"
					+ disciplina.getDescricao() + "', data_criacao = '" + disciplina.getData_criacao() + "', "
					+ "situacao = '" +  disciplina.getSituacao() + "', semestre = '" + disciplina.getSemestre() + "'"
					+ " WHERE id LIKE " + id + ";";
			
			int linhas = stmt.executeUpdate(sql);
			if(linhas != 0){
				resultado = true;
			}
			close();
		}catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return resultado;
	}

	@Override
	public boolean deletar(Disciplina disciplina) {
		boolean resultado = false;
		int id = 0;
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			
			String nome = disciplina.getNome();
			String sql = "SELECT id FROM disciplina WHERE nome LIKE '" + nome + "';";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				id = rs.getInt("id");
			}
			
			sql = "DELETE FROM cursa WHERE disciplina_id LIKE " + id;
			int linhas = stmt.executeUpdate(sql);
			if(linhas != 0){
				sql = "DELETE FROM disciplina WHERE id LIKE " + id;
				
				linhas = stmt.executeUpdate(sql);
				if(linhas != 0){
					resultado = true;
				}
			}
			
			close();
		}catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return resultado;
	}

	@Override
	public boolean relatorio() throws RelatorioException {
		try{
			
			FileWriter arquivo = new FileWriter("relatorios\\RelatorioDisciplina.csv");
			arquivo.append("Relatório de Disciplinas\n");
			
			conn = getConnection();
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM disciplina";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String name = rs.getString("nome");
				String semestre = rs.getString("semestre");
				String descricao = rs.getString("descricao");
				String data_criacao = rs.getString("data_criacao");
				String situacao = rs.getString("situacao");
				
				arquivo.append(name);
				arquivo.append(',');
				arquivo.append(descricao);
				arquivo.append(',');
				arquivo.append(semestre);
				arquivo.append(',');
				arquivo.append(data_criacao);
				arquivo.append(',');
				arquivo.append(situacao);
				arquivo.append("\n");
			}
			close();
			
			arquivo.flush();
	        arquivo.close();
	        
	        return true;
			
		}catch(IOException e){
			throw new RelatorioException("Erro ao gerar Relatório");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}catch(ClassNotFoundException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}

	@Override
	public boolean relatorio(Disciplina disciplina) throws RelatorioException {
		try{
			
			BufferedWriter arquivo = new BufferedWriter(new FileWriter("relatorios\\relatorioDisciplina.csv", true));
			arquivo.append("Relatório de Disciplinas\n");
			
			conn = getConnection();
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM disciplina WHERE nome LIKE '" + disciplina.getNome() + "';";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String name = rs.getString("nome");
				String semestre = rs.getString("semestre");
				String descricao = rs.getString("descricao");
				String data_criacao = rs.getString("data_criacao");
				String situacao = rs.getString("situacao");
				
				arquivo.append(name);
				arquivo.append(',');
				arquivo.append(descricao);
				arquivo.append(',');
				arquivo.append(semestre);
				arquivo.append(',');
				arquivo.append(data_criacao);
				arquivo.append(',');
				arquivo.append(situacao);
				arquivo.append("\n");
			}
			close();
			
			arquivo.flush();
	        arquivo.close();
	        
	        return true;
			
		}catch(IOException e){
			throw new RelatorioException("Erro ao gerar Relatório");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}catch(ClassNotFoundException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}

}
