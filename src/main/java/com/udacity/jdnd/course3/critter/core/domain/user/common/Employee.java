package com.udacity.jdnd.course3.critter.core.domain.user.common;

import com.udacity.jdnd.course3.critter.core.domain.schedule.common.Schedule;
import lombok.Data;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ElementCollection
    private Set<EmployeeSkillType> skills;
    @ElementCollection
    private Set<DayOfWeek> daysAvailable;

    @ManyToMany
    List<Schedule> schedules;

}
