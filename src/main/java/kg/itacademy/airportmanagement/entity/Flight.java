package kg.itacademy.airportmanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "flights")
@Entity
@Getter
@Setter
public class Flight extends BaseEntity {
    @Column(name = "flight_no")
    private String flightNo;

    @Column(name = "scheduled_departure")
    private LocalDateTime scheduledDeparture;

    @Column(name = "scheduled_arrival")
    private LocalDateTime scheduledArrival;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    private Airport arrivalAirport;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private FlightStatus flightStatus;

    @ManyToOne
    @JoinColumn(name = "aircraft_id")
    private Aircraft aircraft;
}
