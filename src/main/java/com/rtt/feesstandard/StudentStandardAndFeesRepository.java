package com.rtt.feesstandard;

import com.rtt.student.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentStandardAndFeesRepository extends JpaRepository<StudentStandardAndFeesEntity,Integer> {

    Optional<StudentStandardAndFeesEntity> findByStandardName(String standardName);

}
