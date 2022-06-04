package kg.itacademy.currency.repository;

import kg.itacademy.currency.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findFirstByNameRole(String nameRole);
}
