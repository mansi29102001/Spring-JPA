package com.JPAexample.JPA.repository;

import com.JPAexample.JPA.entity.Course;
import com.JPAexample.JPA.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course c1 = Course.builder()
                .title("Java")
                .credit(10)
                .build();

        Course c2 = Course.builder()
                .title("Science")
                .credit(5)
                .build();

        Teacher t = Teacher.builder()
                        .firstName("Rita")
                        .lastName("Sharma")
                        //.courses(List.of(c1,c2))
                        .build();

        teacherRepository.save(t);
    }
}