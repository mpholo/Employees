package com.mpholo.learning.employees.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@Embeddable
@EqualsAndHashCode(of={"empNo","fromDate"})
@AllArgsConstructor
@NoArgsConstructor
public class SalaryId implements Serializable {


    @Column(name="emp_no")
    private Long emp_no;
    @Column(name="from_date",insertable = true,updatable = true)
    private LocalDate fromDate;
}
