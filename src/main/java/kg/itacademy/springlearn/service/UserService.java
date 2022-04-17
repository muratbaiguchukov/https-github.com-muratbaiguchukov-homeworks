package kg.itacademy.springlearn.service;

import kg.itacademy.springlearn.Entity.User;
import kg.itacademy.springlearn.model.UserCustom;

public interface UserService {
    void createNewUser(UserCustom userCustom);
    User getUser(Integer Id);
    }


