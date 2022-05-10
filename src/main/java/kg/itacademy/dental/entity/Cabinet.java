package kg.itacademy.dental.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "cabinets")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cabinet extends BaseEntity {
    @Column(name = "code_cabinet", nullable = false, unique = true)
    String codeCabinet;

    @OneToOne
    @JoinColumn(name = "dentist_id")
    Dentist dentist;
}
