package com.mpholo.learning.employees.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.time.LocalDate;

@Setter
@Getter
@ToString
@Embeddable
public  class  Period {
    private LocalDate fromDate;
    private LocalDate toDate;

}
