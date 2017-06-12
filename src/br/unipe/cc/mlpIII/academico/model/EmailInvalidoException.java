package br.unipe.cc.mlpIII.academico.model;

import org.apache.commons.mail.EmailException;

public class EmailInvalidoException extends EmailException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1203284864238376956L;

	EmailInvalidoException(String message){
		super(message);
	}

}
