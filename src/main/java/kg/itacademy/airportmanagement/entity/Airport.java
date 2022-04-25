package kg.itacademy.airportmanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "airports")
@Entity
public class Airport extends BaseEntity {
    @Column(name = "airport_name")
    private String airportName;

    @Column(name = "city")
    private String city;

    @Column(name = "coordinates")
    private String coordinates;

    @Column(name = "timezone")
    private String timezone;
}
