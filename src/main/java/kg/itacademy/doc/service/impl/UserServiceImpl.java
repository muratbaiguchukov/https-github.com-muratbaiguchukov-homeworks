package kg.itacademy.doc.service.impl;

import kg.itacademy.doc.entity.User;
import kg.itacademy.doc.entity.UserRole;
import kg.itacademy.doc.exceptions.UserSignInException;
import kg.itacademy.doc.model.UserAuthModel;
import kg.itacademy.doc.model.UserModel;
import kg.itacademy.doc.repository.RoleRepository;
import kg.itacademy.doc.repository.UserRepository;
import kg.itacademy.doc.repository.UserRoleRepository;
import kg.itacademy.doc.service.UserService;
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
        if (user == null) {
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
        //Маппинг user
        user.setLogin(userModel.getLogin());
        user.setEmail(userModel.getEmail());
        //
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        user.setIsActive(true);

        UserRole userRole = new UserRole();
        if (userModel.getLogin().contains("admin")) {
            userRole.setRole(roleRepository.findFirstByNameRole("ROLE_Admin"));
        } else {
            userRole.setRole(roleRepository.findFirstByNameRole("ROLE_User"));
        }
        userRole.setUser(userRepository.save(user));
        userRoleRepository.save(userRole);
        return "created";
    }

}


