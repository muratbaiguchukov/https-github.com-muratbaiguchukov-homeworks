package kg.itacademy.currency.service.impl;

import kg.itacademy.currency.entity.User;
import kg.itacademy.currency.entity.UserRole;
import kg.itacademy.currency.exception.UserSignInException;
import kg.itacademy.currency.model.UserAuthModel;
import kg.itacademy.currency.model.UserModel;
import kg.itacademy.currency.repository.RoleRepository;
import kg.itacademy.currency.repository.UserRepository;
import kg.itacademy.currency.repository.UserRoleRepository;
import kg.itacademy.currency.service.UserService;
import kg.itacademy.currency.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String getToken(UserAuthModel userAuthDto) {
        User user = userRepository
                .findByLogin(userAuthDto.getLogin());
        if(user==null){
            throw new UsernameNotFoundException("Username not found");
        }
        boolean isMatches = passwordEncoder.matches(userAuthDto.getPassword(), user.getPassword());
        if (isMatches) {
            return "Basic " + new String(Base64.getEncoder()
                    .encode((user.getLogin() + ":" + userAuthDto.getPassword()).getBytes()));
        } else {
            throw new UserSignInException("Неправильный логин или пароль!", HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public String createUser(UserModel userModel) {
        User user = new User();

        user.setLogin(userModel.getLogin());
        user.setEmail(userModel.getEmail());

        user.setPassword(passwordEncoder.encode(userModel.getPassword()));


        UserRole userRole = new UserRole();
        if (userModel.getLogin().contains("admin")) {
            userRole.setRole(roleRepository.findFirstByNameRole("Admin"));
        } else {
            userRole.setRole(roleRepository.findFirstByNameRole("User"));
        }
        userRole.setUser(userRepository.save(user));
        userRoleRepository.save(userRole);
        return "created";
    }
}
