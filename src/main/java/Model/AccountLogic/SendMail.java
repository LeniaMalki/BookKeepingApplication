package Model.AccountLogic;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class SendMail {
    Properties properties;
    Session session;
    private static final String senderEmail = "localiapplication@gamil.com";

    public SendMail() {
        setProperties();
        setSender();
    }

    /**
     * sets the sender of the email
     */
    private void setSender() {
        session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("localiapplication@gmail.com", "Locali.123");
            }
        });
    }

    /**
     * Sets properties of the mail Server
     */
    private void setProperties() {
        properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
    }

    /**
     * creates an email with text and header
     *
     * @param to the recipient of the email
     * @param passwordMessage the password that they've forgotten
     */
    public void sendEmail(String to, String passwordMessage) {
        // Used to debug SMTP issues
        session.setDebug(true);
        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(senderEmail));
            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            // Set Subject: header field
            message.setSubject("Locali Application Forgot Password");
            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();
            // Now set the actual message
            messageBodyPart.setText("Hello!" + "\n" + "\n" + "We all forget our password from time to time and that's fine!"
                    + "\n" + "Your password is: " + passwordMessage + "\n" + "\n" + "Best Regards" + "\n" + "The Locali Team");
            // Create a multipar message
            Multipart multipart = new MimeMultipart();
            // Set text message part
            multipart.addBodyPart(messageBodyPart);
            // Send the complete message parts
            message.setContent(multipart);
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * sends an email to the user
     *
     * @param message the constructed message
     */
    private void sendMessage(Message message) throws MessagingException {
    }
}



