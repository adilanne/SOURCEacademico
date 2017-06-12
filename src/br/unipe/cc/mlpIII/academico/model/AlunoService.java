package br.unipe.cc.mlpIII.academico.model;

import java.util.List;

import javax.swing.JOptionPane;

import br.unipe.cc.mlpIII.academico.persistence.EntidadeJaCadastradaException;
import br.unipe.cc.mlpIII.academico.persistence.EntidadeNaoEncontradaException;
import br.unipe.cc.mlpIII.academico.persistence.IAluno;
import br.unipe.cc.mlpIII.academico.persistence.ICursa;
import br.unipe.cc.mlpIII.academico.persistence.RelatorioException;
import br.unipe.cc.mlpIII.academico.persistence.RepositorioAluno;
import br.unipe.cc.mlpIII.academico.persistence.RepositorioCursa;

/**
 * Class that operates the CRUD functions for Aluno
 * @author Adilanne
 *
 */

public class AlunoService {
	private IAluno repositorioAluno = new RepositorioAluno();
	private ICursa repositorioCursa = new RepositorioCursa();
	
	public boolean cadastrar(Aluno aluno) {
		try {
			return repositorioAluno.inserir(aluno);
		} catch (EntidadeJaCadastradaException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}

	public boolean atualizar(Aluno aluno) {
		return repositorioAluno.atualizar(aluno);
	}

	public boolean deletar(Aluno aluno) {
		return repositorioAluno.deletar(aluno);
	}
	
	public List<Aluno> listar() {
		return repositorioAluno.listar();
	}
	
	public boolean relatorio(Aluno aluno){
		try {
			return repositorioAluno.relatorio(aluno);
		} catch (RelatorioException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}
	
	public boolean relatorio(){
		try {
			return repositorioAluno.relatorio();
		} catch (RelatorioException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}
	
	public Aluno buscar(String sql){
		try {
			return repositorioAluno.buscar(sql);
		} catch (EntidadeNaoEncontradaException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
	}
	
	public boolean inserir(Aluno aluno, String disciplina){
		return repositorioCursa.inserir(aluno, disciplina);
	}
}
