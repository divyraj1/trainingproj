package com.example.relationships;

import com.example.relationships.Repository.onetoOne.unidirectional.AddressRepository;
import com.example.relationships.Repository.onetoOne.unidirectional.UserRepository;
import com.example.relationships.model.onetoOne.unidirectional.Address;
import com.example.relationships.model.onetoOne.unidirectional.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class RelationshipsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RelationshipsApplication.class, args);





	}

}
