package br.unipe.cc.mlpIII.academico.persistence;

import br.unipe.cc.mlpIII.academico.model.Login;

public interface ILogin {
	public boolean validation(Login login);
	public boolean validateCpf(String cpf);
}
