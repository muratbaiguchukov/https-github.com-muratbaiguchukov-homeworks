package kg.itacademy.dental.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Table(name = "dentalWorks")
@Entity
public class DentalWork extends BaseEntity{
    @Column(name = "dental_work_name")
    private String dentalWorkName;

    @OneToOne
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;

    @Column(name = "price")
    private BigDecimal price;

   }

