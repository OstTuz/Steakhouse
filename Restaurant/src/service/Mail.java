package service;

import model.Order;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class Mail {
    public static void sendMail(Order order) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.auth", "true");
            props.put("mail.debug", "false");
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            Session session = Session.getInstance(props, new EmailAuth());
            Message msg = new MimeMessage(session);
            InternetAddress from = new InternetAddress("ostap.tuz.kn.2017@lpnu.ua", "DSNS");
            msg.setFrom(from);
            InternetAddress toAddress = new InternetAddress("ostap.tuz.kn.2017@lpnu.ua");
            msg.setRecipient(Message.RecipientType.TO, toAddress);
            msg.setSubject("Reservation notification");

            String specialOccasion = (order.isSpecialOccasion()) ? "Yes" : "No";
            String separateRoom = (order.isSeparateRoom()) ? "Yes" : "No";
            msg.setContent("<html>\n" +
                    "<body>\n" +
                    "    <div style=\"width: 400px; background-color: whitesmoke; border: 1px solid black; border-radius: 5px;\">\n" +
                    "        <h3 style=\"text-align: center\">Reservation notification</h3>\n" +
                    "        <div style=\"margin-left: 20px\">\n" +
                    "            <p>Name: " + order.getUser().getName() + "</p>\n" +
                    "            <p>Surname: " + order.getUser().getSurname() + "</p>\n" +
                    "            <p>Email: " + order.getUser().getEmail() + "</p>\n" +
                    "            <p>Phone: " + order.getUser().getPhone() + "</p>\n" +
                    "            <p>Date of reservation: " + order.getDate() + "</p>\n" +
                    "            <p>Amount of people: " + order.getPersonAmount() + "</p>\n" +
                    "            <p>Special occasion: " + specialOccasion + "</p>\n" +
                    "            <p>Separate room: " + separateRoom + "</p>\n" +
                    "            <p>Email: " + order.getHall().name() + "</p>\n" +
                    "            <p>Addition advise: " + order.getAdditionalAdvise() + "</p>\n" +
                    "            <p>-------------------------------------------------</p>\n" +
                    "            <p>Price: " + order.calculatePrice() + "$</p>\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "</body>\n" +
                    "</html>", "text/html");
            Transport.send(msg);
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }

    static class EmailAuth extends Authenticator {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("ostap.tuz.kn.2017@lpnu.ua", "29.10.1999");
        }
    }
}