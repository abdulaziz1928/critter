package com.udacity.jdnd.course3.critter.core.domain.user.service;

import com.udacity.jdnd.course3.critter.core.domain.user.exception.CustomerNotFoundException;
import com.udacity.jdnd.course3.critter.core.domain.user.common.*;
import com.udacity.jdnd.course3.critter.core.domain.user.exception.EmployeeNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public Customer findCustomerById(long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return this.customerRepository.save(customer);
    }

    public List<Employee> findEmployeesForService(DayOfWeek date, Set<EmployeeSkillType> skills){
        return this.employeeRepository.findDistinctEmployeesByDaysAvailableAndSkillsIn(date, skills);
    }

    @Override
    public Employee findEmployeeById(long id) {
        return this.employeeRepository.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException(id));
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }
}
