package com.rtt.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {
    // query for fetching total earning from student table
    @Query(value = "SELECT SUM(total_fee_amount) FROM student", nativeQuery = true)
    Float calculateTotalEarningAmount();



}
