package br.unipe.cc.mlpIII.academico.facade;

import java.util.List;

import br.unipe.cc.mlpIII.academico.model.Aluno;
import br.unipe.cc.mlpIII.academico.model.AlunoService;
import br.unipe.cc.mlpIII.academico.model.CommonsMail;
import br.unipe.cc.mlpIII.academico.model.Disciplina;
import br.unipe.cc.mlpIII.academico.model.DisciplinaService;
import br.unipe.cc.mlpIII.academico.model.Login;
import br.unipe.cc.mlpIII.academico.model.LoginService;
import br.unipe.cc.mlpIII.academico.model.Professor;
import br.unipe.cc.mlpIII.academico.model.ProfessorService;

/**
 * Class that works at the Facade layer, doing the communication between user interface and model.
 * This class contains all methods that can be used by user interface.
 * @author Adilanne
 *
 */

public class Academico {
	
	private LoginService loginService;
	private AlunoService alunoService;
	private DisciplinaService disciplinaService;
	private ProfessorService professorService;
	private CommonsMail commonsMail;
	
	
	public Academico(){
		alunoService = new AlunoService();
		loginService = new LoginService();
		disciplinaService = new DisciplinaService();
		professorService = new ProfessorService();
		commonsMail = new CommonsMail();
	}
	
	public boolean relatorioProfessor(Professor professor){
		return professorService.relatorio(professor);
	}
	
	public boolean relatorioProfessor(){
		return professorService.relatorio();
	}
	
	public int getDisciplinaId(String disciplina){
		return professorService.getDisciplinaId(disciplina);
	}
	
	public boolean salvarProfessor(Professor professor){
		return professorService.cadastrar(professor);
	}
	
	public boolean atualizarProfessor(Professor professor){
		return professorService.atualizar(professor);
	}
	
	public boolean deletarProfessor(Professor professor){
		return professorService.deletar(professor);
	}
	
	public List<Professor> listarProfessor(){
		return professorService.listar();
	}
	
	public Professor buscarProfessor(String sql){
		return professorService.buscar(sql);
	}
	
	public boolean relatorioDisciplina(Disciplina disciplina){
		return disciplinaService.relatorio(disciplina);
	}
	
	public boolean relatorioDisciplina(){
		return disciplinaService.relatorio();
	}
	
	public boolean salvarDisciplina(Disciplina disciplina){
		return disciplinaService.cadastrar(disciplina);
	}
	
	public Disciplina buscarDisciplina(String sql){
		return disciplinaService.buscar(sql);
	}
	
	public boolean atualizarDisciplina(Disciplina disciplina){
		return disciplinaService.atualizar(disciplina);
	}
	
	public boolean deletarDisciplina(Disciplina disciplina){
		return disciplinaService.deletar(disciplina);
	}
	
	public List<Disciplina> listarDisciplina(){
		return disciplinaService.listar();
	}
	
	public boolean login(Login login){
		return loginService.validation(login);
	}
	
	public boolean cpf(String cpf){
		return loginService.validateCpf(cpf);
	}
	
	public boolean relatorioAluno(Aluno aluno){
		return alunoService.relatorio(aluno);
	}
	
	public boolean relatorioAluno(){
		return alunoService.relatorio();
	}
	
	public boolean salvarAluno(Aluno aluno){
		return alunoService.cadastrar(aluno);
	}
	
	public boolean atualizarAluno(Aluno aluno){
		return alunoService.atualizar(aluno);
	}
	
	public boolean deletarAluno(Aluno aluno){
		return alunoService.deletar(aluno);
	}
	
	public List<Aluno> listarAlunos(){
		return alunoService.listar();
	}
	
	public Aluno buscarAluno(String sql){
		return alunoService.buscar(sql);
	}
	
	public boolean cursa(Aluno aluno, String disciplina){
		return alunoService.inserir(aluno, disciplina);
	}
	
	public boolean enviarEmail(String emailAdress, String fileName){
		return commonsMail.emailComAnexo(emailAdress, fileName);
	}

}
