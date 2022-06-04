package kg.itacademy.currency.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "users_roles")
@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRole extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    Role role;
}
