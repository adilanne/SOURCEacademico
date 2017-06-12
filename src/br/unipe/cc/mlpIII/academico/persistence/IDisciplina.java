package br.unipe.cc.mlpIII.academico.persistence;

import java.util.List;

import br.unipe.cc.mlpIII.academico.model.Disciplina;

public interface IDisciplina {
	public boolean inserir(Disciplina disciplina) throws EntidadeJaCadastradaException;
	public List<Disciplina> listar();
	public Disciplina buscar(String sql) throws EntidadeNaoEncontradaException;
	public boolean atualizar(Disciplina disciplina);
	public boolean deletar(Disciplina disciplina);
	public boolean relatorio() throws RelatorioException;
	public boolean relatorio(Disciplina disciplina) throws RelatorioException;

}
