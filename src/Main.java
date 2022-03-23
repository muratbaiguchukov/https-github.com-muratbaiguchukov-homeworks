import dao.UserDao;
import model.User;
import model.UserForAuthorize;
import service.UserService;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User newUser = new User();
        newUser.setId(6);
        newUser.setLogin("fgh");
        newUser.setEmail("rtyn@yandex.ru");
        newUser.setPassword("157684F");
        newUser.setDateOfRegistration(LocalDateTime.now());

        UserService userService = new UserService();
        int count = userService.registerUser(newUser);
        if (count > 0) {
            System.out.println("succes register");
        } else{
            System.out.println("fail register");
        }


        UserForAuthorize userForAuthorize = new UserForAuthorize("login", "password");
        System.out.println(UserDao.authorize(userForAuthorize));






    }


}

