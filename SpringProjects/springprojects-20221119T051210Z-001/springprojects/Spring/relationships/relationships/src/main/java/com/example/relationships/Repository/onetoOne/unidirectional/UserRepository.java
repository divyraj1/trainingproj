package com.example.relationships.Repository.onetoOne.unidirectional;

import com.example.relationships.model.onetoOne.unidirectional.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long>
{
    @Override
    List<User> findAll();

}
