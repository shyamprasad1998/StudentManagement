package com.demo.shyam.service;

import com.demo.shyam.dao.StudentRepository;
import com.demo.shyam.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    //addStudent
    public Student addStudent(String firstName, String lastName, long phoneNumber){
        Student temp = new Student(firstName, lastName, phoneNumber);
        studentRepository.save(temp);
        return  temp;
    }

    //Read Student by first name
    public List<Student> findAllByFirstName(String firstName) {
        return (List<Student>) studentRepository.findAllByFirstName(firstName);
    }

    //Get details of all students
    public List<Student> findAll() {
        return (List<Student>) studentRepository.findAll();
    }

    //Find a student given phone number
    public Student findOneByPhoneNumber(long phoneNumber) {
        return studentRepository.findOneByPhoneNumber(phoneNumber);
    }

    //Update student
    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    //Delete a student by given id
    public void deleteStudentById(String id) {
        studentRepository.deleteById(id);
    }

    //Delete a student by given phone number
    public boolean deleteStudentByPhoneNumber(long phoneNumber){
        return studentRepository.deleteStudentByPhoneNumber(phoneNumber);
    }

    //update student email
    public Student updateStudent(long phoneNumber, String email) {
        Student temp=studentRepository.findOneByPhoneNumber(phoneNumber);
        temp.setEmail(email);
        return updateStudent(temp);
    }
}
