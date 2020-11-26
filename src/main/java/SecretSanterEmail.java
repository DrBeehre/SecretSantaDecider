import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class SecretSanterEmail {

    private String username = "";
    private String password = "";
    private int port = 587;
    private String host = "smtp.gmail.com";

    private Session session = null;
    private MimeMessage message = null;

    private String _from = "";

    public SecretSanterEmail(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void createEmail(String to,
                                   String from,
                                   String subject,
                                   String bodyText) {

        _from = from;

        Properties properties = System.getProperties();

        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.user", from);
        properties.put("mail.smtp.password", password);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        session = Session.getDefaultInstance(properties);
        MimeMessage email = new MimeMessage(session);

        try {
            email.setFrom(new InternetAddress(from));
            email.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            email.setSubject(subject);
            email.setText(bodyText);
            message = email;
        }catch (MessagingException e){
            e.printStackTrace();
        }
    }

    public void sendEmail() {

        try {
            if (message == null) {
                throw new Exception("message equals null, make sure you call 'createEmail' before calling 'sendEmail'.");
            }

            Transport transport = session.getTransport("smtp");
            transport.connect(host, _from, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        }catch (Exception e){
            e.printStackTrace();
        }


//        Properties properties = new Properties();
//        properties.put("mail.smtp.auth", true);
//        properties.put("mail.smtp.starttls.enable", "true");
//        properties.put("mail.smtp.host", host);
//        properties.put("mail.smtp.port", port);
//        properties.put("mail.smtp.ssl.trust",host);

//        Session session = Session.getInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
//        });
//
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress("from@gmail.com"));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("wardbeehre@gmail.com"));
//            message.setSubject("Mail Subject - Wards Test");
//
//            String msg = "This is a test to see if I can send an email using java.";
//
//            MimeBodyPart mimeBodyPart = new MimeBodyPart();
//            mimeBodyPart.setContent(msg, "text/html");
//
//            Multipart multipart = new MimeMultipart();
//            multipart.addBodyPart(mimeBodyPart);
//
//            message.setContent(multipart);
//
//            Transport.send(message);
//        }catch (MessagingException e){
//            e.printStackTrace();
//        }
    }
}
