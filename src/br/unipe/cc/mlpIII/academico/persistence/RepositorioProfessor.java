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

import br.unipe.cc.mlpIII.academico.model.Professor;

public class RepositorioProfessor implements IProfessor{
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
	public int getDisciplinaId(String disciplina){
		int id = 0;
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			
			String sql = "SELECT id FROM disciplina WHERE nome LIKE '" + disciplina + "';";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				id = rs.getInt("id");
			}
			close();
		}catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return id;
	}

	@Override
	public boolean inserir(Professor professor) throws EntidadeJaCadastradaException {
		boolean resultado = false;
		
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			
			String sql = "INSERT INTO professor(matricula, data_contratacao, situacao, profissao, titularidade, nome, identidade,"
					+ " cpf, estado_civil, sexo, data_nascimento, email, telefone, endereco, bairro, cidade, estado, cep, disciplina_id) "
					+ "VALUES ('" + professor.getMatricula() + "', '" + professor.getData_contratacao() + "', '" 
					+ professor.getSituacao() + "', '" + professor.getProfissao() + "', '" + professor.getTitularidade()
					+ "', '" + professor.getNome() + "', '" + professor.getIdentidade() + "', '" + professor.getCpf() 
					+ "', '" + professor.getEstado_civil() + "', '" + professor.getSexo() + "', '" + professor.getData_nascimento() 
					+ "', '" + professor.getEmail() + "', '" + professor.getTelefone() + "', '" + professor.getEndereco() 
					+ "', '" + professor.getBairro() + "', '" + professor.getCidade() + "', '" + professor.getEstado() 
					+ "', '" + professor.getCep() + "', '" + professor.getDisciplina_id() +"');";
			
			int linhas = stmt.executeUpdate(sql);
			if(linhas != 0){
				resultado = true;
			}
			close();
		}catch (ClassNotFoundException e) {
			throw new EntidadeJaCadastradaException("Professor já cadastrado");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return resultado;
	}
	
	@Override
	public Professor buscar(String sql) throws EntidadeNaoEncontradaException{
		Professor professor = new Professor();
		try {
			conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String matricula = rs.getString("matricula");
				String situacao = rs.getString("situacao");
				String profissao = rs.getString("profissao");
				String data_contratacao = rs.getString("data_contratacao");
				String titularidade = rs.getString("titularidade");
				String nome = rs.getString("nome");
				String identidade = rs.getString("identidade");
				String cpf = rs.getString("cpf");
				String estado_civil = rs.getString("estado_civil");
				String sexo = rs.getString("sexo");
				String data_nascimento = rs.getString("data_nascimento");
				String email = rs.getString("email");
				String telefone = rs.getString("telefone");
				String endereco = rs.getString("endereco");
				String bairro = rs.getString("bairro");
				String cidade = rs.getString("cidade");
				String estado = rs.getString("estado");
				String cep = rs.getString("cep");
				
				professor.setMatricula(matricula);
				professor.setSituacao(situacao);
				professor.setProfissao(profissao);
				professor.setData_contratacao(data_contratacao);
				professor.setTitularidade(titularidade);
				professor.setNome(nome);
				professor.setIdentidade(identidade);
				professor.setCpf(cpf);
				professor.setEstado_civil(estado_civil);
				professor.setSexo(sexo);
				professor.setData_nascimento(data_nascimento);
				professor.setEmail(email);
				professor.setTelefone(telefone);
				professor.setEndereco(endereco);
				professor.setBairro(bairro);
				professor.setCidade(cidade);
				professor.setEstado(estado);
				professor.setCep(cep);

			}
			close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (ClassNotFoundException e){
			throw new EntidadeNaoEncontradaException("Professor não encontrado");
		}
		return professor;
	}
	
	
	
	@Override
	public List<Professor> listar() {
		List<Professor> professores = new ArrayList<Professor>();
		try {
			conn = getConnection();
			Statement stmt = conn.createStatement();
			String sql = "SELECT matricula, nome FROM professor";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Professor professor = new Professor();
				String nome = rs.getString("nome");
				String matricula = rs.getString("matricula");
				professor.setMatricula(matricula);
				professor.setNome(nome);
				professores.add(professor);
			}
			close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (ClassNotFoundException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return professores;
	}

	@Override
	public boolean atualizar(Professor professor) {
		boolean resultado = false;
		
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			int id = 0;
			
			String nome = professor.getNome();
			String sql = "SELECT id FROM professor WHERE nome LIKE '" + nome + "';";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				id = rs.getInt("id");
			}
						
			sql = "UPDATE professor SET nome = '" + professor.getNome() + "', matricula = '"
					+ professor.getMatricula() + "', data_contratacao = '" + professor.getData_contratacao() + "', "
					+ "situacao = '" +  professor.getSituacao() + "', profissao = '" + professor.getProfissao() + "', "
					+ "titularidade = '" + professor.getTitularidade() + "', identidade = '" + professor.getIdentidade() +"', "
					+ "cpf = '" + professor.getCpf() + "', estado_civil = '" + professor.getEstado_civil() + "', "
					+ "sexo = '" + professor.getSexo() + "', data_nascimento = '" + professor.getData_nascimento() + "', "
					+ "email = '" + professor.getEmail() + "', telefone = '" + professor.getTelefone() + "', "
					+ "endereco = '" + professor.getEndereco() + "', bairro = '" + professor.getBairro() + "', "
					+ "cidade = '" + professor.getCidade() + "', estado = '" + professor.getEstado() + "', cep = '"
					+ professor.getCep()+ "' WHERE id LIKE " + id + ";";
			
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
	public boolean deletar(Professor professor) {
		boolean resultado = false;
		int id = 0;
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			
			String nome = professor.getNome();
			String sql = "SELECT id FROM professor WHERE nome LIKE '" + nome + "';";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				id = rs.getInt("id");
			}
			
			sql = "DELETE FROM cursa WHERE professor_id LIKE " + id;
			int linhas = stmt.executeUpdate(sql);
			if(linhas != 0){
				sql = "DELETE FROM professor WHERE id LIKE " + id;
				
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
			
			FileWriter arquivo = new FileWriter("relatorios\\RelatorioProfessor.csv");
			arquivo.append("Relatório de Professores\n");
			
			conn = getConnection();
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM professor";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String matricula = rs.getString("matricula");
				String name = rs.getString("nome");
				String profissao = rs.getString("profissao");
				String titularidade = rs.getString("titularidade");
				String identidade = rs.getString("identidade");
				String cpf = rs.getString("cpf");
				String estado_civil = rs.getString("estado_civil");
				String sexo = rs.getString("sexo");
				String data_nascimento = rs.getString("data_nascimento");
				String email = rs.getString("email");
				String telefone = rs.getString("telefone");
				String endereco = rs.getString("endereco");
				String bairro = rs.getString("bairro");
				String cidade = rs.getString("cidade");
				String estado = rs.getString("estado");
				String cep = rs.getString("cep");
				String data_contratacao = rs.getString("data_contratacao");
				String situacao = rs.getString("situacao");
				
				arquivo.append(matricula);
				arquivo.append(',');
				arquivo.append(name);
				arquivo.append(',');
				arquivo.append(titularidade);
				arquivo.append(',');
				arquivo.append(identidade);
				arquivo.append(',');
				arquivo.append(cpf);
				arquivo.append(',');
				arquivo.append(estado_civil);
				arquivo.append(',');
				arquivo.append(sexo);
				arquivo.append(',');
				arquivo.append(profissao);
				arquivo.append(',');
				arquivo.append(data_nascimento);
				arquivo.append(',');
				arquivo.append(email);
				arquivo.append(',');
				arquivo.append(telefone);
				arquivo.append(',');
				arquivo.append(endereco);
				arquivo.append(',');
				arquivo.append(bairro);
				arquivo.append(',');
				arquivo.append(cidade);
				arquivo.append(',');
				arquivo.append(estado);
				arquivo.append(',');
				arquivo.append(cep);
				arquivo.append(',');
				arquivo.append(data_contratacao);
				arquivo.append(',');
				arquivo.append(situacao);
				arquivo.append("\n");
			}
			close();
			
			arquivo.flush();
	        arquivo.close();
	        
	        return true;
			
		}catch(IOException e){
			throw new RelatorioException("Erro na geração de Relatório");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}catch(ClassNotFoundException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}

	@Override
	public boolean relatorio(Professor professor) throws RelatorioException {
		try{
			
			BufferedWriter arquivo = new BufferedWriter(new FileWriter("relatorios\\relatorioProfessor.csv", true));
			
			conn = getConnection();
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM professor WHERE nome LIKE '" + professor.getNome() + "';";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String matricula = rs.getString("matricula");
				String name = rs.getString("nome");
				String profissao = rs.getString("profissao");
				String titularidade = rs.getString("titularidade");
				String identidade = rs.getString("identidade");
				String cpf = rs.getString("cpf");
				String estado_civil = rs.getString("estado_civil");
				String sexo = rs.getString("sexo");
				String data_nascimento = rs.getString("data_nascimento");
				String email = rs.getString("email");
				String telefone = rs.getString("telefone");
				String endereco = rs.getString("endereco");
				String bairro = rs.getString("bairro");
				String cidade = rs.getString("cidade");
				String estado = rs.getString("estado");
				String cep = rs.getString("cep");
				String data_contratacao = rs.getString("data_contratacao");
				String situacao = rs.getString("situacao");
				
				arquivo.append(matricula);
				arquivo.append(',');
				arquivo.append(name);
				arquivo.append(',');
				arquivo.append(titularidade);
				arquivo.append(',');
				arquivo.append(identidade);
				arquivo.append(',');
				arquivo.append(cpf);
				arquivo.append(',');
				arquivo.append(estado_civil);
				arquivo.append(',');
				arquivo.append(sexo);
				arquivo.append(',');
				arquivo.append(profissao);
				arquivo.append(',');
				arquivo.append(data_nascimento);
				arquivo.append(',');
				arquivo.append(email);
				arquivo.append(',');
				arquivo.append(telefone);
				arquivo.append(',');
				arquivo.append(endereco);
				arquivo.append(',');
				arquivo.append(bairro);
				arquivo.append(',');
				arquivo.append(cidade);
				arquivo.append(',');
				arquivo.append(estado);
				arquivo.append(',');
				arquivo.append(cep);
				arquivo.append(',');
				arquivo.append(data_contratacao);
				arquivo.append(',');
				arquivo.append(situacao);
				arquivo.append("\n");
			}
			close();
			
			arquivo.flush();
	        arquivo.close();
	        
	        return true;
			
		}catch(IOException e){
			throw new RelatorioException("Erro na geração de Relatório");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}catch(ClassNotFoundException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}

}
