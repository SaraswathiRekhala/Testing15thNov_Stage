/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.testing15thnov_stage.salesdb.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.commons.wrapper.IntegerWrapper;
import com.wavemaker.runtime.data.dao.query.WMQueryExecutor;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import com.testing15thnov_stage.salesdb.service.SalesdbQueryExecutorService;
import com.testing15thnov_stage.salesdb.models.query.*;

@RestController(value = "Salesdb.QueryExecutionController")
@RequestMapping("/salesdb/queryExecutor")
@Api(value = "QueryExecutionController", description = "controller class for query execution")
public class QueryExecutionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryExecutionController.class);

    @Autowired
    private SalesdbQueryExecutorService queryService;

    @RequestMapping(value = "/queries/SV_RepsData", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Reps Data")
    public Page<SvRepsDataResponse> executeSV_RepsData(Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Executing named query: SV_RepsData");
        Page<SvRepsDataResponse> _result = queryService.executeSV_RepsData(pageable);
        LOGGER.debug("got the result for named query: SV_RepsData, result:{}", _result);
        return _result;
    }

    @ApiOperation(value = "Returns downloadable file for query SV_RepsData")
    @RequestMapping(value = "/queries/SV_RepsData/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSV_RepsData(@PathVariable("exportType") ExportType exportType, Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Exporting named query: SV_RepsData");

        return queryService.exportSV_RepsData(exportType, pageable);
    }

    @RequestMapping(value = "/queries/SV_CustomJoins", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Custom Joins")
    public Page<SvCustomJoinsResponse> executeSV_CustomJoins(Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Executing named query: SV_CustomJoins");
        Page<SvCustomJoinsResponse> _result = queryService.executeSV_CustomJoins(pageable);
        LOGGER.debug("got the result for named query: SV_CustomJoins, result:{}", _result);
        return _result;
    }

    @ApiOperation(value = "Returns downloadable file for query SV_CustomJoins")
    @RequestMapping(value = "/queries/SV_CustomJoins/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportSV_CustomJoins(@PathVariable("exportType") ExportType exportType, Pageable pageable, HttpServletRequest _request) {
        LOGGER.debug("Exporting named query: SV_CustomJoins");

        return queryService.exportSV_CustomJoins(exportType, pageable);
    }

    @RequestMapping(value = "/queries/SV_InsertStates", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Insert States Data")
    public IntegerWrapper executeSV_InsertStates(@Valid @RequestBody SvInsertStatesRequest svInsertStatesRequest, HttpServletRequest _request) {
        LOGGER.debug("Executing named query: SV_InsertStates");
        Integer _result = queryService.executeSV_InsertStates(svInsertStatesRequest);
        LOGGER.debug("got the result for named query: SV_InsertStates, result:{}", _result);
        return new IntegerWrapper(_result);
    }

}


