package br.unipe.cc.mlpIII.academico.persistence;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.unipe.cc.mlpIII.academico.model.Professor;

public class RepositorioProfessorTest {

	List<Professor> professores;
	RepositorioProfessor rep = new RepositorioProfessor();
	Professor professor = new Professor();
	
	@Before
	public void setUp() throws Exception {
		professores = new ArrayList<>();
		professor.setNome("Teste");
		professor.setMatricula("teste");
	}

	@After
	public void tearDown() throws Exception {
		professores.clear();
		professor.setNome(null);
		professor.setMatricula(null);
		rep.deletar(professor);
	}


	@Test
	public void testInserir() {
		Professor professor1 = new Professor();
		professor1.setNome("Teste1");
		professor1.setMatricula("teste1");
		try {
			rep.inserir(professor1);
		} catch (EntidadeJaCadastradaException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testBuscar() {
		try {
			rep.buscar("SELECT * FROM professor WHERE nome LIKE 'Teste';");
		} catch (EntidadeNaoEncontradaException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testListar() {
		professores = rep.listar();
	}

	@Test
	public void testAtualizar() {
		professor.setNome("Teste2");
		professor.setMatricula("teste2");
		rep.atualizar(professor);
	}

	@Test
	public void testDeletar() {
		rep.deletar(professor);
	}

	@Test
	public void testRelatorio() {
		try {
			rep.relatorio();
		} catch (RelatorioException e) {
			e.printStackTrace();
		}
	}

}
