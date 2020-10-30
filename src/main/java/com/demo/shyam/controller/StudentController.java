package com.demo.shyam.controller;

import com.demo.shyam.model.Student;
import com.demo.shyam.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/admin")
    public String printAdmin(){
        return "Hi welcome to student management portal";
    }
    @PostMapping("/addStudent")
    public String addStudent(@RequestParam String firstName, @RequestParam String lastName, @RequestParam long phoneNumber){
        return studentService.addStudent(firstName,lastName,phoneNumber).toString();
    }
    @GetMapping("/getByFirstName")
    public List<Student> findByFirstName(@RequestParam String firstName){
        return (List<Student>) studentService.findAllByFirstName(firstName);
    }
    @GetMapping("/getAll")
    public List<Student> findAllStudents(){
        return (List<Student>)studentService.findAll();
    }
    @PutMapping("/addEmail")
    public Student addEmail(@RequestParam long phoneNumber,@RequestParam String email){
        return studentService.updateStudent(phoneNumber,email);
    }
    @GetMapping("/getByPhoneNumber")
    public Student getByPhoneNumber(@RequestParam long phoneNumber){
        return studentService.findOneByPhoneNumber(phoneNumber);
    }
    @DeleteMapping("/deleteStudentById/{id}")
    public void deleteStudentById(@PathVariable("id") String id){
        studentService.deleteStudentById(id);
    }
    @DeleteMapping("/deleteStudentByPhoneNumber/{phoneNumber}")
    public void deleteStudentByPhoneNumber(@PathVariable("phoneNumber") long phoneNumber){
        studentService.deleteStudentByPhoneNumber(phoneNumber);
    }
}
