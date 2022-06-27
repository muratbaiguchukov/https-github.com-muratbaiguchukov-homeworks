package kg.itacademy.employee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EmployeeApiListResponse {
    private List<EmployeeApiModel> data;
    private String status;
    private String message;


}
