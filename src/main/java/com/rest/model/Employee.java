package com.rest.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
@SuppressWarnings({ "serial", "oracle.jdeveloper.java.annotation-callback" })
@NamedStoredProcedureQueries({ @NamedStoredProcedureQuery(name = "create_employee",
                                                          procedureName = "XXSTC_TEST.create_employee",
                                                          parameters =
                                                          { @StoredProcedureParameter(mode = ParameterMode.IN,
                                                                                      name = "P_FIRSTNAME",
                                                                                      type = String.class),
                                                            @StoredProcedureParameter(mode = ParameterMode.IN,
                                                                                      name = "P_LASTNAME",
                                                                                      type = String.class),
                                                            @StoredProcedureParameter(mode = ParameterMode.IN,
                                                                                      name = "P_ID",
                                                                                      type = Integer.class) })
    })
public class Employee implements Serializable {
    @SuppressWarnings("compatibility:-6167466140586647914")
    private static final long serialVersionUID = -4850364695406054729L;


    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;


    public Employee(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee() {
        super();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }
}
