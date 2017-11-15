/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing15thnov_stage.sample;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * AlltypesDb generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`ALLTYPES_DB`")
public class AlltypesDb implements Serializable {

    private Integer intCol;
    private int integerCol;
    private short smallintCol;
    private BigInteger bigintCol;
    private short decimalCol;
    private short numericCol;
    private BigDecimal numericPecCol;
    private String charCol;
    private String varcharPrecCol;
    private String clobCol;
    @JsonProperty(access = Access.READ_ONLY)
    private byte[] binaryLargeObjectCol;
    private String varbinaryPrecCol;
    @JsonProperty(access = Access.READ_ONLY)
    private byte[] blobCol;
    private Time timeCol;
    private Date date;
    private Timestamp timestampCol;
    private boolean booleanCol;
    private Integer decimal10Col;
    private Short decimal4Column;
    private Timestamp sysStart;
    private Timestamp sysEnd;
    private Timestamp createId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`INT COL`", nullable = false, scale = 0, precision = 10)
    public Integer getIntCol() {
        return this.intCol;
    }

    public void setIntCol(Integer intCol) {
        this.intCol = intCol;
    }

    @Column(name = "`INTEGER_COL`", nullable = false, scale = 0, precision = 10)
    public int getIntegerCol() {
        return this.integerCol;
    }

    public void setIntegerCol(int integerCol) {
        this.integerCol = integerCol;
    }

    @Column(name = "`SMALLINT_COL`", nullable = false, scale = 0, precision = 5)
    public short getSmallintCol() {
        return this.smallintCol;
    }

    public void setSmallintCol(short smallintCol) {
        this.smallintCol = smallintCol;
    }

    @Column(name = "`BIGINT_COL`", nullable = false, scale = 0, precision = 20)
    public BigInteger getBigintCol() {
        return this.bigintCol;
    }

    public void setBigintCol(BigInteger bigintCol) {
        this.bigintCol = bigintCol;
    }

    @Column(name = "`DECIMAL_COL`", nullable = false, scale = 0, precision = 5)
    public short getDecimalCol() {
        return this.decimalCol;
    }

    public void setDecimalCol(short decimalCol) {
        this.decimalCol = decimalCol;
    }

    @Column(name = "`NUMERIC_COL`", nullable = false, scale = 0, precision = 5)
    public short getNumericCol() {
        return this.numericCol;
    }

    public void setNumericCol(short numericCol) {
        this.numericCol = numericCol;
    }

    @Column(name = "`NUMERIC_PEC_COL`", nullable = false, scale = 31, precision = 31)
    public BigDecimal getNumericPecCol() {
        return this.numericPecCol;
    }

    public void setNumericPecCol(BigDecimal numericPecCol) {
        this.numericPecCol = numericPecCol;
    }

    @Column(name = "`CHAR COL`", nullable = false, length = 1)
    public String getCharCol() {
        return this.charCol;
    }

    public void setCharCol(String charCol) {
        this.charCol = charCol;
    }

    @Column(name = "`VARCHAR PREC COL`", nullable = false, length = 32672)
    public String getVarcharPrecCol() {
        return this.varcharPrecCol;
    }

    public void setVarcharPrecCol(String varcharPrecCol) {
        this.varcharPrecCol = varcharPrecCol;
    }

    @Column(name = "`CLOB COL`", nullable = false, length = 2147483647)
    public String getClobCol() {
        return this.clobCol;
    }

    public void setClobCol(String clobCol) {
        this.clobCol = clobCol;
    }

    @Column(name = "`BINARY_LARGE_OBJECT_COL`", nullable = false)
    public byte[] getBinaryLargeObjectCol() {
        return this.binaryLargeObjectCol;
    }

    public void setBinaryLargeObjectCol(byte[] binaryLargeObjectCol) {
        this.binaryLargeObjectCol = binaryLargeObjectCol;
    }

    @Column(name = "`VARBINARY_PREC_COL`", nullable = false, length = 12)
    public String getVarbinaryPrecCol() {
        return this.varbinaryPrecCol;
    }

    public void setVarbinaryPrecCol(String varbinaryPrecCol) {
        this.varbinaryPrecCol = varbinaryPrecCol;
    }

    @Column(name = "`BLOB_COL`", nullable = false)
    public byte[] getBlobCol() {
        return this.blobCol;
    }

    public void setBlobCol(byte[] blobCol) {
        this.blobCol = blobCol;
    }

    @Column(name = "`TIME_COL`", nullable = false)
    public Time getTimeCol() {
        return this.timeCol;
    }

    public void setTimeCol(Time timeCol) {
        this.timeCol = timeCol;
    }

    @Column(name = "`DATE`", nullable = false)
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "`TIMESTAMP_COL`", nullable = false)
    public Timestamp getTimestampCol() {
        return this.timestampCol;
    }

    public void setTimestampCol(Timestamp timestampCol) {
        this.timestampCol = timestampCol;
    }

    @Column(name = "`BOOLEAN_COL`", nullable = false)
    public boolean isBooleanCol() {
        return this.booleanCol;
    }

    public void setBooleanCol(boolean booleanCol) {
        this.booleanCol = booleanCol;
    }

    @Column(name = "`DECIMAL_10_COL`", nullable = true, scale = 0, precision = 10)
    public Integer getDecimal10Col() {
        return this.decimal10Col;
    }

    public void setDecimal10Col(Integer decimal10Col) {
        this.decimal10Col = decimal10Col;
    }

    @Column(name = "`DECIMAL_4_COLUMN`", nullable = true, scale = 0, precision = 4)
    public Short getDecimal4Column() {
        return this.decimal4Column;
    }

    public void setDecimal4Column(Short decimal4Column) {
        this.decimal4Column = decimal4Column;
    }

    @Column(name = "`SYS_START`", nullable = false)
    public Timestamp getSysStart() {
        return this.sysStart;
    }

    public void setSysStart(Timestamp sysStart) {
        this.sysStart = sysStart;
    }

    @Column(name = "`SYS_END`", nullable = false)
    public Timestamp getSysEnd() {
        return this.sysEnd;
    }

    public void setSysEnd(Timestamp sysEnd) {
        this.sysEnd = sysEnd;
    }

    @Column(name = "`CREATE_ID`", nullable = true)
    public Timestamp getCreateId() {
        return this.createId;
    }

    public void setCreateId(Timestamp createId) {
        this.createId = createId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AlltypesDb)) return false;
        final AlltypesDb alltypesDb = (AlltypesDb) o;
        return Objects.equals(getIntCol(), alltypesDb.getIntCol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIntCol());
    }
}
