package com.rtt.attendance;

import com.rtt.projection.ViewAttendanceProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface StudentAttendanceRepository extends JpaRepository<StudentAttendanceEntity,Long>{
    @Query(value = "SELECT first_name, last_name, student_phoneno, standard_name FROM student WHERE standard_name = :standardName", nativeQuery = true)
    List<Object[]> findStudentsAttendanceByStandardName(@Param("standardName") String standardName);

    @Query("""
    SELECT
        a.id AS attendanceId,
        s.id AS studentId,
        s.firstName AS firstName,
        s.lastName AS lastName,
        s.studentPhoneNo AS studentPhoneNo,
        s.standardName AS standardName,
        a.attendanceMarkedDate AS attendanceMarkedDate,
        a.attendanceAction AS attendanceAction
    FROM AttendanceMarkingEntity a
    JOIN StudentEntity s
        ON a.studentId = s.id
    WHERE a.attendanceMarkedDate BETWEEN :fromDate AND :toDate
      AND (
          :standardName IS NULL
          OR s.standardName = :standardName
      )
      AND (
          :courseId IS NULL
          OR EXISTS (
              SELECT 1
              FROM s.courses c
              WHERE c.id = :courseId
          )
      )
    ORDER BY a.attendanceMarkedDate DESC
""")
    List<ViewAttendanceProjection> findAttendanceForView(
            @Param("fromDate") LocalDate fromDate,
            @Param("toDate") LocalDate toDate,
            @Param("standardName") String standardName,
            @Param("courseId") Long courseId
    );
}
