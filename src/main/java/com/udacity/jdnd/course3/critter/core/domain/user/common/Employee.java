package com.udacity.jdnd.course3.critter.core.domain.user.common;

import com.udacity.jdnd.course3.critter.core.domain.schedule.common.Schedule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq", allocationSize = 1)
    private long id;
    private String name;
    @ElementCollection
    private Set<EmployeeSkillType> skills = new HashSet<>();
    @ElementCollection
    private Set<DayOfWeek> daysAvailable = new HashSet<>();
    @ManyToMany(targetEntity = Schedule.class)
    List<Schedule> schedules;
}
