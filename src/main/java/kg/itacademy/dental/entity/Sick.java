package kg.itacademy.dental.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "sicks")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Sick extends BaseEntity {
    @Column(name = "sick_fullname", nullable = false)
    String sickFullname;

    @Column(name = "sick_birth_day")
    LocalDate sickBirthDay;

    @Column(name = "sick_payment")
    BigDecimal sickPayment;

    @Column(name = "sick_visiting_time", nullable = false)
    LocalDateTime sickVisitingTime;

    @ManyToOne
    @JoinColumn(name = "dentist_id")
    Dentist dentist;

    @ManyToOne
    @JoinColumn(name = "dental_work_id")
    DentalWork dentalWork;

    @Column(name = "phonenumber")
    String phonenumber;
}
