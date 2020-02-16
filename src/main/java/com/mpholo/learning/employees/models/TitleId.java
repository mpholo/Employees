package com.mpholo.learning.employees.models;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;

@Setter
@Getter
@Embeddable
@EqualsAndHashCode(of={"empNo","fromDate","title"})
@AllArgsConstructor
@NoArgsConstructor
public class TitleId implements Serializable {

    @Embedded
    private EmpNo empNo;
    @Embedded
    private FromDate fromDate;
    private String title;



}
