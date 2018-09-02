package com.rest.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeRepositoryCustomImpl implements EmployeeRepositoryCustom {
    //    @PersistenceContext
    //    private EntityManager em;

    @Autowired
    private EntityManager em;

    public EmployeeRepositoryCustomImpl() {
        super();
    }


    @Override
    public void addEmployee(String firstName, String lastName, Integer id) {
        this.em
            .createNamedStoredProcedureQuery("create_employee")
            .setParameter("P_FIRSTNAME", firstName)
            .setParameter("P_LASTNAME", lastName)
            .setParameter("P_ID", id)
            .getResultList();
    }
}
