package com.rest;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.context.annotation.Configuration;


@Configuration
public class CdiConfig {
    @Produces  
    @Dependent  
    @PersistenceUnit  
    private EntityManagerFactory entityManagerFactory;  


    @Produces  
    @Dependent  
    public EntityManager createEntityManager(EntityManagerFactory emf) {  
        return emf.createEntityManager();  
    }  
    
    public void close(@Disposes EntityManager entityManager) {  
        entityManager.close();  
    }  
}
