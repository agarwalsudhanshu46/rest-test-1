package com.rest.repository;

import com.rest.model.Employee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("employeeRepository")
public interface EmployeeRepository extends CrudRepository<Employee, Long>, EmployeeRepositoryCustom {
}
