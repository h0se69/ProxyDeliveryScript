/*
 * https://twitter.com/h0se_69
 * Please leave me feedback or suggestions :)
 */

package MailSetup;

import java.util.*;
import javax.mail.*;    
import javax.mail.internet.*;  

public class GmailSetup 
{
	public static void send(String recipient, String from, String password, String subject, String body_Message)
	{  
   
        Properties properties = new Properties();    
        properties.put("mail.smtp.host", "smtp.gmail.com");    
        properties.put("mail.smtp.socketFactory.port", "465");    
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");    
        properties.put("mail.smtp.auth", "true");    
        properties.put("mail.smtp.port", "465");   
        
        //get the session  
        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() 
        {    
         protected PasswordAuthentication getPasswordAuthentication() 
         	{ 
        	 	return new PasswordAuthentication(from,password); 
         	} 
         }); 
        
        //create email with contents
        try {    
         MimeMessage message = new MimeMessage(session);    
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(recipient));    
         message.setSubject(subject);    
         message.setText(body_Message); 
         
         //send email
         Transport.send(message);
         //Can add a sout line stating it was sent.
         
        } catch (MessagingException e) { String error = ("Error Logging in | Please enable this & try again | (https://myaccount.google.com/u/1/lesssecureapps)"); throw new RuntimeException(error);}   
	}
           
}
