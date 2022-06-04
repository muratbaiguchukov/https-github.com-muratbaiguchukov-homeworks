package kg.itacademy.currency.service;

import kg.itacademy.currency.model.UserAuthModel;
import kg.itacademy.currency.model.UserModel;

public interface UserService {
    String getToken(UserAuthModel userAuthDto);
    String createUser(UserModel userAuthDto);
}
