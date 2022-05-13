package kg.example6.country.controller;

import kg.example6.country.model.UserAuthModel;
import kg.example6.country.model.UserModel;
import kg.example6.country.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/user")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserController {
    final UserService userService;

    @PostMapping(path = "/sign-in")
    public String getAuthToken(@Valid @RequestBody UserAuthModel userAuthDto) {
        return userService.getToken(userAuthDto);
    }

    @PostMapping("/sign-up")
    public String register(@RequestBody UserModel userModel) {
        return userService.createUser(userModel);
    }
}