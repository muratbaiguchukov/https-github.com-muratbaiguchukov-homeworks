package com.company;

public class AirportManagement implements Manage{


    @Override
    public void addNewFlight() {

    }

    @Override
    public void buyingTicketsByFlightNumber() {

    }

    @Override
    public void showAllFlights() {
        for (Flight flight : flights) {
                if (flight != null) {
                    System.out.println(flight);
                }
        }
    }


        @Override
    public void TicketInfo() {

    }

    @Override
    public void searchFlightByTicketNumber() {

    }
}
