package com.udacity.jdnd.course3.critter.core.action.user;

import com.udacity.jdnd.course3.critter.core.domain.user.common.Customer;
import com.udacity.jdnd.course3.critter.core.domain.user.service.UserService;
import com.udacity.jdnd.course3.critter.web.view.CustomerDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SaveCustomerAction {

    private final ModelMapper mapper;
    private final UserService userService;

    public Customer execute(CustomerDTO customerDTO) {
        var customer = mapper.map(customerDTO, Customer.class);
        return userService.saveCustomer(customer);
    }
}
