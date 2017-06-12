package br.unipe.cc.mlpIII.academico.persistence;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import br.unipe.cc.mlpIII.academico.model.Aluno;

public class RepositorioAlunoTest {

	List<Aluno> alunos;
	RepositorioAluno rep = new RepositorioAluno();
	Aluno aluno = new Aluno();
	
	@Before
	public void setUp() throws Exception {
		alunos = new ArrayList<>();
		aluno.setNome("Teste");
		aluno.setMatricula("teste");
	}

	@After
	public void tearDown() throws Exception {
		alunos.clear();
		aluno.setNome(null);
		aluno.setMatricula(null);
		rep.deletar(aluno);
	}

	@Test
	public void testListar() {
		alunos = rep.listar();
	}

	@Test
	public void testInserir() {
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Teste1");
		aluno1.setMatricula("teste1");
		try {
			rep.inserir(aluno1);
		} catch (EntidadeJaCadastradaException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAtualizar() {
		aluno.setNome("Teste2");
		aluno.setMatricula("teste2");
		rep.atualizar(aluno);
	}

	@Test
	public void testDeletar() {
		rep.deletar(aluno);
	}

	@Test
	public void testRelatorio() {
		try {
			rep.relatorio();
		} catch (RelatorioException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testBuscar() {
		try {
			rep.buscar("SELECT * FROM aluno WHERE nome LIKE 'Teste';");
		} catch (EntidadeNaoEncontradaException e) {
			e.printStackTrace();
		}
	}

}
