package kg.itacademy.currency.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "user_currency")
@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseEntity {

    @Column(name = "login", nullable = false, unique = true)
    String login;

    @Column(name = "password", nullable = false)
    String password;

    @Column(name = "email", nullable = false, unique = true)
    String email;

}
