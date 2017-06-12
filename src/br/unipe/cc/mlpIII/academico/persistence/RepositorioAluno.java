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

import br.unipe.cc.mlpIII.academico.model.Aluno;

/**
 * Class that establishes connection with database 
 * @author Adilanne
 *
 */

public class RepositorioAluno implements IAluno{
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
			e.printStackTrace();
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
			e.printStackTrace();
		}
	}
	
	public List<Aluno> listar(){
		List<Aluno> alunos = new ArrayList<Aluno>();
		try {
			conn = getConnection();
			Statement stmt = conn.createStatement();
			String sql = "SELECT matricula, nome FROM aluno";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Aluno aluno = new Aluno();
				String nome = rs.getString("nome");
				String matricula = rs.getString("matricula");
				aluno.setMatricula(matricula);
				aluno.setNome(nome);
				alunos.add(aluno);
			}
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		
		return alunos;
	}
	
	public boolean inserir(Aluno aluno) throws EntidadeJaCadastradaException{
		boolean resultado = false;
		
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			
			String sql = "INSERT INTO aluno(matricula, data_matricula, situacao, profissao, nome, identidade, cpf, estado_civil,"
					+ "sexo, data_nascimento, email, telefone, endereco, bairro, cidade, estado, cep) "
					+ "VALUES ('" + aluno.getMatricula() + "', '" + aluno.getData_matricula() +
					"', '" + aluno.getSituacao() + "', '" + aluno.getProfissao() + "', '" + aluno.getNome() + "', '" +
					aluno.getIdentidade() + "', '" + aluno.getCpf() + "', '" + aluno.getEstado_civil() + "', '" +
					aluno.getSexo() + "', '" + aluno.getData_nascimento() + "', '" + aluno.getEmail() + "', '" +
					aluno.getTelefone() + "', '" + aluno.getEndereco() + "', '" + aluno.getBairro() + "', '" +
					aluno.getCidade() + "', '" + aluno.getEstado() + "', '" + aluno.getCep() + "');";
			
			int linhas = stmt.executeUpdate(sql);
			if(linhas != 0){
				resultado = true;
			}
			close();
		}catch (ClassNotFoundException e) {
			throw new EntidadeJaCadastradaException("Aluno já Cadastrado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public boolean atualizar(Aluno aluno){
		boolean resultado = false;
		
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			int id = 0;
			
			String nome = aluno.getNome();
			String sql = "SELECT id FROM aluno WHERE nome LIKE '" + nome + "';";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				id = rs.getInt("id");
			}
						
			sql = "UPDATE aluno SET nome = '" + aluno.getNome() + "', matricula = '"
					+ aluno.getMatricula() + "', data_matricula = '" + aluno.getData_matricula() + "', "
					+ "situacao = '" +  aluno.getSituacao() + "', profissao = '" + aluno.getProfissao() + "', "
					+ "identidade = '" + aluno.getIdentidade() +"', "
					+ "cpf = '" + aluno.getCpf() + "', estado_civil = '" + aluno.getEstado_civil() + "', "
					+ "sexo = '" + aluno.getSexo() + "', data_nascimento = '" + aluno.getData_nascimento() + "', "
					+ "email = '" + aluno.getEmail() + "', telefone = '" + aluno.getTelefone() + "', "
					+ "endereco = '" + aluno.getEndereco() + "', bairro = '" + aluno.getBairro() + "', "
					+ "cidade = '" + aluno.getCidade() + "', estado = '" + aluno.getEstado() + "', cep = '"
					+ aluno.getCep()+ "' WHERE id LIKE " + id + ";";
			
			int linhas = stmt.executeUpdate(sql);
			if(linhas != 0){
				resultado = true;
			}
			close();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public boolean deletar(Aluno aluno){
		boolean resultado = false;
		int id = 0;
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			
			String nome = aluno.getNome();
			String sql = "SELECT id FROM aluno WHERE nome LIKE '" + nome + "';";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				id = rs.getInt("id");
			}
			
			sql = "DELETE FROM cursa WHERE aluno_id LIKE " + id;
			int linhas = stmt.executeUpdate(sql);
			if(linhas != 0){
				sql = "DELETE FROM aluno WHERE id LIKE " + id;
				
				linhas = stmt.executeUpdate(sql);
				if(linhas != 0){
					resultado = true;
				}
			}
			
			close();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	public boolean relatorio(Aluno aluno) throws RelatorioException{
		try{
			
			BufferedWriter arquivo = new BufferedWriter(new FileWriter("relatorios\\relatorioAluno.csv", true));
			
			conn = getConnection();
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM aluno WHERE nome LIKE '" + aluno.getNome() + "';";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String matricula = rs.getString("matricula");
				String name = rs.getString("nome");
				String profissao = rs.getString("profissao");
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
				String data_matricula = rs.getString("data_matricula");
				String situacao = rs.getString("situacao");
				arquivo.append(matricula);
				arquivo.append(',');
				arquivo.append(name);
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
				arquivo.append(data_matricula);
				arquivo.append(',');
				arquivo.append(situacao);
				arquivo.append("\n");
			}
			close();
			
			arquivo.flush();
	        arquivo.close();
	        
	        return true;
			
		}catch(IOException e){
			throw new RelatorioException("Erro na geração do Relatório");
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean relatorio() throws RelatorioException {
		try{
			
			FileWriter arquivo = new FileWriter("relatorios\\RelatorioAluno.csv");
			arquivo.append("Relatório de Alunos\n");
			
			conn = getConnection();
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM aluno";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String matricula = rs.getString("matricula");
				String name = rs.getString("nome");
				String profissao = rs.getString("profissao");
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
				String data_matricula = rs.getString("data_matricula");
				String situacao = rs.getString("situacao");
				arquivo.append(matricula);
				arquivo.append(',');
				arquivo.append(name);
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
				arquivo.append(data_matricula);
				arquivo.append(',');
				arquivo.append(situacao);
				arquivo.append("\n");
			}
			close();
			
			arquivo.flush();
	        arquivo.close();
	        
	        return true;
			
		}catch(IOException e){
			throw new RelatorioException("Erro na geração do Relatório");
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Aluno buscar(String sql) throws EntidadeNaoEncontradaException {
		Aluno aluno = new Aluno();
		try {
			conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String matricula = rs.getString("matricula");
				String situacao = rs.getString("situacao");
				String profissao = rs.getString("profissao");
				String data_matricula = rs.getString("data_matricula");
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
				
				aluno.setMatricula(matricula);
				aluno.setSituacao(situacao);
				aluno.setProfissao(profissao);
				aluno.setData_matricula(data_matricula);
				aluno.setNome(nome);
				aluno.setIdentidade(identidade);
				aluno.setCpf(cpf);
				aluno.setEstado_civil(estado_civil);
				aluno.setSexo(sexo);
				aluno.setData_nascimento(data_nascimento);
				aluno.setEmail(email);
				aluno.setTelefone(telefone);
				aluno.setEndereco(endereco);
				aluno.setBairro(bairro);
				aluno.setCidade(cidade);
				aluno.setEstado(estado);
				aluno.setCep(cep);

			}
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			throw new EntidadeNaoEncontradaException("Aluno não encontrado");
		}
		return aluno;
	}
}
