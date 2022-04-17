package kg.itacademy.springlearn.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "usercustom")
@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login")
    String login;

    @Column(name = "password")
    String password;

    @Column(name = "email")
    String email;

}
