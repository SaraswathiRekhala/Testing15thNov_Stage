/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing15thnov_stage.salesdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Tasks generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`TASKS`")
public class Tasks implements Serializable {

    private Integer id;
    private String description;
    private Date duedate;
    private Boolean done;
    private Integer repId;
    private Reps reps;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`DESCRIPTION`", nullable = true, length = 16777216)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "`DUEDATE`", nullable = true)
    public Date getDuedate() {
        return this.duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    @Column(name = "`DONE`", nullable = true)
    public Boolean getDone() {
        return this.done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Column(name = "`REP_ID`", nullable = true, scale = 0, precision = 10)
    public Integer getRepId() {
        return this.repId;
    }

    public void setRepId(Integer repId) {
        this.repId = repId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`REP_ID`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_BYCIJAABMA9A2AEHPR4RV9PMY`"))
    public Reps getReps() {
        return this.reps;
    }

    public void setReps(Reps reps) {
        if(reps != null) {
            this.repId = reps.getId();
        }

        this.reps = reps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tasks)) return false;
        final Tasks tasks = (Tasks) o;
        return Objects.equals(getId(), tasks.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

