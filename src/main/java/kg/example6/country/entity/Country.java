package kg.example6.country.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "countries")
@Entity
public class Country extends BaseEntity {

    @Column(name = "country_name", nullable = false, unique = true)
    private String countryName;

    @Column(name = "alpha_code", nullable = false, unique = true)
    private String alphaCode;

    @Column(name = "capital", nullable = false, unique = true)
    private String capital;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

}