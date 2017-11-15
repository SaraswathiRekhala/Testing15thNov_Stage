/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing15thnov_stage.dbscenarios.controller;

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

import com.testing15thnov_stage.dbscenarios.UserLogin;
import com.testing15thnov_stage.dbscenarios.service.UserLoginService;


/**
 * Controller object for domain model class UserLogin.
 * @see UserLogin
 */
@RestController("dbscenarios.UserLoginController")
@Api(value = "UserLoginController", description = "Exposes APIs to work with UserLogin resource.")
@RequestMapping("/dbscenarios/UserLogin")
public class UserLoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginController.class);

    @Autowired
	@Qualifier("dbscenarios.UserLoginService")
	private UserLoginService userLoginService;

	@ApiOperation(value = "Creates a new UserLogin instance.")
@RequestMapping(method = RequestMethod.POST, consumes = "multipart/form-data")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public UserLogin createUserLogin(@RequestPart("wm_data_json") UserLogin userLogin, @RequestPart(value = "profile", required = false) MultipartFile _profile) {
		LOGGER.debug("Create UserLogin with information: {}" , userLogin);

    userLogin.setProfile(WMMultipartUtils.toByteArray(_profile));
		userLogin = userLoginService.create(userLogin);
		LOGGER.debug("Created UserLogin with information: {}" , userLogin);

	    return userLogin;
	}

    @ApiOperation(value = "Returns the UserLogin instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UserLogin getUserLogin(@PathVariable("id") Short id) throws EntityNotFoundException {
        LOGGER.debug("Getting UserLogin with id: {}" , id);

        UserLogin foundUserLogin = userLoginService.getById(id);
        LOGGER.debug("UserLogin details with id: {}" , foundUserLogin);

        return foundUserLogin;
    }

    @ApiOperation(value = "Retrieves content for the given BLOB field in UserLogin instance" )
    @RequestMapping(value = "/{id}/content/{fieldName}", method = RequestMethod.GET, produces="application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DownloadResponse getUserLoginBLOBContent(@PathVariable("id") Short id, @PathVariable("fieldName") String fieldName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam(value="download", defaultValue = "false") boolean download) {

        LOGGER.debug("Retrieves content for the given BLOB field {} in UserLogin instance" , fieldName);

        if(!WMRuntimeUtils.isLob(UserLogin.class, fieldName)) {
            throw new TypeMismatchException("Given field " + fieldName + " is not a valid BLOB type");
        }
        UserLogin userLogin = userLoginService.getById(id);

        return WMMultipartUtils.buildDownloadResponseForBlob(userLogin, fieldName, httpServletRequest, download);
    }

    @ApiOperation(value = "Updates the UserLogin instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UserLogin editUserLogin(@PathVariable("id") Short id, @RequestBody UserLogin userLogin) throws EntityNotFoundException {
        LOGGER.debug("Editing UserLogin with id: {}" , userLogin.getUserId());

        userLogin.setUserId(id);
        userLogin = userLoginService.update(userLogin);
        LOGGER.debug("UserLogin details with id: {}" , userLogin);

        return userLogin;
    }

    @ApiOperation(value = "Updates the UserLogin instance associated with the given id.This API should be used when UserLogin instance fields that require multipart data.") 
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public UserLogin editUserLogin(@PathVariable("id") Short id, MultipartHttpServletRequest multipartHttpServletRequest) throws EntityNotFoundException {
        UserLogin newUserLogin = WMMultipartUtils.toObject(multipartHttpServletRequest, UserLogin.class, "dbscenarios");
        newUserLogin.setUserId(id);

        UserLogin oldUserLogin = userLoginService.getById(id);
        WMMultipartUtils.updateLobsContent(oldUserLogin, newUserLogin);
        LOGGER.debug("Updating UserLogin with information: {}" , newUserLogin);

        return userLoginService.update(newUserLogin);
    }

    @ApiOperation(value = "Deletes the UserLogin instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteUserLogin(@PathVariable("id") Short id) throws EntityNotFoundException {
        LOGGER.debug("Deleting UserLogin with id: {}" , id);

        UserLogin deletedUserLogin = userLoginService.delete(id);

        return deletedUserLogin != null;
    }

    /**
     * @deprecated Use {@link #findUserLogins(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of UserLogin instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<UserLogin> searchUserLoginsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering UserLogins list");
        return userLoginService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of UserLogin instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<UserLogin> findUserLogins(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering UserLogins list");
        return userLoginService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of UserLogin instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<UserLogin> filterUserLogins(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering UserLogins list");
        return userLoginService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportUserLogins(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return userLoginService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of UserLogin instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countUserLogins( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting UserLogins");
		return userLoginService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getUserLoginAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return userLoginService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service UserLoginService instance
	 */
	protected void setUserLoginService(UserLoginService service) {
		this.userLoginService = service;
	}

}

