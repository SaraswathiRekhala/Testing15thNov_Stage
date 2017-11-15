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

import com.testing15thnov_stage.dbscenarios.TOne2oneComposites;
import com.testing15thnov_stage.dbscenarios.TOne2oneComposites1Id;
import com.testing15thnov_stage.dbscenarios.service.TOne2oneCompositesService;


/**
 * Controller object for domain model class TOne2oneComposites.
 * @see TOne2oneComposites
 */
@RestController("dbscenarios.TOne2oneCompositesController")
@Api(value = "TOne2oneCompositesController", description = "Exposes APIs to work with TOne2oneComposites resource.")
@RequestMapping("/dbscenarios/TOne2oneComposites")
public class TOne2oneCompositesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TOne2oneCompositesController.class);

    @Autowired
	@Qualifier("dbscenarios.TOne2oneCompositesService")
	private TOne2oneCompositesService tOne2oneCompositesService;

	@ApiOperation(value = "Creates a new TOne2oneComposites instance.")
@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public TOne2oneComposites createTOne2oneComposites(@RequestBody TOne2oneComposites tone2oneComposites) {
		LOGGER.debug("Create TOne2oneComposites with information: {}" , tone2oneComposites);

		tone2oneComposites = tOne2oneCompositesService.create(tone2oneComposites);
		LOGGER.debug("Created TOne2oneComposites with information: {}" , tone2oneComposites);

	    return tone2oneComposites;
	}

@ApiOperation(value = "Returns the TOne2oneComposites instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TOne2oneComposites getTOne2oneComposites(@RequestParam("byteId") Short byteId,@RequestParam("shortId") Short shortId,@RequestParam("charId") String charId,@RequestParam("stringId") String stringId) throws EntityNotFoundException {

        TOne2oneComposites1Id tone2onecompositesId = new TOne2oneComposites1Id();
        tone2onecompositesId.setByteId(byteId);
        tone2onecompositesId.setShortId(shortId);
        tone2onecompositesId.setCharId(charId);
        tone2onecompositesId.setStringId(stringId);

        LOGGER.debug("Getting TOne2oneComposites with id: {}" , tone2onecompositesId);
        TOne2oneComposites tone2oneComposites = tOne2oneCompositesService.getById(tone2onecompositesId);
        LOGGER.debug("TOne2oneComposites details with id: {}" , tone2oneComposites);

        return tone2oneComposites;
    }



    @ApiOperation(value = "Updates the TOne2oneComposites instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public TOne2oneComposites editTOne2oneComposites(@RequestParam("byteId") Short byteId,@RequestParam("shortId") Short shortId,@RequestParam("charId") String charId,@RequestParam("stringId") String stringId, @RequestBody TOne2oneComposites tone2oneComposites) throws EntityNotFoundException {

        tone2oneComposites.setByteId(byteId);
        tone2oneComposites.setShortId(shortId);
        tone2oneComposites.setCharId(charId);
        tone2oneComposites.setStringId(stringId);

        LOGGER.debug("TOne2oneComposites details with id is updated with: {}" , tone2oneComposites);

        return tOne2oneCompositesService.update(tone2oneComposites);
    }


    @ApiOperation(value = "Deletes the TOne2oneComposites instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteTOne2oneComposites(@RequestParam("byteId") Short byteId,@RequestParam("shortId") Short shortId,@RequestParam("charId") String charId,@RequestParam("stringId") String stringId) throws EntityNotFoundException {

        TOne2oneComposites1Id tone2onecompositesId = new TOne2oneComposites1Id();
        tone2onecompositesId.setByteId(byteId);
        tone2onecompositesId.setShortId(shortId);
        tone2onecompositesId.setCharId(charId);
        tone2onecompositesId.setStringId(stringId);

        LOGGER.debug("Deleting TOne2oneComposites with id: {}" , tone2onecompositesId);
        TOne2oneComposites tone2oneComposites = tOne2oneCompositesService.delete(tone2onecompositesId);

        return tone2oneComposites != null;
    }


    /**
     * @deprecated Use {@link #findTOne2oneComposites(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of TOne2oneComposites instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TOne2oneComposites> searchTOne2oneCompositesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering TOne2oneComposites list");
        return tOne2oneCompositesService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of TOne2oneComposites instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TOne2oneComposites> findTOne2oneComposites(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TOne2oneComposites list");
        return tOne2oneCompositesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of TOne2oneComposites instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<TOne2oneComposites> filterTOne2oneComposites(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TOne2oneComposites list");
        return tOne2oneCompositesService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportTOne2oneComposites(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return tOne2oneCompositesService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of TOne2oneComposites instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countTOne2oneComposites( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting TOne2oneComposites");
		return tOne2oneCompositesService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getTOne2oneCompositesAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return tOne2oneCompositesService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TOne2oneCompositesService instance
	 */
	protected void setTOne2oneCompositesService(TOne2oneCompositesService service) {
		this.tOne2oneCompositesService = service;
	}

}

