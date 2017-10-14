package com.eaz.jpa.hotel;

import com.eaz.jpa.hotel.exception.HotelException;
import com.eaz.jpa.hotel.model.Permission;
import com.eaz.jpa.hotel.service.PermissionService;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author javier
 */
@Slf4j
public class Main {

    // Create an EntityManagerFactory when you start the application.
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("jpa-hotel-pu");

    public static void main(String args[]) {
        try {
            // Initialize service
            PermissionService permissionService = new PermissionService(ENTITY_MANAGER_FACTORY);

            // Create some permissions
            Optional<Permission> permission1 = permissionService.create("CODE1", "NAME1", 1234);
            Optional<Permission> permission2 = permissionService.create("CODE2", "NAME2", 2345);

            // Delete one permission
            permissionService.remove(permission1.get().getId());
            
            // Find all permissions
            Optional<List<Permission>> optListPermission = permissionService.findAll();
            log.info(String.format("Number of Permissions in DB [%s]", optListPermission.get().size()));
            
            // Closing Entity Manager
            permissionService.getEntityManager().close();
            
            // Closing Entity Manager Factory
            ENTITY_MANAGER_FACTORY.close();
        } catch (HotelException e) {
            log.error("Error " + e);
        }
        System.exit(0);
    }

}
