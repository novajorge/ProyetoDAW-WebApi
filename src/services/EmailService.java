package services;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailService {
	private String host = "";
	private int port = 0;
	private String username = "";
	private String password = "";
    // Put recipient’s address
    String to = "test@example.com";

    // Put sender’s address
    String from = "from@example.com";

	public EmailService(String host, int port, String username, String password) {

		this.host = host;
		this.port = port;
		this.username = username;
		this.password = password;
		sendMail();
	}

	private void sendMail() {

		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.port", port);
		prop.put("mail.smtp.ssl.trust", host);

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

	    try {
	        // Create a default MimeMessage object.
	        Message message = new MimeMessage(session);
	     
	        // Set From: header field 
	        message.setFrom(new InternetAddress(from));
	     
	        // Set To: header field
	        message.setRecipients(Message.RecipientType.TO,
	                   InternetAddress.parse(to));
	     
	        // Set Subject: header field
	        message.setSubject("Recuperar mi contraseña");
	     
	        // Put the content of your message
            //Set key values
            Map<String, String> input = new HashMap<String, String>();
               input.put("{CODIGO}", "648279");
               input.put("{EMAIL}", "test@email.com");
               input.put("{URLRESETPASSWORD}", "dsadsasad");
               
	        String htmlText = readEmailFromHtml("WebContent/html/emailTemplates/forgotPass.html",input);
	        message.setContent(htmlText, "text/html");

	        // Send message
	        Transport.send(message);

	        System.out.println("Sent message successfully....");

	          } catch (MessagingException e) {
	             throw new RuntimeException(e);
	          }
	}
	//Method to replace the values for keys
	protected String readEmailFromHtml(String filePath, Map<String, String> input)
	{
	    String msg = readContentFromFile(filePath);
	    try
	    {
	    Set<Entry<String, String>> entries = input.entrySet();
	    for(Map.Entry<String, String> entry : entries) {
	        msg = msg.replace(entry.getKey().trim(), entry.getValue().trim());
	    }
	    }
	    catch(Exception exception)
	    {
	        exception.printStackTrace();
	    }
	    return msg;
	}
	//Method to read HTML file as a String 
	private String readContentFromFile(String fileName)
	{
	    StringBuffer contents = new StringBuffer();
	    
	    try {
	      //use buffering, reading one line at a time
	      BufferedReader reader =  new BufferedReader(new FileReader(fileName));
	      try {
	        String line = null; 
	        while (( line = reader.readLine()) != null){
	          contents.append(line);
	          contents.append(System.getProperty("line.separator"));
	        }
	      }
	      finally {
	          reader.close();
	      }
	    }
	    catch (IOException ex){
	      ex.printStackTrace();
	    }
	    return contents.toString();
	}

	public static void main(String ... args) {
		new EmailService("smtp.mailtrap.io", 2525, "64bde6b0e2b215", "c4ca1e00bd9efa");
	}

}
