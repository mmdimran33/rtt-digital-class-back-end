package com.rtt.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {
    //Fetching Recovered Amount of Students from Student Table
   @Query(value = "select sum(paid_amount) from student",nativeQuery = true)
    Float calculateTotalRecoveredAmount();

}
