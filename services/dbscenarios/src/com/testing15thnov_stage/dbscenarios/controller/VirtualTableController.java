/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing15thnov_stage.dbscenarios.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.math.BigDecimal;
import java.sql.Date;
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

import com.testing15thnov_stage.dbscenarios.VirtualTable;
import com.testing15thnov_stage.dbscenarios.VirtualTableId;
import com.testing15thnov_stage.dbscenarios.service.VirtualTableService;


/**
 * Controller object for domain model class VirtualTable.
 * @see VirtualTable
 */
@RestController("dbscenarios.VirtualTableController")
@Api(value = "VirtualTableController", description = "Exposes APIs to work with VirtualTable resource.")
@RequestMapping("/dbscenarios/VirtualTable")
public class VirtualTableController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VirtualTableController.class);

    @Autowired
	@Qualifier("dbscenarios.VirtualTableService")
	private VirtualTableService virtualTableService;

	@ApiOperation(value = "Creates a new VirtualTable instance.")
@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public VirtualTable createVirtualTable(@RequestBody VirtualTable virtualTable) {
		LOGGER.debug("Create VirtualTable with information: {}" , virtualTable);

		virtualTable = virtualTableService.create(virtualTable);
		LOGGER.debug("Created VirtualTable with information: {}" , virtualTable);

	    return virtualTable;
	}

@ApiOperation(value = "Returns the VirtualTable instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public VirtualTable getVirtualTable(@RequestParam("charCol") String charCol,@RequestParam("dateCol") Date dateCol,@RequestParam("doubleCol") BigDecimal doubleCol,@RequestParam("bigdecCol") BigDecimal bigdecCol,@RequestParam("stringCol") String stringCol,@RequestParam("shortcol") Short shortcol) throws EntityNotFoundException {

        VirtualTableId virtualtableId = new VirtualTableId();
        virtualtableId.setCharCol(charCol);
        virtualtableId.setDateCol(dateCol);
        virtualtableId.setDoubleCol(doubleCol);
        virtualtableId.setBigdecCol(bigdecCol);
        virtualtableId.setStringCol(stringCol);
        virtualtableId.setShortcol(shortcol);

        LOGGER.debug("Getting VirtualTable with id: {}" , virtualtableId);
        VirtualTable virtualTable = virtualTableService.getById(virtualtableId);
        LOGGER.debug("VirtualTable details with id: {}" , virtualTable);

        return virtualTable;
    }



    @ApiOperation(value = "Updates the VirtualTable instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public VirtualTable editVirtualTable(@RequestParam("charCol") String charCol,@RequestParam("dateCol") Date dateCol,@RequestParam("doubleCol") BigDecimal doubleCol,@RequestParam("bigdecCol") BigDecimal bigdecCol,@RequestParam("stringCol") String stringCol,@RequestParam("shortcol") Short shortcol, @RequestBody VirtualTable virtualTable) throws EntityNotFoundException {

        virtualTable.setCharCol(charCol);
        virtualTable.setDateCol(dateCol);
        virtualTable.setDoubleCol(doubleCol);
        virtualTable.setBigdecCol(bigdecCol);
        virtualTable.setStringCol(stringCol);
        virtualTable.setShortcol(shortcol);

        LOGGER.debug("VirtualTable details with id is updated with: {}" , virtualTable);

        return virtualTableService.update(virtualTable);
    }


    @ApiOperation(value = "Deletes the VirtualTable instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteVirtualTable(@RequestParam("charCol") String charCol,@RequestParam("dateCol") Date dateCol,@RequestParam("doubleCol") BigDecimal doubleCol,@RequestParam("bigdecCol") BigDecimal bigdecCol,@RequestParam("stringCol") String stringCol,@RequestParam("shortcol") Short shortcol) throws EntityNotFoundException {

        VirtualTableId virtualtableId = new VirtualTableId();
        virtualtableId.setCharCol(charCol);
        virtualtableId.setDateCol(dateCol);
        virtualtableId.setDoubleCol(doubleCol);
        virtualtableId.setBigdecCol(bigdecCol);
        virtualtableId.setStringCol(stringCol);
        virtualtableId.setShortcol(shortcol);

        LOGGER.debug("Deleting VirtualTable with id: {}" , virtualtableId);
        VirtualTable virtualTable = virtualTableService.delete(virtualtableId);

        return virtualTable != null;
    }


    @RequestMapping(value = "/shortcol/{shortcol}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching VirtualTable with given unique key values.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public VirtualTable getByShortcol(@PathVariable("shortcol") Short shortcol) {
        LOGGER.debug("Getting VirtualTable with uniques key Shortcol");
        return virtualTableService.getByShortcol(shortcol);
    }

    @RequestMapping(value = "/stringCol-dateCol", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching VirtualTable with given unique key values.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public VirtualTable getByStringColAndDateCol(@RequestParam("stringCol") String stringCol, @RequestParam("dateCol") Date dateCol) {
        LOGGER.debug("Getting VirtualTable with uniques key StringColAndDateCol");
        return virtualTableService.getByStringColAndDateCol(stringCol, dateCol);
    }

    @RequestMapping(value = "/charCol/{charCol}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching VirtualTable with given unique key values.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public VirtualTable getByCharCol(@PathVariable("charCol") String charCol) {
        LOGGER.debug("Getting VirtualTable with uniques key CharCol");
        return virtualTableService.getByCharCol(charCol);
    }

    /**
     * @deprecated Use {@link #findVirtualTables(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of VirtualTable instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<VirtualTable> searchVirtualTablesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering VirtualTables list");
        return virtualTableService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of VirtualTable instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<VirtualTable> findVirtualTables(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering VirtualTables list");
        return virtualTableService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of VirtualTable instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<VirtualTable> filterVirtualTables(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering VirtualTables list");
        return virtualTableService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportVirtualTables(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return virtualTableService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of VirtualTable instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countVirtualTables( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting VirtualTables");
		return virtualTableService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getVirtualTableAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return virtualTableService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service VirtualTableService instance
	 */
	protected void setVirtualTableService(VirtualTableService service) {
		this.virtualTableService = service;
	}

}

