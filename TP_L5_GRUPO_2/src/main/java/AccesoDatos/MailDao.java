package AccesoDatos;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import Dominio.Prestamo;

public class MailDao {

	
	@Autowired
	private PrestamoDao pDao;

    
    public void enviarCorreo(int idPrestamo, String cambio){
    	
    	final String username = "BancoUTN.noreply@gmail.com";
        final String password = "Adm1nBanc4#";
        Prestamo p = pDao.buscarPrestamo(idPrestamo);

        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(p.getUsuario().getEmail()));
			message.setSubject("Resolución sobre solicitud prestamo nº"+idPrestamo);
			message.setText("Estimado/a "+p.getUsuario().getNombre()+" "+p.getUsuario().getApellido()+", le comunicamos que ya se encuentra disponible la resolución sobre el prestamo que solicitó el día "+ p.getFechaSolicitud().toString() +". El mismo fue "+cambio+". Saludos");

            Transport.send(message);


        } catch (MessagingException me){
			me.printStackTrace();
			return;
        }
    }
	
	
	
	
	/*
	private void inicializar() {
		
		
		//properties.put("mail.smtp.host", "mail.gmail.com");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.starttls.enable", "true");
		//properties.put("mail.smtp.port",25);
		properties.put("mail.smtp.port",587);
		properties.put("mail.smtp.mail.sender","BancoUTN.noreply@gmail.com");
		properties.put("mail.smtp.user", "usuario");
		properties.put("mail.smtp.auth", "true");
 
		session = Session.getDefaultInstance(properties);
	}
 
	public void enviarCorreo(int idPrestamo, String cambio){
 
		inicializar();
		try{
			Prestamo p = pDao.buscarPrestamo(idPrestamo);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress((String)properties.get("mail.smtp.mail.sender")));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(p.getUsuario().getEmail()));
			message.setSubject("Resolución sobre solicitud prestamo nº"+idPrestamo);
			message.setText("Estimado/a "+p.getUsuario().getNombre()+" "+p.getUsuario().getApellido()+", le comunicamos que ya se encuentra disponible la resolución sobre el prestamo que solicitó. El mismo fue "+cambio+". Saludos");
			Transport t = session.getTransport("smtp");
			t.connect((String)properties.get("mail.smtp.user"), "Adm1nBanc4#");
			t.sendMessage(message, message.getAllRecipients());
			t.close();
		}catch (MessagingException me){
			me.printStackTrace();
			return;
		}
			
}
*/
	
	
}
