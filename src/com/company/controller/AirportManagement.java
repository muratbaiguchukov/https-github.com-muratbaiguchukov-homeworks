package com.company.controller;

import com.company.model.Flight;
import com.company.model.Ticket;;

public class AirportManagement implements Management {
    private Flight[] flights = new Flight[3];
    private Ticket[] tickets = new Ticket[5];


    @Override
    public void addNewFlight(Flight flight) {
        for (int i = 0; i < flights.length; i++) {
            if (flights[i] == null) {
                flights[i] = flight;
            }
        }
    }

    @Override
    public void buyingTicketsByFlightNumber(int number) {
        Ticket ticket = new Ticket(12, "8:00", "UK", "13:00");
        boolean check = false;
        for (Flight flight : flights) {
            if (flight.getId() == number) {
                for (int j = 0; j < flight.getTickets().length; j++) {
                    if (flight.getTickets()[j] != null) {
                        flight.getTickets()[j] = ticket;
                        check = true;
                        return;
                    }
                }
            }
            if (check) {
                System.out.println("Вы купили билет");
            } else {
                System.out.println("Не осталось мест");
            }
        }
    }


    @Override
    public void showAllFlights() {
        for (int i = 0; i < flights.length; i++) {
            if (flights[i] != null) {
                System.out.println(flights[i]);
            }
        }
    }

    @Override
    public void ticketInfo() {

    }

    @Override
    public Flight searchFlightByTicketNumber(int number) {
        return null;
    }


    @Override
    public void ticketInfo() {
        int bought = 0;
        int notBought = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i].getId() == 0) {
                notBought++;
                System.out.println("Not bought: " + notBought);
            } else {
                bought++;
                System.out.println("Bought: " + bought);
                break;
            }
        }
    }

    @Override
    public Flight searchFlightByTicketNumber(int ticketNumber) {
        for (Flight flight : flights) {
            for (Ticket ticket : tickets) {
                if (ticketNumber == ticket.getId())
                    return flight;
            }
        }
        throw new NullPointerException("We can't find the flight");
    }
}
