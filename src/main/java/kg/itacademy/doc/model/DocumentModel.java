package kg.itacademy.doc.model;

import kg.itacademy.doc.entity.DocumentStatus;
import kg.itacademy.doc.entity.Executor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Getter
@Setter
public class DocumentModel {

    private Long id;

    private String documentName;

    private String number;

    private LocalDate date;

    private LocalDate executionDate;

    private Executor executor;

    private DocumentStatus documentStatus;
}
