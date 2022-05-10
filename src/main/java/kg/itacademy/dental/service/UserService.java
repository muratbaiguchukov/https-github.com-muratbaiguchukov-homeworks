package kg.itacademy.dental.service;

import kg.itacademy.dental.model.UserAuthModel;
import kg.itacademy.dental.model.UserModel;

public interface UserService {
    String getToken(UserAuthModel userAuthDto);
    String createUser(UserModel userAuthDto);
}
