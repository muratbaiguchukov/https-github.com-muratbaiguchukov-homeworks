package kg.itacademy.dental.model;

import kg.itacademy.dental.entity.Dentist;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DentalWorkModel {

    private Long id;

    private String dentalWorkName;

    private Dentist dentist;

    private BigDecimal price;

}

