/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing15thnov_stage.sample.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.TypeMismatchException;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.DownloadResponse;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.runtime.util.WMMultipartUtils;
import com.wavemaker.runtime.util.WMRuntimeUtils;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.testing15thnov_stage.sample.AlltypesDb;
import com.testing15thnov_stage.sample.service.AlltypesDbService;


/**
 * Controller object for domain model class AlltypesDb.
 * @see AlltypesDb
 */
@RestController("SAMPLE.AlltypesDbController")
@Api(value = "AlltypesDbController", description = "Exposes APIs to work with AlltypesDb resource.")
@RequestMapping("/SAMPLE/AlltypesDb")
public class AlltypesDbController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlltypesDbController.class);

    @Autowired
	@Qualifier("SAMPLE.AlltypesDbService")
	private AlltypesDbService alltypesDbService;

	@ApiOperation(value = "Creates a new AlltypesDb instance.")
@RequestMapping(method = RequestMethod.POST, consumes = "multipart/form-data")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public AlltypesDb createAlltypesDb(@RequestPart("wm_data_json") AlltypesDb alltypesDb, @RequestPart(value = "binaryLargeObjectCol", required = false) MultipartFile _binaryLargeObjectCol, @RequestPart(value = "blobCol", required = false) MultipartFile _blobCol) {
		LOGGER.debug("Create AlltypesDb with information: {}" , alltypesDb);

    alltypesDb.setBinaryLargeObjectCol(WMMultipartUtils.toByteArray(_binaryLargeObjectCol));
    alltypesDb.setBlobCol(WMMultipartUtils.toByteArray(_blobCol));
		alltypesDb = alltypesDbService.create(alltypesDb);
		LOGGER.debug("Created AlltypesDb with information: {}" , alltypesDb);

	    return alltypesDb;
	}

    @ApiOperation(value = "Returns the AlltypesDb instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public AlltypesDb getAlltypesDb(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting AlltypesDb with id: {}" , id);

        AlltypesDb foundAlltypesDb = alltypesDbService.getById(id);
        LOGGER.debug("AlltypesDb details with id: {}" , foundAlltypesDb);

        return foundAlltypesDb;
    }

    @ApiOperation(value = "Retrieves content for the given BLOB field in AlltypesDb instance" )
    @RequestMapping(value = "/{id}/content/{fieldName}", method = RequestMethod.GET, produces="application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DownloadResponse getAlltypesDbBLOBContent(@PathVariable("id") Integer id, @PathVariable("fieldName") String fieldName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam(value="download", defaultValue = "false") boolean download) {

        LOGGER.debug("Retrieves content for the given BLOB field {} in AlltypesDb instance" , fieldName);

        if(!WMRuntimeUtils.isLob(AlltypesDb.class, fieldName)) {
            throw new TypeMismatchException("Given field " + fieldName + " is not a valid BLOB type");
        }
        AlltypesDb alltypesDb = alltypesDbService.getById(id);

        return WMMultipartUtils.buildDownloadResponseForBlob(alltypesDb, fieldName, httpServletRequest, download);
    }

    @ApiOperation(value = "Updates the AlltypesDb instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public AlltypesDb editAlltypesDb(@PathVariable("id") Integer id, @RequestBody AlltypesDb alltypesDb) throws EntityNotFoundException {
        LOGGER.debug("Editing AlltypesDb with id: {}" , alltypesDb.getIntCol());

        alltypesDb.setIntCol(id);
        alltypesDb = alltypesDbService.update(alltypesDb);
        LOGGER.debug("AlltypesDb details with id: {}" , alltypesDb);

        return alltypesDb;
    }

    @ApiOperation(value = "Updates the AlltypesDb instance associated with the given id.This API should be used when AlltypesDb instance fields that require multipart data.") 
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public AlltypesDb editAlltypesDb(@PathVariable("id") Integer id, MultipartHttpServletRequest multipartHttpServletRequest) throws EntityNotFoundException {
        AlltypesDb newAlltypesDb = WMMultipartUtils.toObject(multipartHttpServletRequest, AlltypesDb.class, "SAMPLE");
        newAlltypesDb.setIntCol(id);

        AlltypesDb oldAlltypesDb = alltypesDbService.getById(id);
        WMMultipartUtils.updateLobsContent(oldAlltypesDb, newAlltypesDb);
        LOGGER.debug("Updating AlltypesDb with information: {}" , newAlltypesDb);

        return alltypesDbService.update(newAlltypesDb);
    }

    @ApiOperation(value = "Deletes the AlltypesDb instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteAlltypesDb(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting AlltypesDb with id: {}" , id);

        AlltypesDb deletedAlltypesDb = alltypesDbService.delete(id);

        return deletedAlltypesDb != null;
    }

    /**
     * @deprecated Use {@link #findAlltypesDbs(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of AlltypesDb instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<AlltypesDb> searchAlltypesDbsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering AlltypesDbs list");
        return alltypesDbService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of AlltypesDb instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<AlltypesDb> findAlltypesDbs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering AlltypesDbs list");
        return alltypesDbService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of AlltypesDb instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<AlltypesDb> filterAlltypesDbs(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering AlltypesDbs list");
        return alltypesDbService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportAlltypesDbs(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return alltypesDbService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of AlltypesDb instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countAlltypesDbs( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting AlltypesDbs");
		return alltypesDbService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getAlltypesDbAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return alltypesDbService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service AlltypesDbService instance
	 */
	protected void setAlltypesDbService(AlltypesDbService service) {
		this.alltypesDbService = service;
	}

}

