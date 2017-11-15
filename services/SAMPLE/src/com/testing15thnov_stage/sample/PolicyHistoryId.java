/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing15thnov_stage.sample;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class PolicyHistoryId implements Serializable {

    private String policyId;
    private Integer coverage;
    private Timestamp sysStart;
    private Timestamp sysEnd;
    private Timestamp transId;

    public String getPolicyId() {
        return this.policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public Integer getCoverage() {
        return this.coverage;
    }

    public void setCoverage(Integer coverage) {
        this.coverage = coverage;
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

    public Timestamp getTransId() {
        return this.transId;
    }

    public void setTransId(Timestamp transId) {
        this.transId = transId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PolicyHistory)) return false;
        final PolicyHistory policyHistory = (PolicyHistory) o;
        return Objects.equals(getPolicyId(), policyHistory.getPolicyId()) &&
                Objects.equals(getCoverage(), policyHistory.getCoverage()) &&
                Objects.equals(getSysStart(), policyHistory.getSysStart()) &&
                Objects.equals(getSysEnd(), policyHistory.getSysEnd()) &&
                Objects.equals(getTransId(), policyHistory.getTransId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPolicyId(),
                getCoverage(),
                getSysStart(),
                getSysEnd(),
                getTransId());
    }
}
