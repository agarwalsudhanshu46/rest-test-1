package com.rest.service;

import com.rest.model.Employee;
import com.rest.repository.EmployeeRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service("employeeService")
@Validated
@Transactional(readOnly = true)
public class JpaEmployeeService implements EmployeeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(JpaEmployeeService.class);

    @Autowired(required = true)
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public String register(Employee employee) {
        String status = "okay";
        LOGGER.info("Register person with name '{}", employee.getFirstName() + employee.getLastName());
        try {
            employeeRepository.addEmployee(employee.getFirstName(), employee.getLastName(), employee.getId());
        } catch (Exception e) {
            status = "bad";
        }
        return status;
    }


    @Override
    public List<Employee> list() {
        return (List<Employee>) employeeRepository.findAll();
    }
}
