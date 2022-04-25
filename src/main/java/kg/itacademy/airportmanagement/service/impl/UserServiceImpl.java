package kg.itacademy.airportmanagement.service.impl;

import kg.itacademy.airportmanagement.repository.UserRepository;
import kg.itacademy.airportmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

}
