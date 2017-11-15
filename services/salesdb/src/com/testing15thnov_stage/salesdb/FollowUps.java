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
 * FollowUps generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`FOLLOW_UPS`")
public class FollowUps implements Serializable {

    private Integer id;
    private Integer quoteId;
    private Date entryDate;
    private Quotes quotes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`QUOTE_ID`", nullable = true, scale = 0, precision = 10)
    public Integer getQuoteId() {
        return this.quoteId;
    }

    public void setQuoteId(Integer quoteId) {
        this.quoteId = quoteId;
    }

    @Column(name = "`ENTRY_DATE`", nullable = false)
    public Date getEntryDate() {
        return this.entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`QUOTE_ID`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_FOLLOW_UP_QUOTE_ID`"))
    public Quotes getQuotes() {
        return this.quotes;
    }

    public void setQuotes(Quotes quotes) {
        if(quotes != null) {
            this.quoteId = quotes.getId();
        }

        this.quotes = quotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FollowUps)) return false;
        final FollowUps followUps = (FollowUps) o;
        return Objects.equals(getId(), followUps.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

