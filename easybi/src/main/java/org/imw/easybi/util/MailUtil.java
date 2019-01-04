package org.imw.easybi.util;

import org.imw.easybi.pojo.User;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailUtil {

    public static void send_mail(User user) {
        Session session = getSession();
        MimeMessage message = new MimeMessage(session);
        try {
            message.setSubject("这是一封激活账号的邮件，复制链接到地址栏来激活他");
            message.setSentDate(new Date());
            message.setFrom(new InternetAddress("qdlixiao6688@126.com"));
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(user.getUsername()));
            message.setContent("<a  target='_BLANK' href=''>"+GenerateLinkUtils.generateActivateLink(user)+"</a>","text/html;charset=utf-8");
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static Session getSession(){
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.host", "smtp.163.com");
        properties.setProperty("mail.smtp.port", "25");
        properties.setProperty("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("qdlixiao6688@126.com","123456");
            }
        });
        return session;
    }


}
