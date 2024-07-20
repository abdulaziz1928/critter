package com.udacity.jdnd.course3.critter.core.domain.schedule.common;

import com.udacity.jdnd.course3.critter.core.domain.pet.common.Pet;
import com.udacity.jdnd.course3.critter.core.domain.user.common.Employee;
import com.udacity.jdnd.course3.critter.core.domain.user.common.EmployeeSkillType;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
@Entity
@Data
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "schedule_seq")
    @SequenceGenerator(name = "schedule_seq", sequenceName = "schedule_seq", allocationSize = 1)
    private long id;
    @ManyToMany(targetEntity = Employee.class)
    private Set<Employee> employees;
    @ManyToMany(targetEntity = Pet.class)
    Set<Pet> pets;
    private LocalDate date;
    @ElementCollection
    private Set<EmployeeSkillType> activities;
}
