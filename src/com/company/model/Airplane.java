package com.company.model;

public class Airplane {
    protected int id;
    protected String model;
    protected String type;


    public Airplane() {
    }

    public Airplane(int id, String model, String type) {
        this.id = id;
        this.model = model;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }



    @Override
    public String toString() {
        return "AbstractAircraft{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
