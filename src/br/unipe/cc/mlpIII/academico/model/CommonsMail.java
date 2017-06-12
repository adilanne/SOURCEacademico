package br.unipe.cc.mlpIII.academico.model;

import javax.swing.JOptionPane;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class CommonsMail {
	
	public boolean emailComAnexo(String emailAdress, String fileName){
		EmailAttachment anexo = new EmailAttachment();
		MultiPartEmail email = new MultiPartEmail();
		boolean retorno = false;
		try {
			anexo.setPath("relatorios\\" + fileName + ".csv");
			anexo.setDisposition(EmailAttachment.ATTACHMENT);
			anexo.setDescription("Arquivo");
			anexo.setName("Relat�rio");
			
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("email", "senha"));//email and password to send
			email.setSSLOnConnect(true);
			try{
				email.addTo(emailAdress); 
			}catch(EmailException e){
				throw new EmailInvalidoException("Email Inv�lido");
			}
			
			email.setFrom("email", "SOURCE Sistema Acad�mico");//set the same mail above
			email.setSubject("Relat�rio");
			email.setMsg("Relat�rio gerado por SOURCE - Sistema Acad�mico.");
			email.attach(anexo);
			email.send();
			retorno = true;
			return retorno;

		} catch (EmailException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return retorno;
		} 
	}
}
