/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing15thnov_stage.wmstudio.models.procedure;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class ProcedureSingleCursorAndOutResponseRegionsdata implements Serializable {


    @ColumnAlias("REGION_ID")
    private BigDecimal regionId;

    @ColumnAlias("REGION_NAME")
    private String regionName;

    public BigDecimal getRegionId() {
        return this.regionId;
    }

    public void setRegionId(BigDecimal regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return this.regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProcedureSingleCursorAndOutResponseRegionsdata)) return false;
        final ProcedureSingleCursorAndOutResponseRegionsdata procedureSingleCursorAndOutResponseRegionsdata = (ProcedureSingleCursorAndOutResponseRegionsdata) o;
        return Objects.equals(getRegionId(), procedureSingleCursorAndOutResponseRegionsdata.getRegionId()) &&
                Objects.equals(getRegionName(), procedureSingleCursorAndOutResponseRegionsdata.getRegionName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRegionId(),
                getRegionName());
    }
}
