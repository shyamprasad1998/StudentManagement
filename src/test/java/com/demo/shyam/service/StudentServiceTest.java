package com.demo.shyam.service;

import com.demo.shyam.dao.StudentRepository;
import com.demo.shyam.model.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void addStudent() {
        Student temp=new Student("shyam","prasad",9340538008l);
        assertEquals(temp,studentService.addStudent("shyam","prasad",9340538008l));
    }

    @Test
    void findAllByFirstName(){
        List<Student> students= studentService.findAllByFirstName("shyam");
        boolean flag=true;
        for(int i=0;i<students.size();i++){
            if(!students.get(i).getFirstName().equals("shyam")){
                flag=false;
            }
        }
        assertTrue(flag);
    }

    @Test
    void findAll() {
        List<Student> students=new ArrayList<Student>();
        students.add(new Student("shyam","prasad",9340538003l));
        students.add(new Student("porika","sreeja",9340538004l));
        students.add(new Student("kss","karthik",9340538005l));
        when(studentRepository.findAll()).thenReturn(students);
        List<Student> temp=studentService.findAll();
        assertEquals(3,temp.size());
    }

    @Test
    void findByPhoneNumber() {
        //Student temp=studentService.addStudent("porika","sreeja",9340538004l);
        //Student student=studentService.findOneByPhoneNumber(9340538004l);
        //assertNull(student);
        //Student temp=new Student("porika","sreeja",9340538004l);
        when(studentRepository.findOneByPhoneNumber(9340538003l)).thenReturn(new Student("shyam","prasad",9340538003l));
        Student student=studentService.findOneByPhoneNumber(9340538003l);
        Student temp=new Student("shyam","prasad",9340538003l);
        assertEquals(temp, student);
        assertEquals(temp, student);
    }

    @Test
    void updateStudent() {
        Student temp=new Student("shyam","prasad",9340538003l);
        temp.setEmail("shyamrao87905@gmail.com");
        when(studentRepository.findOneByPhoneNumber(9340538003l)).thenReturn(temp);
        when(studentRepository.save(temp)).thenReturn(temp);
        Student student=studentService.updateStudent(9340538003l,"shyamrao87905@gmail.com");
        assertEquals(student.getEmail(),temp.getEmail());
    }

    @Test
    void deleteStudentByPhoneNumber() {
        when(studentRepository.deleteStudentByPhoneNumber(9340538003l)).thenReturn(true);
        boolean flag=studentService.deleteStudentByPhoneNumber(9340538003l);
        assertTrue(flag);
    }
}