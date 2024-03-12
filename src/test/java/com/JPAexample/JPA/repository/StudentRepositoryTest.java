package com.JPAexample.JPA.repository;

import com.JPAexample.JPA.entity.Guardian;
import com.JPAexample.JPA.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudentDeatils(){
        Student s = Student.builder()
                .emailId("ram89@gmail.com")
                .firstName("Ram")
                .lastName("Sharma")
//                .guardianName("Nikhil")
//                .guardianMobile("99999999999")
//                .guardianEmail("nikhil12@gmail.com")
                .build();
        studentRepository.save(s);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian g = Guardian.builder()
                .email("mehta@gmail.com")
                .name("Shivam")
                .mobile("9756874357")
                .build();

        Student s = Student.builder()
                .firstName("Sonali")
                .lastName("Verma")
                .emailId("sonali@gmail.com")
                .guardian(g)
                .build();

        studentRepository.save(s);
    }

    @Test
    public void getStudent(){
        List<Student> list = studentRepository.findAll();
        System.out.println("Student list:"+ list);
    }

    @Test
    public void studentListByName(){
        List<Student> name = studentRepository.findByFirstName("Sonali");
        System.out.println("Student list = "+ name);
    }

    @Test
    public void studentContainingChar(){
        List<Student> list = studentRepository.findByFirstNameContaining("am");
        System.out.println("List = "+ list);
    }

    @Test
    public void studentGuardianName(){
        List<Student> list = studentRepository.findByGuardianName("Shivam");
        System.out.println("Student with guardian Shivam = " + list );
    }

    @Test
    public void getStudentByLastname(){
        List<Student> list = studentRepository.findByLastNameNotNull();
        System.out.println(list);
    }

    @Test
    public void getStudentByEmailAddress(){
        Student s = studentRepository.getStudentByEmailAddress("ram89@gmail.com");
        System.out.println("student = " + s);
    }

    @Test
    public void getStudentByEmailAddressNative(){
        Student s = studentRepository.findStudentByEmailAddress("ram89@gmail.com");
        System.out.println("student = " + s);
    }

    @Test
    public void getStudentByEmailAddressNativeParam(){
        Student s = studentRepository.findStudentByEmailAddressNativeParam("ram89@gmail.com");
        System.out.println("student = " + s);
    }

    @Test
    public void updateStudentName(){
        studentRepository.updateStudentFirstName("Ramesh","ram89@gmail.com");
    }
}