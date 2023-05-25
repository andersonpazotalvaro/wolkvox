package co.smart.procesador.email;

import org.springframework.mail.SimpleMailMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import static javax.xml.transform.OutputKeys.ENCODING;

@Async
@Service
public class MailService {

    private final JavaMailSender javaMailSender;

    public MailService(JavaMailSender mailSender) {
        this.javaMailSender = mailSender;
    }

    public void sendEmail(String to, String subject, String text){

        SimpleMailMessage message = new SimpleMailMessage();
        try {


            message.setFrom("notificacionesti@ccoa.org.co");
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            this.javaMailSender.send(message);



        }catch (Exception e){
            System.out.println(e);
        }
    }


    public void sendEmailMime(String to, String subject, String text,String html){

        MimeMessagePreparator mailMessage = mimeMessage -> {

            MimeMessageHelper message = new MimeMessageHelper(
                    mimeMessage, true);
            try {

                message.setFrom("notificacionesti@ccoa.org.co");
                message.setTo(to);
                message.setSubject(subject);
                message.setText(text,html);
            } catch (Exception e) {
                System.out.println(e);
            }
        };
       this.javaMailSender.send(mailMessage);
    }
}
