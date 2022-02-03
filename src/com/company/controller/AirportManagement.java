package com.company.controller;

import com.company.model.Flight;
import com.company.model.Ticket;;import java.util.Scanner;

public class AirportManagement implements Management {
    private Flight[] flights = new Flight[3];


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
    public void buyingTicketsByFlightNumber(int number) {
        Ticket ticket = new Ticket();
        boolean check = false;
        for (Flight flight : flights) {
            if (flight.getId() == number) {
                for (int j = 0; j < flight.().length; j++) {
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
        for (int i = 0; i < flights.length; i ++ ){
            if (flights[i] != null){
                System.out.println(flights[i]);
            }
        }
    }


        @Override
    public void ticketInfo() {
        Ticket[] tickets = new Ticket[10];
            Scanner scanner = new Scanner(System.in);

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
