package kg.itacademy.doc.model;

import kg.itacademy.doc.entity.DocumentStatus;
import kg.itacademy.doc.entity.Executor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NotNull
public class DocumentCreateModel {

    @NotBlank(message = "document name can't be blank")
    private String documentName;

    @NotBlank
    private String number;

    @NotBlank
    private LocalDate date;

    @NotBlank
    private LocalDate executionDate;

    @NotNull
    private Executor executor;

    @NotBlank
    private DocumentStatus documentStatus;
}
