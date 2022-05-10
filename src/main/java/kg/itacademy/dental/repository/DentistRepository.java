package kg.itacademy.dental.repository;

import kg.itacademy.dental.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DentistRepository extends JpaRepository <Dentist, Long> {
List<Dentist> findAllByDentistFullname(String dentistFullname);
}
