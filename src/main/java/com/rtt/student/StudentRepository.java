package com.rtt.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {
    // query for fetching total earning from student table
    @Query(value = "SELECT SUM(total_fee_amount) FROM student", nativeQuery = true)
    Float calculateTotalEarningAmount();

    //Fetching Recovered Amount of Students from Student Table
   @Query(value = "select sum(paid_amount) from student",nativeQuery = true)
    Float calculateTotalRecoveredAmount();

    @Query(value = "SELECT COUNT(student_id) FROM student", nativeQuery = true)
    Integer getTotalNumberOfStudents();
    //Fetching Pending Amount of Student from Student Table
    @Query(value = "SELECT SUM(total_fee_amount) - SUM(paid_amount) AS pending_amount FROM student", nativeQuery = true)
    Float calculateTotalPendingAmount();


    @Query(value = "SELECT email_id,address,first_name,last_name,standard_name from student WHERE standard_name=:standardName", nativeQuery = true)
    List<Object[]> findStandardListByStandardWise(@Param("standardName") String standardName);
}
