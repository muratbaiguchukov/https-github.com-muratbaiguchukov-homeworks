package com.company.model;

import java.time.LocalDateTime;

public class Patient {
    private Integer id;
    private String inn;
    private String fullname;
    private String diagnosis;
    private Float payment;
    private Float balance_of_payment;
    private String phonenumber;
    private LocalDateTime visiting_time;
    private Doctor doctor;
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
