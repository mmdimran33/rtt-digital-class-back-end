package com.rtt.feesdetails;

import com.rtt.course.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeesManagementItemResponse {

    private Long id;
    private Long studentId;
    private String firstName;
    private String paidPersonName;
    private String standardName;
    private String email;
    private String studentPhoneNo;
    private Float totalFeeAmount;
    private String paymentMethod;
    private Float paidAmount;
    private Float balanceAmount;
    private LocalDate updatedDate;

    private List<Course> courses;
}
