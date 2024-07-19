package com.udacity.jdnd.course3.critter.core.action.user;

import com.udacity.jdnd.course3.critter.core.domain.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.util.Set;

@Component
@AllArgsConstructor
public class SetAvailabilityAction {
    private final UserService userService;

    public void execute(Set<DayOfWeek> daysAvailable, long employeeId) {
        var employee = userService.findEmployeeById(employeeId);
        employee.setDaysAvailable(daysAvailable);
        userService.saveEmployee(employee);
    }
}
