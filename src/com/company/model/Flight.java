package com.company.model;

import com.company.enams.Status;

import java.util.Arrays;

public class Flight {
    public static int count = 0;

    private int id;
    private String departureTime;
    private String arrivalTime;
    private Airplane airplane;
    private Status status;
    private Ticket[] tickets;

    public Flight() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Flight.count = count;
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

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
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

    public void setTickets(int countTickets) {
        this.tickets = new Ticket[countTickets];
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", airplane='" + airplane +
                ", status=" + status +
                ", tickets=" + Arrays.toString(tickets) +
                '}';
    }
}
