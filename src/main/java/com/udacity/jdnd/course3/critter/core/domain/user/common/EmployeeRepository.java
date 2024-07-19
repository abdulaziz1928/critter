package com.udacity.jdnd.course3.critter.core.domain.user.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT DISTINCT e FROM Employee e JOIN e.skills s WHERE :day MEMBER OF e.daysAvailable AND s IN :skills")
    List<Employee> findDistinctEmployeesByDaysAvailableAndSkillsIn(@Param("day") DayOfWeek day, @Param("skills") Set<EmployeeSkillType> skills);
}
