/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing15thnov_stage.salesdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Leads generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`LEADS`")
public class Leads implements Serializable {

    private Integer id;
    private Integer customerId;
    private Date entryDate;
    private Customers customers;
    private List<Quotes> quoteses;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`CUSTOMER_ID`", nullable = true, scale = 0, precision = 10)
    public Integer getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Column(name = "`ENTRY_DATE`", nullable = false)
    public Date getEntryDate() {
        return this.entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`CUSTOMER_ID`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_LEAD_CUSTOMER_ID`"))
    public Customers getCustomers() {
        return this.customers;
    }

    public void setCustomers(Customers customers) {
        if(customers != null) {
            this.customerId = customers.getId();
        }

        this.customers = customers;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "leads")
    public List<Quotes> getQuoteses() {
        return this.quoteses;
    }

    public void setQuoteses(List<Quotes> quoteses) {
        this.quoteses = quoteses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Leads)) return false;
        final Leads leads = (Leads) o;
        return Objects.equals(getId(), leads.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

