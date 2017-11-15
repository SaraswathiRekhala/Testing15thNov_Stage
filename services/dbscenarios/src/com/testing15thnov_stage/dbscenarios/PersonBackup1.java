/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing15thnov_stage.dbscenarios;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * PersonBackup1 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`PersonBackup1`")
@IdClass(PersonBackup1Id.class)
public class PersonBackup1 implements Serializable {

    private Integer pid;
    private String lastName;
    private String firstName;
    private String address;
    private String city;

    @Id
    @Column(name = "`P_Id`", nullable = false, scale = 0, precision = 10)
    public Integer getPid() {
        return this.pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Id
    @Column(name = "`LastName`", nullable = false, length = 255)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Id
    @Column(name = "`FirstName`", nullable = true, length = 255)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Id
    @Column(name = "`Address`", nullable = true, length = 255)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Id
    @Column(name = "`City`", nullable = true, length = 255)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonBackup1)) return false;
        final PersonBackup1 personBackup1 = (PersonBackup1) o;
        return Objects.equals(getPid(), personBackup1.getPid()) &&
                Objects.equals(getLastName(), personBackup1.getLastName()) &&
                Objects.equals(getFirstName(), personBackup1.getFirstName()) &&
                Objects.equals(getAddress(), personBackup1.getAddress()) &&
                Objects.equals(getCity(), personBackup1.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPid(),
                getLastName(),
                getFirstName(),
                getAddress(),
                getCity());
    }
}
