package br.unipe.cc.mlpIII.academico.persistence;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.unipe.cc.mlpIII.academico.model.Disciplina;

public class RepositorioDisciplinaTest {
	List<Disciplina> disciplinas;
	RepositorioDisciplina rep = new RepositorioDisciplina();
	Disciplina disciplina = new Disciplina();

	@Before
	public void setUp() throws Exception {
		disciplinas = new ArrayList<>();
		disciplina.setNome("Teste");
		disciplina.setSemestre("teste");
	}

	@After
	public void tearDown() throws Exception {
		disciplinas.clear();
		disciplina.setNome(null);
		disciplina.setSemestre(null);
		rep.deletar(disciplina);
	}

	@Test
	public void testInserir() {
		Disciplina disciplina1 = new Disciplina();
		disciplina1.setNome("teste1");
		disciplina1.setSemestre("teste1");
		try {
			rep.inserir(disciplina1);
		} catch (EntidadeJaCadastradaException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testBuscar() {
		try {
			rep.buscar("SELECT * FROM disciplina WHERE nome LIKE 'teste';");
		} catch (EntidadeNaoEncontradaException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testListar() {
		disciplinas = rep.listar();
	}

	@Test
	public void testAtualizar() {
		disciplina.setNome("teste2");
		disciplina.setSemestre("teste2");
		rep.atualizar(disciplina);
	}

	@Test
	public void testDeletar() {
		rep.deletar(disciplina);
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
