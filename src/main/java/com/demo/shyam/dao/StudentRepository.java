package com.demo.shyam.dao;

import com.demo.shyam.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student,String> {
    List<Student> findAllByFirstName(String firstName);
    List<Student> findByLastName(String lastName);
    Student findOneByPhoneNumber(long phoneNumber);
    boolean deleteStudentByPhoneNumber(long phoneNumber);
}
