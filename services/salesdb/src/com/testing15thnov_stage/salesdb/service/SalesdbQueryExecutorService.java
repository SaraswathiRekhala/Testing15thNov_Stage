/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.testing15thnov_stage.salesdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testing15thnov_stage.salesdb.models.query.*;

public interface SalesdbQueryExecutorService {

    Page<SvRepsDataResponse> executeSV_RepsData(Pageable pageable);

    Downloadable exportSV_RepsData(ExportType exportType, Pageable pageable);

    Page<SvCustomJoinsResponse> executeSV_CustomJoins(Pageable pageable);

    Downloadable exportSV_CustomJoins(ExportType exportType, Pageable pageable);

    Integer executeSV_InsertStates(SvInsertStatesRequest svInsertStatesRequest);

}


