package com.rtt.feesstandard;

import com.rtt.student.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentStandardAndFeesRepository extends JpaRepository<StudentStandardAndFeesEntity,Integer> {

    Optional<StudentStandardAndFeesEntity> findByStandardName(String standardName);

//Fresh Changes
    @Query("SELECT s.feeAmount FROM StudentStandardAndFeesEntity s WHERE s.standardName = :standardName")
    BigDecimal findFeesAmountByStandardName(@Param("standardName") String standardName);


}
