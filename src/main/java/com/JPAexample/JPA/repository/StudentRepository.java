package com.JPAexample.JPA.repository;

import com.JPAexample.JPA.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    //JPQL query
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    //Native sql query
    @Query(
            value = "select * from tbl_student s where s.student_email = ?1",
            nativeQuery = true
    )
    Student findStudentByEmailAddress(String emailId);

    @Query(
            value = "select * from tbl_student s where s.student_email = :emailId",
            nativeQuery = true
    )
    Student findStudentByEmailAddressNativeParam(@Param("emailId") String emailId);

    //update query
    @Modifying
    @Transactional
    @Query(
            value = "update tbl_Student set student_first_name = ?1 where student_email = ?2",
            nativeQuery = true
    )
    int updateStudentFirstName(String firstName, String emailId);

}
