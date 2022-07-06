package kg.itacademy.doc.repository;

import kg.itacademy.doc.entity.Document;
import kg.itacademy.doc.entity.DocumentStatus;
import kg.itacademy.doc.entity.Executor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findAllByDocumentName(String name);

    Document findByDocumentName(String documentName);

    Document findByNumber(String number);

    List<Document> findByDate(LocalDate date);

    List<Document> findByDocumentStatus(DocumentStatus status);

    List<Document> findByExecutor(Executor executor);

    List<Document> findByExecutorAndExecutionDateBetween(Executor executor, LocalDate startDate, LocalDate endDate);


}


