package com.udacity.jdnd.course3.critter.core.domain.user.service;

import com.udacity.jdnd.course3.critter.core.domain.user.exception.CustomerNotFoundException;
import com.udacity.jdnd.course3.critter.core.domain.user.common.*;
import com.udacity.jdnd.course3.critter.core.domain.user.exception.EmployeeNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
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

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Transactional
    @Override
    public Customer saveCustomer(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public Set<Employee> findEmployeesForService(DayOfWeek date, Set<EmployeeSkillType> skills) {
        Set<Employee> availableEmployees = employeeRepository.findEmployeesByDaysAvailable(date);
        return availableEmployees.stream().filter(employee ->
                employee.getSkills().containsAll(skills)
        ).collect(Collectors.toSet());
    }

    @Override
    public Employee findEmployeeById(long id) {
        return this.employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }
}
