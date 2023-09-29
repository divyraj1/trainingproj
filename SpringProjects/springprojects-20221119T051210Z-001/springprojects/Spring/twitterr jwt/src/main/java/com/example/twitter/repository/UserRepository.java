package com.example.twitter.repository;

import com.example.twitter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>
{
    User findByUserid(Long l);
    User findUserByEmail(String email);

}