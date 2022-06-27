package kg.itacademy.employee.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeApiResponse {
    private EmployeeApiModel data;
    private String status;
    private String message;
}
