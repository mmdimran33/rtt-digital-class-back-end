package com.rtt.attendance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentAttendanceMarkingRepository extends JpaRepository<AttendanceMarkingEntity,Integer> {
}
