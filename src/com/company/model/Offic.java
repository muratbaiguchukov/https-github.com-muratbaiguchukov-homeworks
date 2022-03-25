package com.company.model;

public class Offic {
    private Integer id;
    private String code_offices;
    private Doctor doctor;
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
