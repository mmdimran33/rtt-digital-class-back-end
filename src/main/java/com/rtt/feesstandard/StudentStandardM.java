package com.rtt.feesstandard;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "standard_master")
public class StudentStandardM {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stdm_id")
    private Integer standardId;
    @Column(name = "stdm_name")
    private String standardName;

}
