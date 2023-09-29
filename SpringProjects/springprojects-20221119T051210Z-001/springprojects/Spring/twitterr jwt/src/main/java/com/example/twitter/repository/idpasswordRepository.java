package com.example.twitter.repository;

import com.example.twitter.entity.idpassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface idpasswordRepository extends JpaRepository<idpassword,Long>
{
}
