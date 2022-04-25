package kg.itacademy.airportmanagement.repository;

import kg.itacademy.airportmanagement.entity.Seat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends CrudRepository<Seat, Long> {
}
