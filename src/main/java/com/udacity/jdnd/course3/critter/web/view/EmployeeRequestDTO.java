package com.udacity.jdnd.course3.critter.web.view;

import com.udacity.jdnd.course3.critter.core.domain.user.common.EmployeeSkillType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

/**
 * Represents a request to find available employees by skills. Does not map
 * to the database directly.
 */
@Getter
@Setter
public class EmployeeRequestDTO {
    private Set<EmployeeSkillType> skills;
    private LocalDate date;

}
