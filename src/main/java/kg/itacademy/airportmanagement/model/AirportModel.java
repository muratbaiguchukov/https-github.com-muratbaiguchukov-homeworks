package kg.itacademy.airportmanagement.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class AirportModel {
    private Long id;

    @NotNull
    @Size(min = 5, max = 100) // размер не меньше 5 и не больше 100 символов
    @NotBlank //должен быть обязательно заполненным
    @NotEmpty //не должен быть пустым
    @Email //правильное написание электронной почты - должен иметь формат адреса эл/почты
    //@Pattern(regexp = )// с какого символа должен начинаться писаться название аэропорта -- с цифры, символа и т.д.
    @Null// обязательно должен быть равен нулю
    private String airportName;

    private String city;

    private String coordinates;

    private String timezone;
}
