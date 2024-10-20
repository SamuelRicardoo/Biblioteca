package com.br.biblioteca.service;

import com.br.biblioteca.model.User;
import com.br.biblioteca.repository.AddresUserRepository;
import com.br.biblioteca.repository.UserRepository;
import com.br.biblioteca.repository.UserVerifierExistEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserVerifierExistEmail userVerifierExistEmail;

    @Autowired
    AddresUserRepository addresUserRepository;

    public boolean existEmail(String email) {
        return userVerifierExistEmail.existsByEmail(email);
    }


    public boolean saveUser(User user) {

        if(user.getAddressUser() != null) {
            addresUserRepository.save(user.getAddressUser());
        }

        /*
        if (existEmail(user.getEmail())) {
            return false; // Email already exists
        }
        */

       // user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return true; // User successfully saved
    }


    public List<User> findAll() {
        return userRepository.findAll();
    }


}
