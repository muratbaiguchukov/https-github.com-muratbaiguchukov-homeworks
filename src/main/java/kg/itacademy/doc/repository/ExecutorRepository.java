package kg.itacademy.doc.repository;

import kg.itacademy.doc.entity.Executor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExecutorRepository extends JpaRepository<Executor, Long> {
    List<Executor> findAllByExecutorFullName(String fullName);
}
