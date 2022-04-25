package kg.itacademy.airportmanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "aircrafts")
@Entity
@Getter
@Setter
public class Aircraft extends BaseEntity {
    @Column(name = "model")
    private String model;

    @Column(name = "range")
    private String range;

    @OneToMany(mappedBy = "aircraft")
    private List<Seat> seats;
}
