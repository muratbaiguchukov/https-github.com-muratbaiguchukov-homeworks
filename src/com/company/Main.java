package com.company;

import com.company.controller.AirportManagement;
import com.company.enams.Status;
import com.company.model.Airplane;
import com.company.model.Flight;
import com.company.model.Ticket;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AirportManagement airportManagement = new AirportManagement();
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
                    Airplane airplane = new Airplane();
                    System.out.println("Enter id: ");
                    int airplaneId = scanner.nextInt();
                    airplane.setId(airplaneId);

                    System.out.println("Enter model: ");
                    String model = scanner.next();
                    airplane.setModel(model);

                    System.out.println("Enter type: ");
                    String type = scanner.next();
                    airplane.setType(type);
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
                    newFlight.setTickets(ticketNum);

                    for (int i = 0; i < newFlight.getTickets().length; i++) {
                        Ticket ticket = new Ticket();
                        ticket.setId(i + 1);
                        ticket.setDeparture("12:00");
                        ticket.setArrival("17:00");
                        ticket.setPlace("Tokyo");
                        ticket.setFullNameClient("Max");
                        newFlight.getTickets()[i] = ticket;
                    }

                    airportManagement.addNewFlight(newFlight);
                    break;
                case 2:
                    System.out.println("Enter flight number to buy a ticket: ");
                    int num = scanner.nextInt();
                    System.out.println("Enter full name: ");
                    String fullName = scanner.next();
                    airportManagement.buyingTicketsByFlightNumber(num, fullName);
                    break;
                case 3:
                    airportManagement.showAllFlights();
                    break;
                case 4:
                    airportManagement.ticketInfo();
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

