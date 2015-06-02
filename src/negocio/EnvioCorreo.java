package negocio;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import negocio.EmpleadoABM;

import java.util.Properties;



public class EnvioCorreo {
	
	EmpleadoABM empleado =new EmpleadoABM();
	
	public void EnviarCorreo (int idEmpleadoDestino, String mensaje) throws Exception
	{
		Session session = ConfigurandoPropiedades();
		//Envio de correo
		
		try{
		String destinatario = empleado.traerEmpleado(idEmpleadoDestino).getEmail();
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("gestion.plancarrera@gmail.com"));
		message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(destinatario));
		message.setSubject("Testing Subject");
		message.setText(mensaje);

		Transport.send(message);
		
		System.out.println("Done");
		}
		catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	protected Session ConfigurandoPropiedades()
	{
		final String username = "gestion.plancarrera@gmail.com";
		final String password = "PlanCarrera";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
		return session;
	}

}
