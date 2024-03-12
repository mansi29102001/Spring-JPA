package com.JPAexample.JPA.repository;

import com.JPAexample.JPA.entity.Course;
import com.JPAexample.JPA.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course c = Course.builder()
                .title("DSA")
                .credit(6)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                        .url("www.google.com")
                        .course(c)
                        .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void fetchCourseMaterial(){
        List<CourseMaterial> list = courseMaterialRepository.findAll();
        System.out.println(list);
    }
}