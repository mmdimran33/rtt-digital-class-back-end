package com.rtt.attendance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentAttendanceRepository extends JpaRepository<StudentAttendanceEntity,Integer>{
    @Query(value = "SELECT first_name, last_name, student_phoneno, standard_name FROM student WHERE standard_name = :standardName", nativeQuery = true)
    List<Object[]> findStudentsAttendanceByStandardName(@Param("standardName") String standardName);

    /*@Query(value = "SELECT DISTINCT s.* FROM attendance_marking s " +
            "JOIN attendance a ON s.id = a.student_id",
            nativeQuery = true)
    List<AttendanceMarkingEntity> findAllStudentsWithAttendance();*/
}
