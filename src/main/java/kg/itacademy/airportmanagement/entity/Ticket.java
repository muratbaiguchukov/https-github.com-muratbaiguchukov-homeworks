package kg.itacademy.airportmanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "tickets")
@Entity
@Getter
@Setter
public class Ticket extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @Column(name = "passenger_id")
    private String passengerId;

    @Column(name = "passenger_name")
    private String name;

    @Column(name = "contact_data")
    private String contactData;

}
