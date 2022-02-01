package com.company;

public class Flight {
    private int id;
    private String direction;
    private String departureTime;
    private String arrivalTime;
    private Airplane airplane;

    public Flight() {
    }

    public Flight(int id, String direction, String departureTime, String arrivalTime, Airplane airplane) {
        this.id = id;
        this.direction = direction;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.airplane = airplane;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
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

    public void setAircraft(Airplane airplane) {

        this.airplane = airplane;
    }


    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", direction='" + direction + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", aircraft=" + airplane + '\'' +
                '}';
    }
}
