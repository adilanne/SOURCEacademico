package br.unipe.cc.mlpIII.academico.persistence;

public class EntidadeNaoEncontradaException extends ClassNotFoundException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4463938223389669058L;

	EntidadeNaoEncontradaException(String message){
		super(message);
	}

}
