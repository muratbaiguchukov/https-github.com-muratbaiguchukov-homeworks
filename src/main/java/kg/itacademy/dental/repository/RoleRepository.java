package kg.itacademy.dental.repository;

import kg.itacademy.dental.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findFirstByNameRole(String nameRole);
}

