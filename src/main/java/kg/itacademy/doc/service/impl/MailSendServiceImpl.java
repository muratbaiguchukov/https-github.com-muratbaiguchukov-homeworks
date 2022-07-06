package kg.itacademy.doc.service.impl;

import kg.itacademy.doc.model.MailSendModel;
import kg.itacademy.doc.service.MailSendService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.Objects;

@Service
@AllArgsConstructor
public class MailSendServiceImpl implements MailSendService {
    final JavaMailSender javaMailSender;
    final Environment environment;

    @Override
    public String mailSend(MailSendModel mailSendModel) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            mimeMessage.setSubject(mailSendModel.getTitle(), "UTF-8");

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setFrom(Objects.requireNonNull(environment.getProperty("spring.mail.username")));
            mimeMessageHelper.setTo(mailSendModel.getReceiverEmail());
            mimeMessageHelper.setText(mailSendModel.getText(), true);
            javaMailSender.send(mimeMessage);

            return "Успешно";
        } catch (Exception ignored) {
            return "Не успешно";
        }
    }
}
