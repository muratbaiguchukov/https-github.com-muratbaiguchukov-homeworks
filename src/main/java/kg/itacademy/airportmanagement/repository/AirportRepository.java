package kg.itacademy.airportmanagement.repository;

import kg.itacademy.airportmanagement.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    List<Airport> findAllByAirportName(String airportName);
}
