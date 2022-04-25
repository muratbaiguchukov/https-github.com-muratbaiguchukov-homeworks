package kg.itacademy.airportmanagement.service;

import kg.itacademy.airportmanagement.model.AirportModel;

import java.util.List;

public interface AirportService {
    AirportModel create(AirportModel airportModel);

    boolean update(AirportModel airportModel);

    boolean deleteById(Long id);

    AirportModel getById(Long id);

    List<AirportModel> getAllByAirportName(String airportName);
}
