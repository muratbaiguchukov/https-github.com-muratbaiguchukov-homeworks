package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "offic")
public class Offic {

    @Id
    private Integer id;

    @Column(name = "code_offices")
    private String code_offices;

    @Column(name = "doctor")
    private Doctor doctor;

    @Column(name = "stomService")
    private StomService stomService;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode_offices() {
        return code_offices;
    }

    public void setCode_offices(String code_offices) {
        this.code_offices = code_offices;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public StomService getStomService() {
        return stomService;
    }

    public void setStomService(StomService stomService) {
        this.stomService = stomService;
    }
}
