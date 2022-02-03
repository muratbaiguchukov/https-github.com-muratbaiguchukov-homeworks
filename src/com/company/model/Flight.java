package com.company.model;

import com.company.enams.Status;

public class Flight {
    private int id;
    private String departureTime;
    private String arrivalTime;
    private String airplane;
    private Status status;
    private Ticket[] tickets = new Ticket[10];

    public Flight() {
    }

    public Flight(int id, String departureTime, String arrivalTime, String airplane, Status status) {
        this.id = id;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.airplane = airplane;
        this.status = status;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }


    public String getDepartureTime() {

        return departureTime;
    }

    public void setDepartureTime(String departureTime) {

        this.departureTime = departureTime;
    }

    public String getArrivalTime() {

        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {

        this.arrivalTime = arrivalTime;
    }

    public String getAirplane() {

        return airplane;
    }

    public void setAirplane(String airplane) {

        this.airplane = airplane;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Ticket[] getTickets() {
        return tickets;
    }

    public void setTickets(Ticket[] tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", aircraft=" + airplane + '\'' +
                ", status=" + status + '\'' +
                '}';
    }
}
