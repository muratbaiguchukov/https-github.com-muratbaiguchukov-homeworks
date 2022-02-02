package com.company.controller;

import com.company.model.Flight;
import com.company.model.Ticket;

public interface Management {
    void addNewFlight(Flight flight);
    void buyingTicketsByFlightNumber(Flight flight);

    void showAllFlights();
    void ticketInfo();
    Flight searchFlightByTicketNumber(Ticket ticket);
}
