package com.udacity.jdnd.course3.critter.core.domain.user.service;

import com.udacity.jdnd.course3.critter.core.domain.user.common.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{


    @Override
    public Customer findCustomerById(long id) {
        return null;
    }
}
