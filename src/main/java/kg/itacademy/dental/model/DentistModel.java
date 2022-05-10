package kg.itacademy.dental.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class DentistModel {

    private Long id;

    private String dentistFullname;

    private LocalDateTime openingHours;

    private String phonenumber;

}
