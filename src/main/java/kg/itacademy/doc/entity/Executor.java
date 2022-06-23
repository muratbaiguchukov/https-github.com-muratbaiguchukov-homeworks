package kg.itacademy.doc.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "executor")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Executor extends BaseEntity {
    @Column(name = "executor_full_name", nullable = false, unique = true)
    String executorFullName;

    @Column(name = "job_title", nullable = false, unique = true)
    String jobTitle;

   }
