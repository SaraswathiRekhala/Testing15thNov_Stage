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

public class AlltypesDbHistId implements Serializable {

    private Integer intCol;
    private Integer integerCol;
    private Short smallintCol;
    private BigInteger bigintCol;
    private Short decimalCol;
    private Short numericCol;
    private BigDecimal numericPecCol;
    private String charCol;
    private String varcharPrecCol;
    private String clobCol;
    private byte[] binaryLargeObjectCol;
    private String varbinaryPrecCol;
    private byte[] blobCol;
    private Time timeCol;
    private Date date;
    private Timestamp timestampCol;
    private Boolean booleanCol;
    private Integer decimal10Col;
    private Short decimal4Column;
    private Timestamp sysStart;
    private Timestamp sysEnd;
    private Timestamp createId;

    public Integer getIntCol() {
        return this.intCol;
    }

    public void setIntCol(Integer intCol) {
        this.intCol = intCol;
    }

    public Integer getIntegerCol() {
        return this.integerCol;
    }

    public void setIntegerCol(Integer integerCol) {
        this.integerCol = integerCol;
    }

    public Short getSmallintCol() {
        return this.smallintCol;
    }

    public void setSmallintCol(Short smallintCol) {
        this.smallintCol = smallintCol;
    }

    public BigInteger getBigintCol() {
        return this.bigintCol;
    }

    public void setBigintCol(BigInteger bigintCol) {
        this.bigintCol = bigintCol;
    }

    public Short getDecimalCol() {
        return this.decimalCol;
    }

    public void setDecimalCol(Short decimalCol) {
        this.decimalCol = decimalCol;
    }

    public Short getNumericCol() {
        return this.numericCol;
    }

    public void setNumericCol(Short numericCol) {
        this.numericCol = numericCol;
    }

    public BigDecimal getNumericPecCol() {
        return this.numericPecCol;
    }

    public void setNumericPecCol(BigDecimal numericPecCol) {
        this.numericPecCol = numericPecCol;
    }

    public String getCharCol() {
        return this.charCol;
    }

    public void setCharCol(String charCol) {
        this.charCol = charCol;
    }

    public String getVarcharPrecCol() {
        return this.varcharPrecCol;
    }

    public void setVarcharPrecCol(String varcharPrecCol) {
        this.varcharPrecCol = varcharPrecCol;
    }

    public String getClobCol() {
        return this.clobCol;
    }

    public void setClobCol(String clobCol) {
        this.clobCol = clobCol;
    }

    public byte[] getBinaryLargeObjectCol() {
        return this.binaryLargeObjectCol;
    }

    public void setBinaryLargeObjectCol(byte[] binaryLargeObjectCol) {
        this.binaryLargeObjectCol = binaryLargeObjectCol;
    }

    public String getVarbinaryPrecCol() {
        return this.varbinaryPrecCol;
    }

    public void setVarbinaryPrecCol(String varbinaryPrecCol) {
        this.varbinaryPrecCol = varbinaryPrecCol;
    }

    public byte[] getBlobCol() {
        return this.blobCol;
    }

    public void setBlobCol(byte[] blobCol) {
        this.blobCol = blobCol;
    }

    public Time getTimeCol() {
        return this.timeCol;
    }

    public void setTimeCol(Time timeCol) {
        this.timeCol = timeCol;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Timestamp getTimestampCol() {
        return this.timestampCol;
    }

    public void setTimestampCol(Timestamp timestampCol) {
        this.timestampCol = timestampCol;
    }

    public Boolean getBooleanCol() {
        return this.booleanCol;
    }

    public void setBooleanCol(Boolean booleanCol) {
        this.booleanCol = booleanCol;
    }

    public Integer getDecimal10Col() {
        return this.decimal10Col;
    }

    public void setDecimal10Col(Integer decimal10Col) {
        this.decimal10Col = decimal10Col;
    }

    public Short getDecimal4Column() {
        return this.decimal4Column;
    }

    public void setDecimal4Column(Short decimal4Column) {
        this.decimal4Column = decimal4Column;
    }

    public Timestamp getSysStart() {
        return this.sysStart;
    }

    public void setSysStart(Timestamp sysStart) {
        this.sysStart = sysStart;
    }

    public Timestamp getSysEnd() {
        return this.sysEnd;
    }

    public void setSysEnd(Timestamp sysEnd) {
        this.sysEnd = sysEnd;
    }

    public Timestamp getCreateId() {
        return this.createId;
    }

    public void setCreateId(Timestamp createId) {
        this.createId = createId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AlltypesDbHist)) return false;
        final AlltypesDbHist alltypesDbHist = (AlltypesDbHist) o;
        return Objects.equals(getIntCol(), alltypesDbHist.getIntCol()) &&
                Objects.equals(getIntegerCol(), alltypesDbHist.getIntegerCol()) &&
                Objects.equals(getSmallintCol(), alltypesDbHist.getSmallintCol()) &&
                Objects.equals(getBigintCol(), alltypesDbHist.getBigintCol()) &&
                Objects.equals(getDecimalCol(), alltypesDbHist.getDecimalCol()) &&
                Objects.equals(getNumericCol(), alltypesDbHist.getNumericCol()) &&
                Objects.equals(getNumericPecCol(), alltypesDbHist.getNumericPecCol()) &&
                Objects.equals(getCharCol(), alltypesDbHist.getCharCol()) &&
                Objects.equals(getVarcharPrecCol(), alltypesDbHist.getVarcharPrecCol()) &&
                Objects.equals(getClobCol(), alltypesDbHist.getClobCol()) &&
                Objects.equals(getBinaryLargeObjectCol(), alltypesDbHist.getBinaryLargeObjectCol()) &&
                Objects.equals(getVarbinaryPrecCol(), alltypesDbHist.getVarbinaryPrecCol()) &&
                Objects.equals(getBlobCol(), alltypesDbHist.getBlobCol()) &&
                Objects.equals(getTimeCol(), alltypesDbHist.getTimeCol()) &&
                Objects.equals(getDate(), alltypesDbHist.getDate()) &&
                Objects.equals(getTimestampCol(), alltypesDbHist.getTimestampCol()) &&
                Objects.equals(getBooleanCol(), alltypesDbHist.getBooleanCol()) &&
                Objects.equals(getDecimal10Col(), alltypesDbHist.getDecimal10Col()) &&
                Objects.equals(getDecimal4Column(), alltypesDbHist.getDecimal4Column()) &&
                Objects.equals(getSysStart(), alltypesDbHist.getSysStart()) &&
                Objects.equals(getSysEnd(), alltypesDbHist.getSysEnd()) &&
                Objects.equals(getCreateId(), alltypesDbHist.getCreateId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIntCol(),
                getIntegerCol(),
                getSmallintCol(),
                getBigintCol(),
                getDecimalCol(),
                getNumericCol(),
                getNumericPecCol(),
                getCharCol(),
                getVarcharPrecCol(),
                getClobCol(),
                getBinaryLargeObjectCol(),
                getVarbinaryPrecCol(),
                getBlobCol(),
                getTimeCol(),
                getDate(),
                getTimestampCol(),
                getBooleanCol(),
                getDecimal10Col(),
                getDecimal4Column(),
                getSysStart(),
                getSysEnd(),
                getCreateId());
    }
}