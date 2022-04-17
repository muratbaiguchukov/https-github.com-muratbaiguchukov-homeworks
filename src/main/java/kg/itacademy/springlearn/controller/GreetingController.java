package kg.itacademy.springlearn.controller;

import kg.itacademy.springlearn.model.UserCustom;
import kg.itacademy.springlearn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getGreeting() {
        return "greeting";
    }

    @GetMapping("/user/create")
    public String createUser() {
        return "register";
    }

    @PostMapping("user/create/post")
    public String createNewUser(@ModelAttribute(name = "user") UserCustom userCustom) {
        userService.createNewUser(userCustom);
        userService.getUser(1);
        return "greeting";
    }


}
