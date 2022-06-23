package kg.itacademy.doc.service;

import kg.itacademy.doc.model.UserAuthModel;
import kg.itacademy.doc.model.UserModel;

public interface UserService {
    String getToken(UserAuthModel userAuthDto);
    String createUser(UserModel userAuthDto);
}
