package com.rtt.feesdetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeesManagementRepository extends JpaRepository<FeesManagementEntity,Long> {

//    @Query(value = "SELECT balance_amount,discount_in_percentages,email_id,first_name,paid_amount,payment_method,standard_name,student_id,student_phoneno,total_fee_amount " +
//            " from fees_details", nativeQuery = true)
//    List<Object[]> getFeesManagementList();

}
