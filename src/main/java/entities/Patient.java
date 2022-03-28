package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    private Integer id;

    @Column(name = "inn")
    private String inn;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "payment")
    private Float payment;

    @Column(name = "balance_of_payment")
    private Float balance_of_payment;

    @Column(name = "phonenumber")
    private String phonenumber;

    @Column(name = "visiting_time")
    private LocalDateTime visiting_time;

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

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Float getPayment() {
        return payment;
    }

    public void setPayment(Float payment) {
        this.payment = payment;
    }

    public Float getBalance_of_payment() {
        return balance_of_payment;
    }

    public void setBalance_of_payment(Float balance_of_payment) {
        this.balance_of_payment = balance_of_payment;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public LocalDateTime getVisiting_time() {
        return visiting_time;
    }

    public void setVisiting_time(LocalDateTime visiting_time) {
        this.visiting_time = visiting_time;
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

