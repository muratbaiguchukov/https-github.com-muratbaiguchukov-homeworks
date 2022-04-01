package entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.mapping.List;

import javax.persistence.*;

@Entity
@Table(name = "items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "description")
    String description;

    @Column(name = "price")
    Integer price;//decimal

    @ManyToMany
    @JoinColumn(name = "categories_id", nullable = false)
    List<Categories> categories;
}
