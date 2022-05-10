package kg.itacademy.dental.repository;

import kg.itacademy.dental.entity.Cabinet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CabinetRepository extends JpaRepository<Cabinet, Long> {
    List<Cabinet> findAllByCodeCabinet(String codeCabinet);
}