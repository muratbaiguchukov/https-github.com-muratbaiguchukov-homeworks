package kg.example6.country.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "image")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Image extends BaseEntity{

    @Column(name = "image_name", nullable = false)
    String imageName;

    @Column(name = "image_url", nullable = false, unique = true)
    String imageUrl;
}
