package com.mpholo.learning.employees.models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Setter
@Getter
@EqualsAndHashCode(of={"fromDate"})
@Embeddable
public class FromDate {

    private LocalDate fromDate;

}
