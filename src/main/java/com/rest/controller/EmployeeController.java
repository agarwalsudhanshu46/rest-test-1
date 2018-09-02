package com.rest.controller;

import com.rest.model.Employee;
import com.rest.service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired(required = true)
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public HttpEntity<String> register(@Validated @RequestBody Employee employee, BindingResult bindings) {
        if (bindings.hasErrors()) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }

        if ("okay".equals(employeeService.register(employee))) {
            return new ResponseEntity("The insertion is succesfull ", HttpStatus.CREATED);
        }
        return new ResponseEntity("The insertion is unsuccesfull ", HttpStatus.NOT_IMPLEMENTED);


    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> list() {
        return employeeService.list();
    }
}
