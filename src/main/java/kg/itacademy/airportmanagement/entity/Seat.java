package kg.itacademy.airportmanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "seats")
@Entity
public class Seat extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "aircraft_id")
    private Aircraft aircraft;

    @Column(name = "seat_no")
    private Integer seatNo;

    @Column(name = "fare_conditions")
    private String fareConditions;
}
