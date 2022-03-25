package com.company.model;

import java.time.LocalDateTime;

public class Duty {
    private Integer id;
    private LocalDateTime days_of_duty;
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
