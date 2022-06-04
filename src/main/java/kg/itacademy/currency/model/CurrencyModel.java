package kg.itacademy.currency.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class CurrencyModel {
    private Long id;

    private String currencyName;

    private Double currencyRate;

}
