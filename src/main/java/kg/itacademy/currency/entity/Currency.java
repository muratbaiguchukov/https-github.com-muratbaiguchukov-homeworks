package kg.itacademy.currency.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "currency")
@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Currency extends BaseEntity {
    @Column(name = "currency_name", nullable = false, unique = true)
    String name;

    @Column(name = "currency_rate", nullable = false)
    Double rate;

   }
