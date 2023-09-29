package com.example.relationships.Repository.onetoOne.unidirectional;

import com.example.relationships.model.onetoOne.unidirectional.Address;
import com.example.relationships.model.onetoOne.unidirectional.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserRepositoryTest
{
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    UserRepository userRepository;
    @Test
    public void save()
    {

        //	OneToOne Unidirectional
        Address firstAddress = Address.builder().street("Home st").build();
        User firstUser = User.builder().name("john doe").address(firstAddress).build();
        System.out.println(firstAddress+" ");
        System.out.print(firstUser+" ");
        addressRepository.save(firstAddress);
        firstUser.setAddress(firstAddress);
        userRepository.save(firstUser);
       // System.out.print(userRepository.findAll());

    }
    @Test
    public void join()
    {
        List<User>u=userRepository.findAll();
        System.out.println(u.get(0).getAddress().getStreet());
    }

}
