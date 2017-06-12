package br.unipe.cc.mlpIII.academico.model;

import java.util.List;

import javax.swing.JOptionPane;

import br.unipe.cc.mlpIII.academico.persistence.EntidadeJaCadastradaException;
import br.unipe.cc.mlpIII.academico.persistence.EntidadeNaoEncontradaException;
import br.unipe.cc.mlpIII.academico.persistence.IDisciplina;
import br.unipe.cc.mlpIII.academico.persistence.RelatorioException;
import br.unipe.cc.mlpIII.academico.persistence.RepositorioDisciplina;

public class DisciplinaService {
	private IDisciplina repositorioDisciplina = new RepositorioDisciplina();

	
	public boolean cadastrar(Disciplina disciplina) {
		try {
			return repositorioDisciplina.inserir(disciplina);
		} catch (EntidadeJaCadastradaException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}
	
	public Disciplina buscar(String sql){
		try {
			return repositorioDisciplina.buscar(sql);
		} catch (EntidadeNaoEncontradaException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
	}

	public boolean atualizar(Disciplina disciplina) {
		return repositorioDisciplina.atualizar(disciplina);
	}

	public boolean deletar(Disciplina disciplina) {
		return repositorioDisciplina.deletar(disciplina);
	}
	
	public List<Disciplina> listar() {
		return repositorioDisciplina.listar();
	}
	
	public boolean relatorio(Disciplina disciplina){
		try {
			return repositorioDisciplina.relatorio(disciplina);
		} catch (RelatorioException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}
	
	public boolean relatorio(){
		try {
			return repositorioDisciplina.relatorio();
		} catch (RelatorioException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}
}
