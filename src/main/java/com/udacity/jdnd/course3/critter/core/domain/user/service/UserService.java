package com.udacity.jdnd.course3.critter.core.domain.user.service;

import com.udacity.jdnd.course3.critter.core.domain.user.common.Customer;
import com.udacity.jdnd.course3.critter.core.domain.user.common.Employee;
import com.udacity.jdnd.course3.critter.core.domain.user.common.EmployeeSkillType;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;


public interface UserService {
    List<Customer> findAllCustomers();

    Customer findCustomerById(long id);

    Customer saveCustomer(Customer customer);
    List<Employee> findEmployeesForService(DayOfWeek date, Set<EmployeeSkillType> skills);
    Employee findEmployeeById(long id);
    Employee saveEmployee(Employee employee);

}
