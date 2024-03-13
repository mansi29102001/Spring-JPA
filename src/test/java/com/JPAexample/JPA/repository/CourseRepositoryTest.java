package com.JPAexample.JPA.repository;

import com.JPAexample.JPA.entity.Course;
import com.JPAexample.JPA.entity.CourseMaterial;
import com.JPAexample.JPA.entity.Student;
import com.JPAexample.JPA.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

    //pagination
    @Test
    public void findAllPagination(){
        Pageable firstPage = PageRequest.of(0,3);
        Pageable secondPage = PageRequest.of(1,2);

        Long totalElements = courseRepository.findAll(firstPage).getTotalElements();

        int totalPage = courseRepository.findAll(firstPage).getTotalPages();

        List<Course> list = courseRepository.findAll(firstPage).getContent();
        System.out.println("List of courses = " + list);
        System.out.println(totalPage);
        System.out.println(totalElements);
    }

    //pagination with sorting
    @Test
    public void findAllBySorting(){
        Pageable sortByTitle = PageRequest.of(
                0,
                3,
                Sort.by("title")
        );

        Pageable sortByTitleCreditDesc = PageRequest.of(
                0,4,
                Sort.by("title").descending()
                        .and(Sort.by("credit"))
        );

        List<Course> courses = courseRepository.findAll(sortByTitleCreditDesc).getContent();
        System.out.println("Course = " + courses);
    }

    @Test
    public void saveCourseWithStudentTeacher(){
        Teacher t = Teacher.builder()
                .firstName("Poonam")
                .lastName("Sharma")
                .build();

        Student s = Student.builder()
                .firstName("Sarvesh")
                .lastName("Verma")
                .emailId("sarvesh@gmail.com")
                .build();

        Course course = Course.builder()
                .title("Maths")
                .credit(5)
                .teacher(t)
                .build();

        course.addStudents(s);
    }

}