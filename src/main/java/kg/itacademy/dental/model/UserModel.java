package kg.itacademy.dental.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {
    String login;
    String password;
    String email;
    // здесь же может быть указан спислок ролей
}

