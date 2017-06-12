package br.unipe.cc.mlpIII.academico.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.unipe.cc.mlpIII.academico.model.Aluno;

public class RepositorioCursa implements ICursa{
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

	@Override
	public boolean inserir(Aluno aluno, String disciplina){
		boolean resultado = false;
		
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			
			
			
			String sql = "SELECT id FROM aluno WHERE nome LIKE '" + aluno.getNome() + "';";
			int idAluno = 0;
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				idAluno = rs.getInt("id");
			}
			
			sql = "SELECT id FROM disciplina WHERE nome LIKE '" + disciplina + "';";
			int idDisciplina = 0;
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				idDisciplina = rs.getInt("id");
			}
			
			sql = "SELECT id FROM professor WHERE disciplina_id LIKE '" + idDisciplina + "';";
			int idProfessor = 0;
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				idProfessor = rs.getInt("id");
			}
			
			
			sql = "INSERT INTO cursa(aluno_id, professor_id, disciplina_id) VALUES ('" + idAluno + "', '" + idProfessor + "', '" + idDisciplina +"');";
			
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

}
