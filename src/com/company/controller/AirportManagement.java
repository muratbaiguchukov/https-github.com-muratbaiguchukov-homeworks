package com.company.controller;

import com.company.model.Flight;
import com.company.model.Ticket;;

public class AirportManagement implements Management {
    private Flight[] flights = new Flight[3];
    private Ticket[] tickets = new Ticket[10];


    @Override
    public void addNewFlight(Flight flight) {
        for (int i = 0; i < flights.length; i ++){
            if (flights[i] == null) {
                flights[i] = flight;
                break;
            }
        }
    }

    @Override
    public void buyingTicketsByFlightNumber(Flight flight) {
        for (int i = 0; i < flights.length; i ++){
        }

    }

    @Override
    public void showAllFlights() {
        for (int i = 0; i < flights.length; i ++ ){
            if (flights[i] != null){
                System.out.println(flights[i]);
            }
        }
    }


        @Override
    public void ticketInfo() {
        for (int i = 0; i < flights.length; i ++){
        }
    }

    @Override
    public Flight searchFlightByTicketNumber(Ticket ticket) {
        for (Flight flight : flights) {
            if (ticket.getId() == flight.getId()) {
                System.out.println(flights);
            }
        }
        return null;
    }
}
