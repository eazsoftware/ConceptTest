package com.eaz.jpa.hotel.service;

import com.eaz.jpa.hotel.exception.HotelException;
import com.eaz.jpa.hotel.model.Permission;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author javier
 */
@Slf4j
public final class PermissionService extends Service {

    final static String LOG_MESSAGE_METHOD_START = "Start";
    final static String LOG_MESSAGE_METHOD_END = "End";
    final static String LOG_MESSAGE_IS_OBJECT_PRESENT = "Is object present? [%s] [%s]";
    final static String LOG_MESSAGE_ROLLING_BACK_TRANSACTION = "Rolling back transaction";
    final static String LOG_MESSAGE_TRANSACTION_ROLLED_BACK = "Transaction rolled back";
    final static String LOG_MESSAGE_CLOSING_ENTITYMANAGER = "Closing EntityManager";
    final static String LOG_MESSAGE_ENTITYMANAGER_CLOSED = "EntityManager closed";
    final static String LOG_MESSAGE_BEGIN_TRANSACTION = "Begin transaction";
    final static String LOG_MESSAGE_OBJECT_PERSISTED = "Object persisted";
    final static String LOG_MESSAGE_COMMITTING_TRANSACTION = "Committing transaction";
    final static String LOG_MESSAGE_TRANSACTION_COMMITTED = "Transaction committed";
    final static String LOG_MESSAGE_OBJECT_PRESENT_TRYING_TO_REMOVE_IT = "Object was present, trying to remove it";
    final static String LOG_MESSAGE_OBJECT_REMOVED = "Object removed";
    final static String LOG_MESSAGE_OBJECT_WAS_NOT_PRESENT = "Object was not present";
    final static String LOG_MESSAGE_NUMBER_ELEMENTS_IN_QUERY = "Number of elements in query [%d]";

    final static String LOG_ERROR = "Error [%s]";
    final static String LOG_ERROR_ENTITY_MANAGER_FACTORY_IS_NULL = "Entity Manager Factory is null";
    final static String LOG_ERROR_ENTITY_MANAGER_FACTORY_IS_CLOSED = "Entity Manager Factory is closed";

    final static String LOG_MESSAGE_NULL = "null";

    private static EntityManagerFactory entityManagerFactory;

    public PermissionService(EntityManagerFactory emf) throws HotelException {
        log.trace(LOG_MESSAGE_METHOD_START);
        entityManagerFactory = emf;
        if (emf == null) {
            log.error(LOG_ERROR_ENTITY_MANAGER_FACTORY_IS_NULL);
            throw new HotelException(LOG_ERROR_ENTITY_MANAGER_FACTORY_IS_NULL);
        }
        if (!emf.isOpen()) {
            log.error(LOG_ERROR_ENTITY_MANAGER_FACTORY_IS_CLOSED);
        }
        log.trace(LOG_MESSAGE_METHOD_END);
    }

    public Optional<Permission> create(String code, String name, int level) {
        log.trace(LOG_MESSAGE_METHOD_START);

        Optional<Permission> optional = Optional.empty();

        EntityTransaction transaction = getEntityManager().getTransaction();

        try {
            Boolean isTransactionActive = transaction.isActive();

            if (!isTransactionActive) {
                log.trace(LOG_MESSAGE_BEGIN_TRANSACTION);
                transaction.begin();
            }

            Permission permission = new Permission();
            permission.setCode(name);
            permission.setName(name);
            permission.setPermissionLevel(level);

            getEntityManager().persist(permission);
            log.trace(LOG_MESSAGE_OBJECT_PERSISTED);
            optional = Optional.of(permission);

            if (!isTransactionActive) {
                log.trace(LOG_MESSAGE_COMMITTING_TRANSACTION);
                transaction.commit();
                log.trace(LOG_MESSAGE_TRANSACTION_COMMITTED);
            }
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null
                    && transaction.isActive()) {
                log.trace(LOG_MESSAGE_ROLLING_BACK_TRANSACTION);
                transaction.rollback();
                log.trace(LOG_MESSAGE_TRANSACTION_ROLLED_BACK);
            }
            optional = Optional.empty();
            log.error(String.format(LOG_ERROR, ex.toString()));
        }

        log.trace(String.format(LOG_MESSAGE_IS_OBJECT_PRESENT, optional.isPresent(), (optional.isPresent() ? optional.get().getId() : LOG_MESSAGE_NULL)));
        log.trace(LOG_MESSAGE_METHOD_END);
        return optional;
    }

    public void remove(String id) {
        log.trace(LOG_MESSAGE_METHOD_START);

        EntityTransaction transaction = getEntityManager().getTransaction();

        try {
            Boolean isTransactionActive = transaction.isActive();

            if (!isTransactionActive) {
                log.trace(LOG_MESSAGE_BEGIN_TRANSACTION);
                transaction.begin();
            }

            Optional<Permission> optional = findOne(id);
            if (optional.isPresent()) {
                log.debug(LOG_MESSAGE_OBJECT_PRESENT_TRYING_TO_REMOVE_IT);
                getEntityManager().remove(optional.get());
            } else {
                log.debug(LOG_MESSAGE_OBJECT_WAS_NOT_PRESENT);
            }

            if (!isTransactionActive) {
                log.trace(LOG_MESSAGE_COMMITTING_TRANSACTION);
                transaction.commit();
                log.debug(LOG_MESSAGE_OBJECT_REMOVED);
                log.trace(LOG_MESSAGE_TRANSACTION_COMMITTED);
            }
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null
                    && transaction.isActive()) {
                log.trace(LOG_MESSAGE_ROLLING_BACK_TRANSACTION);
                transaction.rollback();
                log.trace(LOG_MESSAGE_TRANSACTION_ROLLED_BACK);
            }
            log.error(String.format(LOG_ERROR, ex.toString()));
        }

        log.trace(LOG_MESSAGE_METHOD_END);
    }

    public Optional<Permission> findOne(String id) {
        log.trace(LOG_MESSAGE_METHOD_START);

        Optional<Permission> optional = Optional.empty();

        EntityTransaction transaction = getEntityManager().getTransaction();

        try {
            Boolean isTransactionActive = transaction.isActive();

            if (!isTransactionActive) {
                log.trace(LOG_MESSAGE_BEGIN_TRANSACTION);
                transaction.begin();
            }

            optional = Optional.ofNullable(getEntityManager().find(Permission.class, id));
            log.debug(String.format(LOG_MESSAGE_IS_OBJECT_PRESENT, optional.isPresent(), (optional.isPresent() ? optional.get().getId() : LOG_MESSAGE_NULL)));

            if (!isTransactionActive) {
                log.trace(LOG_MESSAGE_COMMITTING_TRANSACTION);
                transaction.commit();
                log.trace(LOG_MESSAGE_TRANSACTION_COMMITTED);
            }
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null
                    && transaction.isActive()) {
                log.trace(LOG_MESSAGE_ROLLING_BACK_TRANSACTION);
                transaction.rollback();
                log.trace(LOG_MESSAGE_TRANSACTION_ROLLED_BACK);
            }
            optional = Optional.empty();
            log.error(String.format(LOG_ERROR, ex.toString()));
        }

        log.trace(LOG_MESSAGE_METHOD_END);
        return optional;
    }

    public Optional<List<Permission>> findAll() {
        log.trace(LOG_MESSAGE_METHOD_START);

        Optional<List<Permission>> optional = Optional.empty();

        EntityTransaction transaction = getEntityManager().getTransaction();

        try {
            Boolean isTransactionActive = transaction.isActive();

            if (!isTransactionActive) {
                log.trace(LOG_MESSAGE_BEGIN_TRANSACTION);
                transaction.begin();
            }

            Query query = getEntityManager().createQuery("SELECT p FROM Permission p");
            optional = Optional.ofNullable(query.getResultList());
            log.debug(String.format(LOG_MESSAGE_NUMBER_ELEMENTS_IN_QUERY, (optional.isPresent() ? optional.get().size() : 0)));

            if (!isTransactionActive) {
                log.trace(LOG_MESSAGE_COMMITTING_TRANSACTION);
                transaction.commit();
                log.trace(LOG_MESSAGE_TRANSACTION_COMMITTED);
            }
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null
                    && transaction.isActive()) {
                log.trace(LOG_MESSAGE_ROLLING_BACK_TRANSACTION);
                transaction.rollback();
                log.trace(LOG_MESSAGE_TRANSACTION_ROLLED_BACK);
            }
            optional = Optional.empty();
            log.error(String.format(LOG_ERROR, ex.toString()));
        }

        log.trace(LOG_MESSAGE_METHOD_END);
        return optional;
    }



}
