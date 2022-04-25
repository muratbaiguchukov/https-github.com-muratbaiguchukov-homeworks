package kg.itacademy.airportmanagement.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirportModel {
    private Long id;
    private String airportName;

    private String city;

    private String coordinates;

    private String timezone;
}
