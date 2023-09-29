package com.example.twitter.repository;

import com.example.twitter.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserRepositoryTest
{   @Autowired
    UserRepository userRepository;
    @Test
    public void saveuser()
    {
        User u=User.builder().name("pawan").email("pawan@gmail.com").build();
        userRepository.save(u);
    }
}