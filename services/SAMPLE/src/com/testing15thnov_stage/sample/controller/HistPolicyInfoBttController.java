/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing15thnov_stage.sample.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.sql.Date;
import java.sql.Timestamp;
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

import com.testing15thnov_stage.sample.HistPolicyInfoBtt;
import com.testing15thnov_stage.sample.HistPolicyInfoBttId;
import com.testing15thnov_stage.sample.service.HistPolicyInfoBttService;


/**
 * Controller object for domain model class HistPolicyInfoBtt.
 * @see HistPolicyInfoBtt
 */
@RestController("SAMPLE.HistPolicyInfoBttController")
@Api(value = "HistPolicyInfoBttController", description = "Exposes APIs to work with HistPolicyInfoBtt resource.")
@RequestMapping("/SAMPLE/HistPolicyInfoBtt")
public class HistPolicyInfoBttController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HistPolicyInfoBttController.class);

    @Autowired
	@Qualifier("SAMPLE.HistPolicyInfoBttService")
	private HistPolicyInfoBttService histPolicyInfoBttService;

	@ApiOperation(value = "Creates a new HistPolicyInfoBtt instance.")
@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public HistPolicyInfoBtt createHistPolicyInfoBtt(@RequestBody HistPolicyInfoBtt histPolicyInfoBtt) {
		LOGGER.debug("Create HistPolicyInfoBtt with information: {}" , histPolicyInfoBtt);

		histPolicyInfoBtt = histPolicyInfoBttService.create(histPolicyInfoBtt);
		LOGGER.debug("Created HistPolicyInfoBtt with information: {}" , histPolicyInfoBtt);

	    return histPolicyInfoBtt;
	}

@ApiOperation(value = "Returns the HistPolicyInfoBtt instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public HistPolicyInfoBtt getHistPolicyInfoBtt(@RequestParam("policyId") String policyId,@RequestParam("coverage") Integer coverage,@RequestParam("busStart") Date busStart,@RequestParam("busEnd") Date busEnd,@RequestParam("sysStart") Timestamp sysStart,@RequestParam("sysEnd") Timestamp sysEnd,@RequestParam("tsId") Timestamp tsId) throws EntityNotFoundException {

        HistPolicyInfoBttId histpolicyinfobttId = new HistPolicyInfoBttId();
        histpolicyinfobttId.setPolicyId(policyId);
        histpolicyinfobttId.setCoverage(coverage);
        histpolicyinfobttId.setBusStart(busStart);
        histpolicyinfobttId.setBusEnd(busEnd);
        histpolicyinfobttId.setSysStart(sysStart);
        histpolicyinfobttId.setSysEnd(sysEnd);
        histpolicyinfobttId.setTsId(tsId);

        LOGGER.debug("Getting HistPolicyInfoBtt with id: {}" , histpolicyinfobttId);
        HistPolicyInfoBtt histPolicyInfoBtt = histPolicyInfoBttService.getById(histpolicyinfobttId);
        LOGGER.debug("HistPolicyInfoBtt details with id: {}" , histPolicyInfoBtt);

        return histPolicyInfoBtt;
    }



    @ApiOperation(value = "Updates the HistPolicyInfoBtt instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public HistPolicyInfoBtt editHistPolicyInfoBtt(@RequestParam("policyId") String policyId,@RequestParam("coverage") Integer coverage,@RequestParam("busStart") Date busStart,@RequestParam("busEnd") Date busEnd,@RequestParam("sysStart") Timestamp sysStart,@RequestParam("sysEnd") Timestamp sysEnd,@RequestParam("tsId") Timestamp tsId, @RequestBody HistPolicyInfoBtt histPolicyInfoBtt) throws EntityNotFoundException {

        histPolicyInfoBtt.setPolicyId(policyId);
        histPolicyInfoBtt.setCoverage(coverage);
        histPolicyInfoBtt.setBusStart(busStart);
        histPolicyInfoBtt.setBusEnd(busEnd);
        histPolicyInfoBtt.setSysStart(sysStart);
        histPolicyInfoBtt.setSysEnd(sysEnd);
        histPolicyInfoBtt.setTsId(tsId);

        LOGGER.debug("HistPolicyInfoBtt details with id is updated with: {}" , histPolicyInfoBtt);

        return histPolicyInfoBttService.update(histPolicyInfoBtt);
    }


    @ApiOperation(value = "Deletes the HistPolicyInfoBtt instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteHistPolicyInfoBtt(@RequestParam("policyId") String policyId,@RequestParam("coverage") Integer coverage,@RequestParam("busStart") Date busStart,@RequestParam("busEnd") Date busEnd,@RequestParam("sysStart") Timestamp sysStart,@RequestParam("sysEnd") Timestamp sysEnd,@RequestParam("tsId") Timestamp tsId) throws EntityNotFoundException {

        HistPolicyInfoBttId histpolicyinfobttId = new HistPolicyInfoBttId();
        histpolicyinfobttId.setPolicyId(policyId);
        histpolicyinfobttId.setCoverage(coverage);
        histpolicyinfobttId.setBusStart(busStart);
        histpolicyinfobttId.setBusEnd(busEnd);
        histpolicyinfobttId.setSysStart(sysStart);
        histpolicyinfobttId.setSysEnd(sysEnd);
        histpolicyinfobttId.setTsId(tsId);

        LOGGER.debug("Deleting HistPolicyInfoBtt with id: {}" , histpolicyinfobttId);
        HistPolicyInfoBtt histPolicyInfoBtt = histPolicyInfoBttService.delete(histpolicyinfobttId);

        return histPolicyInfoBtt != null;
    }


    /**
     * @deprecated Use {@link #findHistPolicyInfoBtts(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of HistPolicyInfoBtt instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<HistPolicyInfoBtt> searchHistPolicyInfoBttsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering HistPolicyInfoBtts list");
        return histPolicyInfoBttService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of HistPolicyInfoBtt instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<HistPolicyInfoBtt> findHistPolicyInfoBtts(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering HistPolicyInfoBtts list");
        return histPolicyInfoBttService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of HistPolicyInfoBtt instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<HistPolicyInfoBtt> filterHistPolicyInfoBtts(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering HistPolicyInfoBtts list");
        return histPolicyInfoBttService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportHistPolicyInfoBtts(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return histPolicyInfoBttService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of HistPolicyInfoBtt instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countHistPolicyInfoBtts( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting HistPolicyInfoBtts");
		return histPolicyInfoBttService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getHistPolicyInfoBttAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return histPolicyInfoBttService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service HistPolicyInfoBttService instance
	 */
	protected void setHistPolicyInfoBttService(HistPolicyInfoBttService service) {
		this.histPolicyInfoBttService = service;
	}

}

