package kg.itacademy.springlearn.service.impl;

import kg.itacademy.springlearn.Entity.User;
import kg.itacademy.springlearn.model.UserCustom;
import kg.itacademy.springlearn.repository.UserRepository;
import kg.itacademy.springlearn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired

    private UserRepository userRepository;

    @Override
    public void createNewUser(UserCustom userCustom) {

        if (userCustom != null) {
            if (userCustom.getPassword().equals(userCustom.getPassword())) {
                User user = new User();
                user.setLogin(userCustom.getLogin());
                user.setPassword(userCustom.getPassword());
                user.setEmail(userCustom.getEmail());
                userRepository.save(user);


            }
        }
    }
    @Override
    public User getUser(Integer Id) {
        return userRepository.findById(Id).get();
    }
}
