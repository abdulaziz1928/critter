package com.udacity.jdnd.course3.critter.core.action.user;

import com.udacity.jdnd.course3.critter.core.domain.user.common.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetAllCustomersAction {


    public List<Customer> execute(){
        return null;
    }
}
