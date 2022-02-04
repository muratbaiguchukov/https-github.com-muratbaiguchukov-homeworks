package com.company;

import com.company.controller.AirportManagement;
import com.company.enams.Status;
import com.company.model.Flight;
import com.company.model.Ticket;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AirportManagement airportManagement = new AirportManagement();
        Ticket ticket = new Ticket(12, "8:00", "UK", "13:00");
        Flight flight1 = new Flight(121, "2", "5", "asa", Status.Flying, new Ticket[2]);

        Flight[] flight = new Flight[3];

        boolean check = true;
        int choice = 0;
        while (check) {
            getMenu();
            try {
                choice = new Scanner(System.in).nextInt();
            } catch (Exception exception) {
                System.out.println("Wrong choice.");
            }
            switch (choice) {
                case 1:
                    Flight newFlight = new Flight();
                    System.out.println("Enter id: ");
                    int id = scanner.nextInt();
                    newFlight.setId(id);

                    System.out.println("Enter departure time: ");
                    String departureTime = scanner.next();
                    newFlight.setDepartureTime(departureTime);

                    System.out.println("Enter arrival time: ");
                    String arrivalTime = scanner.next();
                    newFlight.setArrivalTime(arrivalTime);

                    System.out.println("Set the airplane: ");
                    String airplane = scanner.next();
                    newFlight.setAirplane(airplane);

                    System.out.println("Enter status: ");
                    try {
                        String status = scanner.next();
                        newFlight.setStatus(Status.valueOf(status));
                    } catch (IllegalArgumentException exception) {
                        System.out.println("Wrong status");
                    }

                    System.out.println("Enter ticket number: ");
                    int ticketNum = scanner.nextInt();
                    newFlight.setId(ticketNum);

                    airportManagement.addNewFlight(newFlight);
                    break;
                case 2:
                    System.out.println("Enter flight number to buy a ticket: ");
                    int num = scanner.nextInt();
                    airportManagement.buyingTicketsByFlightNumber(num);
                    break;
                case 3:
                    airportManagement.showAllFlights();
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Enter ticket number: ");
                    int number = scanner.nextInt();
                    airportManagement.searchFlightByTicketNumber(number);
                    break;

            }
        }
    }

    private static void getMenu() {
        System.out.println("1. Add new flight");
        System.out.println("2. Buy ticket by flight number");
        System.out.println("3. Show all flights");
        System.out.println("4. Ticket information");
        System.out.println("5. Search flight by ticket number");
    }
}
