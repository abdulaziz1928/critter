package com.udacity.jdnd.course3.critter.core.domain.user.common;

import com.udacity.jdnd.course3.critter.core.domain.schedule.common.Schedule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ElementCollection(targetClass = EmployeeSkillType.class)
//    @Enumerated(EnumType.STRING)
    @Enumerated(EnumType.STRING)
    private Set<EmployeeSkillType> skills;
    @ElementCollection(targetClass = DayOfWeek.class)
    @Enumerated(EnumType.STRING)
    private Set<DayOfWeek> daysAvailable;

    @ManyToMany(targetEntity = Schedule.class)
    List<Schedule> schedules;


}
