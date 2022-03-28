package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "duty")
public class Duty {

    @Id
    private Integer id;

    @Column(name = "days_of_duty")
    private LocalDateTime days_of_duty;

    @Column(name = "doctor")
    private Doctor doctor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDays_of_duty() {
        return days_of_duty;
    }

    public void setDays_of_duty(LocalDateTime days_of_duty) {
        this.days_of_duty = days_of_duty;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
