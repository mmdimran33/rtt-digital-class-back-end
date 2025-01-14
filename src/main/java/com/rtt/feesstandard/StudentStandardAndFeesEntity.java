package com.rtt.feesstandard;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="fee")
public class StudentStandardAndFeesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer feeId;
    @Column(name="fee_amount")
    private Double feeAmount;
    @Column(name="standard_name")
    private String standardName;
}
