package com.rtt.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class StudentListResponse {
    private static final long serialVersionUID=1L;
    @JsonProperty("get-standard-list-by-standard-wise")
    private List<Object[]> StandardList;

}
