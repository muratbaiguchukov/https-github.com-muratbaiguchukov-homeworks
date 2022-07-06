package kg.itacademy.doc.controller;

import kg.itacademy.doc.model.MailSendModel;
import kg.itacademy.doc.service.MailSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/mail/")
public class MailSenderController {
    final MailSendService mailSendService;

    @Autowired
    public MailSenderController(MailSendService mailSendService) {
        this.mailSendService = mailSendService;
    }

    @PostMapping("send")
    public String sendMail(@RequestBody MailSendModel mailSendModel) {
    return mailSendService.mailSend(mailSendModel);
    }
}
