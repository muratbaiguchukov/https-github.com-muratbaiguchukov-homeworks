package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    private Integer id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "opening_hours")
    private Time opening_hours;

    @Column(name = "phonenumber")
    private String phonenumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Time getOpening_hours() {
        return opening_hours;
    }

    public void setOpening_hours(Time opening_hours) {
        this.opening_hours = opening_hours;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
