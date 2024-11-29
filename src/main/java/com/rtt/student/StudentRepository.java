package com.rtt.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {

    @Query(value = "SELECT COUNT(student_id) FROM student", nativeQuery = true)
    Integer getTotalNumberOfStudents();

}
