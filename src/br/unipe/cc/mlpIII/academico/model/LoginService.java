package br.unipe.cc.mlpIII.academico.model;

import br.unipe.cc.mlpIII.academico.persistence.ILogin;
import br.unipe.cc.mlpIII.academico.persistence.RepositorioLogin;

public class LoginService {
	private ILogin repositorioLogin = new RepositorioLogin();
	
	public boolean validation(Login login){
		return repositorioLogin.validation(login);
	}
	
	/**
	 * Method for cpf verification, in case the admin forgot the 
	 * password.
	 * @param cpf
	 * @return boolean
	 */
	public boolean validateCpf(String cpf){
		return repositorioLogin.validateCpf(cpf);
	}

}
