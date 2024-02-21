package com.udacity.jdnd.course3.critter.core.action.user;

import com.udacity.jdnd.course3.critter.core.domain.user.common.Customer;
import com.udacity.jdnd.course3.critter.web.view.CustomerDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SaveCustomerAction {


    public Customer execute(CustomerDTO customerDTO){
        return null;
    }
}
