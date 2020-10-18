package Model.AccountLogic;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.HashMap;
import java.util.Properties;

public class SendMail {
    Properties properties;
    Session session;
    private static final String senderEmail = "localiapplication@gamil.com";

    public SendMail() {
        setProperties();
        setSender();
    }

    HashMap<String, String> messageChooser = new HashMap<>() {{
        put("ForgetPassword", "Hello!\n\nWe all forget our password from time to time and that's fine!\nYour password is: ");
        put("SignUp", "Hi!\n\n Welcome to Locali, a place where you can do all of your budgeting and economics locally on " +
                "your computer. We hope you enjoy the application and if you have any questions you can send our support " +
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
     * sends an email to the user
     *
     * @param message the constructed message
     */
    private void sendMessage(Message message) throws MessagingException {
    }

    /**
     * creates an email with text and header
     *
     * @param to              the recipient of the email
     * @param passwordMessage the password that they've forgotten
     */
    public void sendEmail(String to, String passwordMessage, String typeOfMessage) {
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
            message.setSubject("Locali Team");
            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();
            // Now set the actual messages
            messageBodyPart.setText(messageChooser.get(typeOfMessage));
            // Create a multipar message
            Multipart multipart = new MimeMultipart();
            // Set text message part1
            multipart.addBodyPart(messageBodyPart);

            if (typeOfMessage.equals("ForgetPassword")) {
                messageBodyPart = new MimeBodyPart();
                messageBodyPart.setText(passwordMessage);
                multipart.addBodyPart(messageBodyPart);
            }

            messageBodyPart = new MimeBodyPart();
            // Set text message part2
            messageBodyPart.setText("\n\nBest Regards\nThe Locali Team");
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart);
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}



