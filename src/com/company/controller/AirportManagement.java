package com.company.controller;

import com.company.model.Flight;
import com.company.model.Ticket;;import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirportManagement implements Management {
    private List<Flight> flights = new ArrayList<>();
    private Ticket[] tickets;


    @Override
    public void addNewFlight(Flight flight) {
        flights.add(flight);
        System.out.println("Добавлен рейс ");
    }

    @Override
    public void buyingTicketsByFlightNumber(int number, String fullName) {
        for (Flight flight : flights) {
            if (flight.getId() == number) {
                for (int j = 0; j < flight.getTickets().length; j++) {
                    if (flight.getTickets()[j].getFullNameClient() != null) {
                        flight.getTickets()[j].setFullNameClient(fullName);
                        System.out.println(fullName + " купил билет");
                        return;
                    }
                }
            }
        }
        System.out.println("Не осталось мест");
    }

    @Override
    public void showAllFlights() {
        System.out.println(flights);
    }

    @Override
    public String ticketInfo() {
        long counter = 0l;
        for (Flight flight : flights)
            for (int j = 0; j < flights.getTickets().length; j++)
                if (flight.getTickets()[j].getFullNameClient() != null)
                    counter++;

                return "Количество рейсов: " + Flight.count +
                        "\nКоличество купленных билетов: " + counter;
            }

    @Override
    public void searchFlightByTicketNumber(int ticketNumber) {
        boolean check = true;
        for (Flight flight : flights)
            for (int i = 0; i < flight.getTickets().length; i++)
                if (flight.getTickets()[i].getId() == ticketNumber) {
                    System.out.println(flights.getTickets()[i]);
                    check = false;
                }
        if (check) {
            System.out.println("The flight not found");
        }
    }
}






