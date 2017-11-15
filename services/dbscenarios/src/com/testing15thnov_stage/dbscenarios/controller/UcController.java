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

import com.testing15thnov_stage.dbscenarios.Uc;
import com.testing15thnov_stage.dbscenarios.service.UcService;


/**
 * Controller object for domain model class Uc.
 * @see Uc
 */
@RestController("dbscenarios.UcController")
@Api(value = "UcController", description = "Exposes APIs to work with Uc resource.")
@RequestMapping("/dbscenarios/Uc")
public class UcController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UcController.class);

    @Autowired
	@Qualifier("dbscenarios.UcService")
	private UcService ucService;

	@ApiOperation(value = "Creates a new Uc instance.")
@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public Uc createUc(@RequestBody Uc uc) {
		LOGGER.debug("Create Uc with information: {}" , uc);

		uc = ucService.create(uc);
		LOGGER.debug("Created Uc with information: {}" , uc);

	    return uc;
	}

    @ApiOperation(value = "Returns the Uc instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Uc getUc(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Uc with id: {}" , id);

        Uc foundUc = ucService.getById(id);
        LOGGER.debug("Uc details with id: {}" , foundUc);

        return foundUc;
    }

    @ApiOperation(value = "Updates the Uc instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Uc editUc(@PathVariable("id") Integer id, @RequestBody Uc uc) throws EntityNotFoundException {
        LOGGER.debug("Editing Uc with id: {}" , uc.getId());

        uc.setId(id);
        uc = ucService.update(uc);
        LOGGER.debug("Uc details with id: {}" , uc);

        return uc;
    }

    @ApiOperation(value = "Deletes the Uc instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteUc(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Uc with id: {}" , id);

        Uc deletedUc = ucService.delete(id);

        return deletedUc != null;
    }

    @RequestMapping(value = "/column2/{column2}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching Uc with given unique key values.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Uc getByColumn2(@PathVariable("column2") int column2) {
        LOGGER.debug("Getting Uc with uniques key Column2");
        return ucService.getByColumn2(column2);
    }

    /**
     * @deprecated Use {@link #findUcs(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Uc instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Uc> searchUcsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Ucs list");
        return ucService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Uc instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Uc> findUcs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Ucs list");
        return ucService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Uc instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Uc> filterUcs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Ucs list");
        return ucService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportUcs(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return ucService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Uc instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countUcs( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Ucs");
		return ucService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getUcAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return ucService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service UcService instance
	 */
	protected void setUcService(UcService service) {
		this.ucService = service;
	}

}

