package com.eaz.jpa.hotel.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author javier
 */
public class Service {

    private static EntityManagerFactory ENTITY_MANAGER_FACTORY;

    private EntityManager entityManager;

    public EntityManagerFactory getEntityManagerFactory() {
        if (ENTITY_MANAGER_FACTORY == null
                || !ENTITY_MANAGER_FACTORY.isOpen()) {
            ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("jpa-hotel-pu");
        }

        return ENTITY_MANAGER_FACTORY;
    }

    public EntityManager getEntityManager() {
        if (entityManager == null
                || !entityManager.isOpen()) {
            entityManager = getEntityManagerFactory().createEntityManager();
        }

        return entityManager;
    }
}
