package com.rtt.feesstandard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentStandardMRepository extends JpaRepository<StudentStandardM ,Integer> {
    @Query(value="select stdm_name,stdm_id from standard_master" , nativeQuery = true)
    List<Object[]> getStandardNameList();


    @Query(value = "SELECT DISTINCT stdm_name FROM standard_master WHERE stdm_name IS NOT NULL", nativeQuery = true)
    List<String> getStandardNameOfList();


}
