package br.unipe.cc.mlpIII.academico.persistence;

import java.util.List;

import br.unipe.cc.mlpIII.academico.model.Professor;

public interface IProfessor {
	public boolean inserir(Professor professor) throws EntidadeJaCadastradaException;
	public List<Professor> listar();
	public boolean atualizar(Professor professor);
	public boolean deletar(Professor professor);
	public boolean relatorio() throws RelatorioException;
	public boolean relatorio(Professor professor) throws RelatorioException;
	public Professor buscar(String sql) throws EntidadeNaoEncontradaException;
	public int getDisciplinaId(String disciplina);
}
