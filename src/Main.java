import dao.UserDao;
import model.User;
import model.UserForAuthorize;
import service.UserService;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        User newUser = new User();
//        newUser.setId(8);
//        newUser.setLogin("fgh");
//        newUser.setEmail("rtyn@yandex.ru");
//        newUser.setPassword("157684F");
//        newUser.setDateOfRegistration(LocalDateTime.now());

        UserService userService = new UserService();
//        int count = userService.registerUser(newUser);
//        if (count > 0) {
//            System.out.println("succes register");
//        } else {
//            System.out.println("fail register");
//        }
//        UserForAuthorize userForAuthorize = new UserForAuthorize("login", "password");
//        System.out.println(UserDao.authorize(userForAuthorize));

        userService.authorize("fox", "fox12345");



       // menu();
    }

//    public static void menu() {
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println("Registration-> 1" +
//                    "\nLogin-> 2" +
//                    "\nExit-> 0");
//            System.out.print("-> ");
//            int num = scanner.nextInt();
//            switch (num) {
//                case 1:
//                    System.out.print("username-> ");
//                    String name = scanner.next();
//                    System.out.print("email-> ");
//                    String mail = scanner.next();
//                    System.out.print("password-> ");
//                    String password = scanner.next();
//
//                    break;
//                case 2:
//                    System.out.print("username-> ");
//                    String userName = scanner.next();
//                    System.out.print("password-> ");
//                    String passwords = scanner.next();
//
//                    break;
//                default:
//                    if (num == 0) {
//                        return;
//                    }
//            }
//        }
//
//    }


}

