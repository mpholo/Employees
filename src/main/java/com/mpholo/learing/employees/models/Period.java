package com.mpholo.learing.employees.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public abstract class  Period {
    private LocalDate fromDate;
    private LocalDate toDate;

}
