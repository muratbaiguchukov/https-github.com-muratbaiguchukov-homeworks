package kg.example6.country.service;

import kg.example6.country.model.UserAuthModel;
import kg.example6.country.model.UserModel;

public interface UserService {
    String getToken(UserAuthModel userAuthDto);
    String createUser(UserModel userAuthDto);
}