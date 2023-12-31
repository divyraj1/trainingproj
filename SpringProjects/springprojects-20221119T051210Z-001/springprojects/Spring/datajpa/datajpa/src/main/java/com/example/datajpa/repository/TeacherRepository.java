package com.example.datajpa.repository;

import com.example.datajpa.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long>
{
    Teacher findById(long i);
}
