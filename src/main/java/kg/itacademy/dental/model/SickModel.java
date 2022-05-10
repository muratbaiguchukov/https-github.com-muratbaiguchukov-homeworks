package kg.itacademy.dental.model;

import kg.itacademy.dental.entity.DentalWork;
import kg.itacademy.dental.entity.Dentist;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class SickModel {
    private Long id;

    private String sickFullname;

    private LocalDate sickBirthDay;

    private BigDecimal sickPayment;

    private LocalDateTime sickVisitingTime;

    private Dentist dentist;

    private DentalWork dentalWork;

    private String phonenumber;
}





