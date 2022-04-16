package com.company.model;


public class Ticket {
    public static int count = 0;

    private int id;
    private String departure;
    private String place;
    private String arrival;
    private String fullNameClient;

    public Ticket(){
    }

    public Ticket(int id, String departure, String place, String arrival, String fullNameClient) {
        count++;

        this.id = id;
        this.departure = departure;
        this.place = place;
        this.arrival = arrival;
        this.fullNameClient = fullNameClient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getFullNameClient() {
        return fullNameClient;
    }

    public void setFullNameClient(String fullNameClient) {
        this.fullNameClient = fullNameClient;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", departure='" + departure + '\'' +
                ", place='" + place + '\'' +
                ", arrival='" + arrival + '\'' +
                '}';
    }
}
