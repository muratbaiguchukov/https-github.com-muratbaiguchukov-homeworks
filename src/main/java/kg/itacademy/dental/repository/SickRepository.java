package kg.itacademy.dental.repository;

import kg.itacademy.dental.entity.Sick;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SickRepository extends JpaRepository<Sick, Long> {
    List<Sick> findAllBySickFullname(String sickFullname);
}
