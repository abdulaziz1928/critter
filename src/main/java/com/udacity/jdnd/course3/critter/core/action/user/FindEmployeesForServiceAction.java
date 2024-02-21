package com.udacity.jdnd.course3.critter.core.action.user;

import com.udacity.jdnd.course3.critter.core.domain.user.common.Employee;
import com.udacity.jdnd.course3.critter.web.view.EmployeeRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class FindEmployeesForServiceAction {

    public List<Employee> execute(EmployeeRequestDTO employeeDTO){
        return null;
    }
}
