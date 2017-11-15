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

import com.testing15thnov_stage.dbscenarios.Persons;
import com.testing15thnov_stage.dbscenarios.service.PersonsService;


/**
 * Controller object for domain model class Persons.
 * @see Persons
 */
@RestController("dbscenarios.PersonsController")
@Api(value = "PersonsController", description = "Exposes APIs to work with Persons resource.")
@RequestMapping("/dbscenarios/Persons")
public class PersonsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonsController.class);

    @Autowired
	@Qualifier("dbscenarios.PersonsService")
	private PersonsService personsService;

	@ApiOperation(value = "Creates a new Persons instance.")
@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public Persons createPersons(@RequestBody Persons persons) {
		LOGGER.debug("Create Persons with information: {}" , persons);

		persons = personsService.create(persons);
		LOGGER.debug("Created Persons with information: {}" , persons);

	    return persons;
	}

    @ApiOperation(value = "Returns the Persons instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Persons getPersons(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Persons with id: {}" , id);

        Persons foundPersons = personsService.getById(id);
        LOGGER.debug("Persons details with id: {}" , foundPersons);

        return foundPersons;
    }

    @ApiOperation(value = "Updates the Persons instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Persons editPersons(@PathVariable("id") Integer id, @RequestBody Persons persons) throws EntityNotFoundException {
        LOGGER.debug("Editing Persons with id: {}" , persons.getPid());

        persons.setPid(id);
        persons = personsService.update(persons);
        LOGGER.debug("Persons details with id: {}" , persons);

        return persons;
    }

    @ApiOperation(value = "Deletes the Persons instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deletePersons(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Persons with id: {}" , id);

        Persons deletedPersons = personsService.delete(id);

        return deletedPersons != null;
    }

    /**
     * @deprecated Use {@link #findPersons(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of Persons instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Persons> searchPersonsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Persons list");
        return personsService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Persons instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Persons> findPersons(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Persons list");
        return personsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of Persons instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<Persons> filterPersons(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Persons list");
        return personsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportPersons(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return personsService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of Persons instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countPersons( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting Persons");
		return personsService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getPersonsAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return personsService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service PersonsService instance
	 */
	protected void setPersonsService(PersonsService service) {
		this.personsService = service;
	}

}
