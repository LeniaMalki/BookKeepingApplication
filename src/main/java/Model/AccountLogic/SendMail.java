package Model.AccountLogic;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
/**
 * @author : Artin Abiri
 * Responsibility: A class responsible for sending e-mail
 * Used by: AccountFacade
 * Uses: Properties, Session
 */
public class SendMail {
    Properties properties;
    Session session;
    private static final String senderEmail = "localiapplication@gamil.com";

    public SendMail() {
        setProperties();
        setSender();
    }

    Map<String, String> messageChooser = new HashMap<>() {{
        put("ForgetPassword", "Hello!\n\nWe all forget our password from time to time and that's fine!\nYour password is: ");
        put("SignUp", "Hi!\n\n Welcome to Locali, a place where you can do all of your budgeting and economics locally on " +
                "your computer. We hope you enjoy the application and if you have any questions you can send an email to our support " +
                "team an email at localiapplication@gmail.com");
    }};

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
     * @param to              the recipient of the email
     * @param passwordMessage the password that they've forgotten
     */
    public void sendEmail(final String to, final String passwordMessage, final String typeOfMessage) {
        // Used to debug SMTP issues
        session.setDebug(true);
        try {
            final StringBuilder stringBuilder= new StringBuilder();
            // Create a default MimeMessage object.
            final Message message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(senderEmail));
            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            // Set Subject: header field
            message.setSubject("Locali Team");
            // Create the message part
            final BodyPart messageBodyPart = new MimeBodyPart();
            stringBuilder.append(messageChooser.get(typeOfMessage));


            if ("ForgetPassword".equals(typeOfMessage)) {
                stringBuilder.append(passwordMessage);
            }
            stringBuilder.append("\n\nBest Regards\nThe Locali Team");
            messageBodyPart.setText(stringBuilder.toString());
            final Multipart textBody = new MimeMultipart();
            textBody.addBodyPart(messageBodyPart);
            // Send the complete message parts
            message.setContent(textBody);
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}



