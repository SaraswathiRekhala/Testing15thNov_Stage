/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing15thnov_stage.dbscenarios;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Table33 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`TABLE33`")
public class Table33 implements Serializable {

    private String id;
    private Table32 table32;

    @Id
    @GenericGenerator(name = "generator", strategy = "foreign", 
            parameters = @Parameter(name = "property", value = "table32"))
    @GeneratedValue(generator = "generator")
    @Column(name = "`ID`", nullable = false, insertable = false, updatable = false, length = 255)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    public Table32 getTable32() {
        return this.table32;
    }

    public void setTable32(Table32 table32) {
        if(table32 != null) {
            this.id = table32.getId();
        }

        this.table32 = table32;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table33)) return false;
        final Table33 table33 = (Table33) o;
        return Objects.equals(getId(), table33.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
