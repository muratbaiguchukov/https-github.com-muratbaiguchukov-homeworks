package entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "news")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "title")
    String title;

    @Column(name = "news_text", nullable = false)
    String newsText;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @Column(name = "publication_time", nullable = false)
    LocalTime publicationTime;
}
