/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing15thnov_stage.db123__.models.procedure;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.wavemaker.runtime.data.annotations.ColumnAlias;

public class ProcedureOnlyInparamResponse implements Serializable {


    @ColumnAlias("content")
    private List<ProcedureOnlyInparamResponseContent> content;

    public List<ProcedureOnlyInparamResponseContent> getContent() {
        return this.content;
    }

    public void setContent(List<ProcedureOnlyInparamResponseContent> content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProcedureOnlyInparamResponse)) return false;
        final ProcedureOnlyInparamResponse procedureOnlyInparamResponse = (ProcedureOnlyInparamResponse) o;
        return Objects.equals(getContent(), procedureOnlyInparamResponse.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContent());
    }
}