package com.udacity.jdnd.course3.critter.core.action.user;

import com.udacity.jdnd.course3.critter.core.domain.user.common.Employee;
import com.udacity.jdnd.course3.critter.web.view.EmployeeDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SaveEmployeeAction {

    public Employee execute(EmployeeDTO employeeDTO){
        return null;
    }
}
