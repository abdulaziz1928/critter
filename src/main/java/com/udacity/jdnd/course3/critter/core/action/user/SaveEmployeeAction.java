package com.udacity.jdnd.course3.critter.core.action.user;

import com.udacity.jdnd.course3.critter.core.domain.user.common.Employee;
import com.udacity.jdnd.course3.critter.core.domain.user.service.UserService;
import com.udacity.jdnd.course3.critter.web.view.EmployeeDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SaveEmployeeAction {
    private final UserService userService;
    private final ModelMapper mapper;

    public Employee execute(EmployeeDTO employeeDTO) {
        var employee = mapper.map(employeeDTO, Employee.class);
        return userService.saveEmployee(employee);
    }
}
