package com.mpholo.learning.employees.models;


import lombok.*;

import javax.persistence.Embeddable;

@Setter
@Getter
@Embeddable
@EqualsAndHashCode(of={"empNo"})
public class EmpNo {

    private Long empNo;

}
