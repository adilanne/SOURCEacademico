package br.unipe.cc.mlpIII.academico.persistence;

import java.util.List;

import br.unipe.cc.mlpIII.academico.model.Aluno;

/**
 * Interface for Aluno: CRUD
 * @author Adilanne
 */
public interface IAluno {
	public boolean inserir(Aluno Aluno) throws EntidadeJaCadastradaException;
	public List<Aluno> listar();
	public boolean atualizar(Aluno Aluno);
	public boolean deletar(Aluno Aluno);
	public boolean relatorio(Aluno aluno) throws RelatorioException;
	public boolean relatorio() throws RelatorioException;
	public Aluno buscar(String sql) throws EntidadeNaoEncontradaException;
}
