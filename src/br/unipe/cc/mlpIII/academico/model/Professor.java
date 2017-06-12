package br.unipe.cc.mlpIII.academico.model;

public class Professor extends Pessoa{
	
	private String data_contratacao;
	private String titularidade;
	private int disciplina_id;
	
	
	public String getData_contratacao(){
		return data_contratacao;
	}
	public void setData_contratacao(String data_contratacao) {
		this.data_contratacao = data_contratacao;
	}
	public String getTitularidade() {
		return titularidade;
	}
	public void setTitularidade(String titularidade) {
		this.titularidade = titularidade;
	}
	public int getDisciplina_id() {
		return disciplina_id;
	}
	public void setDisciplina_id(int disciplina_id) {
		this.disciplina_id = disciplina_id;
	}
}
