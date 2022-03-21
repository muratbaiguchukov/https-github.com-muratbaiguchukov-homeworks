import model.User;
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

        User user = new User();
        user.setLogin("fgh");
        user.setPassword("157684F");
        ResultSet resultSet = userService.authorize(user);

        UserService userService1 = new UserService();
        int count1 = userService1.authorize(user);
        int counter = 0;
        try {
            while (resultSet.next()) {
                counter++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            if (counter >= 1)
                System.out.println("success authorize");
            else {
                System.out.println("fail authorize");
            }

    }
}

