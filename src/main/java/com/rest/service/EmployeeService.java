package com.rest.service;

import com.rest.model.Employee;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

public interface EmployeeService {
	String register(@NotNull @Validated Employee employee);
	List<Employee> list();
}
