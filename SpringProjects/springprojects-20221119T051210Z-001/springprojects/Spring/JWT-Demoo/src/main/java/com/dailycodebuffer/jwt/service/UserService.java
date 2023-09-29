package com.dailycodebuffer.jwt.service;

import com.dailycodebuffer.jwt.UserPrincipal;
import com.dailycodebuffer.jwt.model.User;
import com.dailycodebuffer.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository repo;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        //Logic to get the user form the Database
        User user = repo.findByUsername(userName);
        if(user==null)
            throw new UsernameNotFoundException("User 404");

        return new UserPrincipal(user);
      //  return new User("admin","password",new ArrayList<>());
        //third parameter is empty as a user can have multiple roles
    }
}
