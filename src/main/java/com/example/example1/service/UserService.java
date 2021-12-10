package com.example.example1.service;

import com.example.example1.model.Role;
import com.example.example1.model.User;
import com.example.example1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public PasswordEncoder passwordEncoder1(){
        return new BCryptPasswordEncoder();
    }

//    @Autowired
//    public PasswordEncoder passwordEncoder;

    public User save(User user){
//       String encodedPassword = passwordEncoder1().encode(user.getPassword());
        String encodedPassword = passwordEncoder1().encode(user.getPassword());
       user.setPassword(encodedPassword);
       user.setEnabled(true);
       Role role = new Role();
       role.setId(1l);
       user.getRoles().add(role);
       return userRepository.save(user);
    }


}
