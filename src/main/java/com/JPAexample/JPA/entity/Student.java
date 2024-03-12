package com.JPAexample.JPA.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(
                name = "unique_studentEmail",
                columnNames = "student_email"
        )
)
public class Student {

    @Column(name = "student_id")
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;

    @Column(name = "student_firstName")
    private String firstName;

    @Column(name = "student_lastName")
    private String lastName;

    @Column(
            name = "student_email",
            nullable = false
    )
    private String emailId;

    @Embedded
    private Guardian guardian;
}
