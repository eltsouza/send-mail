package br.com.classes.send.email;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class AppTest {
	
	private String userName = "?"; //informar seu email remetente
	private String senha= "?"; // informar sua senha
	
	//Anotação para executar o código
	@org.junit.Test
	public void testeEmail() {
		
		try {
			//Verificar as configurações de SMTP do email utilizado
			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true");//autorização
			properties.put("mail.smtp.starttls", "true");//autenticação
			properties.put("mail.smtp.host", "smtp.gmail.com");//servidor de email
			properties.put("mail.smtp.port", "465");//porta do servidor de email
			properties.put("mail.smtp.socketFactory.port", "465");//Especifica a porta acessada pelo socket
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");//Classe socket de conexão ao SMTP
		
			Session session = Session.getInstance(properties, new Authenticator() {
				
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userName, senha);
				}
			});
			
			Address[] toUser = InternetAddress.parse("souza.elton28@gmail.com,souzaconsuloria@gmail.com"); // lista de emails destinatários
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userName)); /*Quem está enviano*/
			message.setRecipients(Message.RecipientType.TO, toUser);/*Email de destino*/
			message.setSubject("Chegou e-mail enviado com java");/*Assunto do e-mail*/
			message.setText("Olá programador, vc acaba de receber um e-mail enviado com Java do curso Formação Java Web");
			
			
			Transport.send(message);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
			
		
		
	}
	
	
	
}
