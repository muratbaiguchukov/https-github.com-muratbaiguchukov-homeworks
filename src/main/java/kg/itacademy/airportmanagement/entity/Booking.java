package kg.itacademy.airportmanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "bookings")
@Entity
public class Booking extends BaseEntity {
    @Column(name = "book_date")
    private LocalDateTime bookDate;

    @Column(name = "total_amount")
    private Long totalAmount;
}
