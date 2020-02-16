package com.mpholo.learning.employees.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="titles")
public class Title implements Serializable {

   @EmbeddedId
   private TitleId titleId;

   private LocalDate toDate;

    @ManyToOne(fetch=FetchType.EAGER)
    @MapsId("emp_no")
    @JoinColumn(name="empNo")
    private Employee employee;




}
