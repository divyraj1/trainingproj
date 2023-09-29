package com.example.relationships.Repository.onetoOne.unidirectional;

import com.example.relationships.model.onetoOne.unidirectional.Address;
import com.example.relationships.model.onetoOne.unidirectional.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>
{

}
