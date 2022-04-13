package kg.itacademy.spring_learning.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserCustom {
    private String login;
    private String password;
    private String repassword;
    private String email;
}
