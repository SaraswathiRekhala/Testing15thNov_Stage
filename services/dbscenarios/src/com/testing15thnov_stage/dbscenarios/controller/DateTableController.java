/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing15thnov_stage.dbscenarios.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.testing15thnov_stage.dbscenarios.DateTable;
import com.testing15thnov_stage.dbscenarios.service.DateTableService;


/**
 * Controller object for domain model class DateTable.
 * @see DateTable
 */
@RestController("dbscenarios.DateTableController")
@Api(value = "DateTableController", description = "Exposes APIs to work with DateTable resource.")
@RequestMapping("/dbscenarios/DateTable")
public class DateTableController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateTableController.class);

    @Autowired
	@Qualifier("dbscenarios.DateTableService")
	private DateTableService dateTableService;

	@ApiOperation(value = "Creates a new DateTable instance.")
@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public DateTable createDateTable(@RequestBody DateTable dateTable) {
		LOGGER.debug("Create DateTable with information: {}" , dateTable);

		dateTable = dateTableService.create(dateTable);
		LOGGER.debug("Created DateTable with information: {}" , dateTable);

	    return dateTable;
	}

    @ApiOperation(value = "Returns the DateTable instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DateTable getDateTable(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting DateTable with id: {}" , id);

        DateTable foundDateTable = dateTableService.getById(id);
        LOGGER.debug("DateTable details with id: {}" , foundDateTable);

        return foundDateTable;
    }

    @ApiOperation(value = "Updates the DateTable instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DateTable editDateTable(@PathVariable("id") Integer id, @RequestBody DateTable dateTable) throws EntityNotFoundException {
        LOGGER.debug("Editing DateTable with id: {}" , dateTable.getId());

        dateTable.setId(id);
        dateTable = dateTableService.update(dateTable);
        LOGGER.debug("DateTable details with id: {}" , dateTable);

        return dateTable;
    }

    @ApiOperation(value = "Deletes the DateTable instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteDateTable(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting DateTable with id: {}" , id);

        DateTable deletedDateTable = dateTableService.delete(id);

        return deletedDateTable != null;
    }

    /**
     * @deprecated Use {@link #findDateTables(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of DateTable instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<DateTable> searchDateTablesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering DateTables list");
        return dateTableService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of DateTable instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<DateTable> findDateTables(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering DateTables list");
        return dateTableService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of DateTable instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<DateTable> filterDateTables(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering DateTables list");
        return dateTableService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportDateTables(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return dateTableService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of DateTable instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countDateTables( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting DateTables");
		return dateTableService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getDateTableAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return dateTableService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service DateTableService instance
	 */
	protected void setDateTableService(DateTableService service) {
		this.dateTableService = service;
	}

}

