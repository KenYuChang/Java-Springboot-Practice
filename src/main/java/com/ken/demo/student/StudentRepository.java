package com.ken.demo.student;

import com.ken.demo.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByFirstnameContaining(String p);
}
