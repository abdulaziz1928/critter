package com.udacity.jdnd.course3.critter.web.resource.user;

import com.udacity.jdnd.course3.critter.core.action.user.*;
import com.udacity.jdnd.course3.critter.core.domain.user.common.Customer;
import com.udacity.jdnd.course3.critter.core.domain.user.common.Employee;
import com.udacity.jdnd.course3.critter.web.view.CustomerDTO;
import com.udacity.jdnd.course3.critter.web.view.EmployeeDTO;
import com.udacity.jdnd.course3.critter.web.view.EmployeeRequestDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Users.
 * <p>
 * Includes requests for both customers and employees. Splitting this into separate user and customer controllers
 * would be fine too, though that is not part of the required scope for this class.
 */
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserResource {

    private GetAllCustomersAction getAllCustomersAction;
    private SaveCustomerAction saveCustomerAction;
    private GetOwnerByPetAction getOwnerByPetAction;
    private SaveEmployeeAction saveEmployeeAction;
    private GetEmployeeAction getEmployeeAction;
    private SetAvailabilityAction setAvailabilityAction;
    private FindEmployeesForServiceAction findEmployeesForServiceAction;
    private ModelMapper mapper;

    @PostMapping("/customer")
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer savedCustomer = saveCustomerAction.execute(customerDTO);
        CustomerDTO savedCustomerDTO = mapper.map(savedCustomer, CustomerDTO.class);
        return ResponseEntity.ok(savedCustomerDTO);
    }

    @GetMapping("/customer")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<Customer> customers = getAllCustomersAction.execute();

        List<CustomerDTO> customersDTO = customers.stream()
                .map(customer -> mapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(customersDTO);

    }

    @GetMapping("/customer/pet/{petId}")
    public ResponseEntity<CustomerDTO> getOwnerByPet(@PathVariable long petId) {
        Customer owner = getOwnerByPetAction.execute(petId);
        CustomerDTO ownerDTO = mapper.map(owner, CustomerDTO.class);
        return ResponseEntity.ok(ownerDTO);
    }

    @PostMapping("/employee")
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee savedEmployee = saveEmployeeAction.execute(employeeDTO);
        EmployeeDTO savedEmployeeDTO = mapper.map(savedEmployee, EmployeeDTO.class);
        return ResponseEntity.ok(savedEmployeeDTO);
    }

    @PostMapping("/employee/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable long employeeId) {
        Employee employee = getEmployeeAction.execute(employeeId);
        EmployeeDTO employeeDTO = mapper.map(employee, EmployeeDTO.class);
        return ResponseEntity.ok(employeeDTO);
    }

    @PutMapping("/employee/{employeeId}")
    public ResponseEntity<Void> setAvailability(@RequestBody Set<DayOfWeek> daysAvailable, @PathVariable long employeeId) {
        setAvailabilityAction.execute(daysAvailable, employeeId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/employee/availability")
    public ResponseEntity<Set<EmployeeDTO>> findEmployeesForService(@RequestBody EmployeeRequestDTO employeeDTO) {
        Set<Employee> employees = findEmployeesForServiceAction.execute(employeeDTO);

        Set<EmployeeDTO> employeesDTO = employees.stream()
                .map(customer -> mapper.map(customer, EmployeeDTO.class))
                .collect(Collectors.toSet());
        return ResponseEntity.ok(employeesDTO);

    }

}
