package kg.itacademy.airportmanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "boarding_passes")
@Entity
@Getter
@Setter
public class BoardingPasses extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "ticket_flight_id")
    private TicketFlight ticketFlight;

    @Column(name = "boarding_no")
    private String boardingNo;

    @Column(name = "seat_no")
    private String seatNo;
}
