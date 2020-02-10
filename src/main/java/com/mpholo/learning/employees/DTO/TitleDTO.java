package com.mpholo.learning.employees.DTO;

import com.mpholo.learning.employees.models.BaseEntity;
import com.mpholo.learning.employees.models.Employee;
import com.mpholo.learning.employees.models.Period;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TitleDTO extends BaseEntity  {

    private String title;
    @Embedded
    private Period period;

    private Employee employee;

}
