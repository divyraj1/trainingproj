package com.example.twitter.repository;

import com.example.twitter.entity.User;
import com.example.twitter.entity.idpassword;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserRepositoryTest
{   @Autowired
    UserRepository userRepository;
    @Autowired
    idpasswordRepository idpasswordRepository;
    @Test
    public void saveuser()
    {
        idpassword password=idpassword.builder().Password("1234").build();
        idpasswordRepository.save(password);
        User u=User.builder().name("pawan").email("pawan@gmail.com").idpassword(password).build();
        userRepository.save(u);
    }
    @Test
    public void find()
    {
         System.out.println(userRepository.findUserByEmail("pawan@gmail.com"));
        // System.out.println(userRepository.findAll());
    }
}