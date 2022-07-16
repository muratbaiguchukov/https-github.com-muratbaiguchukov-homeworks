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
public class DocumentModel {

    @NotNull
    private Long id;

    @NotBlank(message = "document name can't be blank")
    private String documentName;

    @NotBlank
    private String number;

    @NotNull
    private LocalDate date;

    @NotNull
    private LocalDate executionDate;

    @NotNull
    private ExecutorModel executor;

    @NotNull
    private DocumentStatus documentStatus;
    private Executor executorModel;

    public Executor getExecutorModel() {
        return executorModel;
    }

    public void setExecutorModel(Executor executorModel) {
        this.executorModel = executorModel;
    }
}
