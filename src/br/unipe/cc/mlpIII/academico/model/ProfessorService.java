package br.unipe.cc.mlpIII.academico.model;

import java.util.List;

import javax.swing.JOptionPane;

import br.unipe.cc.mlpIII.academico.persistence.EntidadeJaCadastradaException;
import br.unipe.cc.mlpIII.academico.persistence.EntidadeNaoEncontradaException;
import br.unipe.cc.mlpIII.academico.persistence.IProfessor;
import br.unipe.cc.mlpIII.academico.persistence.RelatorioException;
import br.unipe.cc.mlpIII.academico.persistence.RepositorioProfessor;

public class ProfessorService {
	private IProfessor repositorioProfessor = new RepositorioProfessor();
	
	public boolean cadastrar(Professor professor) {
		try {
			return repositorioProfessor.inserir(professor);
		} catch (EntidadeJaCadastradaException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}

	public int getDisciplinaId(String disciplina){
		return repositorioProfessor.getDisciplinaId(disciplina);
	}
	
	public boolean atualizar(Professor professor) {
		return repositorioProfessor.atualizar(professor);
	}

	public boolean deletar(Professor professor) {
		return repositorioProfessor.deletar(professor);
	}
	
	public List<Professor> listar() {
		return repositorioProfessor.listar();
	}
	
	public Professor buscar(String sql){
		try {
			return repositorioProfessor.buscar(sql);
		} catch (EntidadeNaoEncontradaException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
	}
	
	public boolean relatorio(Professor professor){
		try {
			return repositorioProfessor.relatorio(professor);
		} catch (RelatorioException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}
	
	public boolean relatorio(){
		try {
			return repositorioProfessor.relatorio();
		} catch (RelatorioException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}

}
