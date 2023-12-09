package com.insha.Bookmyshow.services;

import com.insha.Bookmyshow.Model.User;
import com.insha.Bookmyshow.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signUp(String Email, String Password){
        Optional<User> userOptional = userRepository.findByEmail(Email);
        if(userOptional.isPresent()){
            throw new RuntimeException();
        }
        User user = new User();
        user.setEmail(Email);
        user.setPassword(Password);

        User savedUser = userRepository.save(user);
        return user;
    }

}
