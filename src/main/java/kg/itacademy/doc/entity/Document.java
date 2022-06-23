package kg.itacademy.doc.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "document")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Document extends BaseEntity {
    @Column(name = "document_name", nullable = false, unique = true)
    String documentName;

    @Column(name = "number")
    String number;

    @Column(name = "date", nullable = false)
    LocalDate date;

    @Column(name = "execution_date")
    LocalDate executionDate;

    @ManyToOne
    @JoinColumn(name = "executor_id", nullable = false)
    Executor executor;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    DocumentStatus documentStatus;



}

