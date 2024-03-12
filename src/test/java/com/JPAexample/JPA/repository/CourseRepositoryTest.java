package com.JPAexample.JPA.repository;

import com.JPAexample.JPA.entity.Course;
import com.JPAexample.JPA.entity.CourseMaterial;
import com.JPAexample.JPA.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void getCourses(){
        List<Course> courseList = courseRepository.findAll();
        System.out.println(courseList);
    }

    @Test
    public void saveCourse(){
        Teacher t = Teacher.builder()
                .firstName("Mamta")
                .lastName("Batra")
                .build();

        Course c = Course.builder()
                        .title(".Net")
                        .credit(6)
                        .teacher(t)
                        .build();

        courseRepository.save(c);
    }

}