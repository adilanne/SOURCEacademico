package br.unipe.cc.mlpIII.academico.persistence;

import br.unipe.cc.mlpIII.academico.model.Aluno;

public interface ICursa {
	
	public boolean inserir(Aluno aluno, String disciplina);

}
