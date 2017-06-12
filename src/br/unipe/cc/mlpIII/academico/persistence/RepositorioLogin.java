package br.unipe.cc.mlpIII.academico.persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import br.unipe.cc.mlpIII.academico.model.Login;

public class RepositorioLogin implements ILogin{
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	public Connection getConnection() throws ClassNotFoundException, FileNotFoundException, IOException{
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("config/data.properties"));
			
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
			conn.close();
			stmt.close();
			rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean validation(Login login){
		String sql, user = null, password = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			sql = "SELECT login FROM usuario";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				user = rs.getString("login");
			}			
			
			sql = "SELECT senha FROM usuario";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				password = rs.getString("senha");
			}
			
			close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if((login.getUser()).equals(user) && (login.getPassword()).equals(password)){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean validateCpf(String cpf) {
		String CPF = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			String sql = "SELECT cpf FROM usuario";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				CPF = rs.getString("cpf");
			}			
			
			close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(CPF.equals(cpf)){
			return true;
		}else{
			return false;
		}
	}

}
