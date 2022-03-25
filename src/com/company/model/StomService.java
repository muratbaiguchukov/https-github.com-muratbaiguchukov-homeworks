package com.company.model;

public class StomService {
    private Integer id;
    private String types_of_services;
    private Doctor doctor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypes_of_services() {
        return types_of_services;
    }

    public void setTypes_of_services(String types_of_services) {
        this.types_of_services = types_of_services;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
