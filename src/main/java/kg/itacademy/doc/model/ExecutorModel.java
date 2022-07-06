package kg.itacademy.doc.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ExecutorModel {
    @NotNull
    private Long id;

    @NotBlank
    private String executorFullName;

    private String positionHeld;

    private String email;

}
