/**
 * This file was generated by the Jeddict
 */
package com.eaz.jpa.hotel.model;

import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 * @author javier
 */
@Entity
public class Permission extends HotelBaseEntity {

    @Basic
    private String code;

    @Basic
    private String name;

    @Basic
    private int permissionLevel;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(int permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

}