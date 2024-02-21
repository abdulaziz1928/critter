package com.udacity.jdnd.course3.critter.core.domain.user.service;

import com.udacity.jdnd.course3.critter.core.domain.user.common.Customer;

public interface UserService {

    Customer findCustomerById(long id);
}
