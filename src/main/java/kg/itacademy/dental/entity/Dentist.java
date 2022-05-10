package kg.itacademy.dental.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "dentists")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Dentist extends BaseEntity {
    @Column(name = "dentists_fullname", nullable = false, unique = true)
    String dentistFullname;

    @Column(name = "opening_hours", nullable = false)
    LocalDateTime openingHours;

    @Column(name = "phonenumber")
    String phonenumber;
}
