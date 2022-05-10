package kg.itacademy.dental.repository;

import kg.itacademy.dental.entity.DentalWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DentalWorkRepository extends JpaRepository<DentalWork, Long>{
      List<DentalWork> findAllByDentalWorkName(String dentalWorkName);
}
