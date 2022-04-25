package kg.itacademy.airportmanagement.repository;

import kg.itacademy.airportmanagement.entity.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {
}
