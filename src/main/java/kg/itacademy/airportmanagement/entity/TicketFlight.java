package kg.itacademy.airportmanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "ticket_flights")
@Entity
@Getter
@Setter
public class TicketFlight extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @Column(name = "fare_conditions")
    private String fareConditions;

    @Column(name = "amount")
    private Integer amount;
}
