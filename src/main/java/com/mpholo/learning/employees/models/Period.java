package com.mpholo.learning.employees.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.time.LocalDate;

@Setter
@Getter
@Embeddable
public  class  Period {
    private LocalDate fromDate;
    private LocalDate toDate;

}
