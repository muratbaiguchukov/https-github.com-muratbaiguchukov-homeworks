package kg.example6.country.service.impl;

import kg.example6.country.entity.User;
import kg.example6.country.entity.UserRole;
import kg.example6.country.exception.UserSignInException;
import kg.example6.country.model.UserAuthModel;
import kg.example6.country.model.UserModel;
import kg.example6.country.repository.RoleRepository;
import kg.example6.country.repository.UserRepository;
import kg.example6.country.repository.UserRoleRepository;
import kg.example6.country.service.UserService;
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
        //Маппинг user
        user.setLogin(userModel.getLogin());
        user.setEmail(userModel.getEmail());
        //
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        user.setIsActive(true);

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
