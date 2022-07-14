package kg.itacademy.doc.service;

import kg.itacademy.doc.model.MailSendModel;

public interface MailSendService {
    boolean mailSend(MailSendModel mailSendModel);
}
