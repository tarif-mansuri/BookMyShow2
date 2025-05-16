package com.tarif.BookMyShow2.services;

import com.tarif.BookMyShow2.models.User;
import com.tarif.BookMyShow2.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    public User getUser(Long id){
         Optional<User> optionalUser = userRepository.findById(id);
         if(optionalUser.isPresent()){
             return optionalUser.get();
         }else{
             return null;
         }
    }

    public User signUp(String email, String password, String name) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setName(name);
        userRepository.save(user);
        return user;
    }
}
