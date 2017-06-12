package br.unipe.cc.mlpIII.academico.persistence;

public class EntidadeJaCadastradaException extends ClassNotFoundException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3437289739953358595L;

	EntidadeJaCadastradaException(String message){
		super(message);
	}

}
