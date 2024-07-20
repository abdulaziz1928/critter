package com.udacity.jdnd.course3.critter.core.action.user;

import com.udacity.jdnd.course3.critter.core.domain.user.common.Employee;
import com.udacity.jdnd.course3.critter.core.domain.user.service.UserService;
import com.udacity.jdnd.course3.critter.web.view.EmployeeRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@AllArgsConstructor
public class FindEmployeesForServiceAction {
    private final UserService userService;

    public Set<Employee> execute(EmployeeRequestDTO employeeDTO) {
        return userService.findEmployeesForService(employeeDTO.getDate().getDayOfWeek(), employeeDTO.getSkills());
    }
}
