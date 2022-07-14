package kg.itacademy.doc.component;

import kg.itacademy.doc.entity.Document;
import kg.itacademy.doc.entity.Executor;
import kg.itacademy.doc.model.MailSendModel;
import kg.itacademy.doc.repository.DocumentRepository;
import kg.itacademy.doc.service.MailSendService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

import static kg.itacademy.doc.entity.DocumentStatus.DEADLINE_HAS_EXPIRED;

@Component
@AllArgsConstructor
public class SignalSchedulerComponent {

    private final DocumentRepository documentRepository;
    private final MailSendService mailSendService;

    @Scheduled(cron = "0 0 * * * *")
    public void emailSendMethod() {
        //Получить список истекших документов
        List<Document> list = documentRepository.findAllByExecutionDateBefore(LocalDate.now());
        // в цикле взять первый документ
        for (Document element : list) {
            // вытащить исполнителя
            Executor ex = element.getExecutor();
            // вытащить емейл исполнителя
            String email = ex.getEmail();
            // отправить емейл и текст
            MailSendModel sendModel = new MailSendModel();
            sendModel.setText("text");
            sendModel.setTitle("text");
            sendModel.setReceiverEmail(email);
            mailSendService.mailSend(sendModel);
            // изменить статус документа на просрочен
            element.setDocumentStatus(DEADLINE_HAS_EXPIRED);
            // сохранить документ
            documentRepository.save(element);
            // циел заканчивается
        }
    }
}


