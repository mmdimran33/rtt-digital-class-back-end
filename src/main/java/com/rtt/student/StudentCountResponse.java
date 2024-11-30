package com.rtt.student;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentCountResponse {
    private static final long serialVersionUID=1L;
    @JsonProperty("total_number_of_students")
    private Integer totalNoOfStudents;



}
