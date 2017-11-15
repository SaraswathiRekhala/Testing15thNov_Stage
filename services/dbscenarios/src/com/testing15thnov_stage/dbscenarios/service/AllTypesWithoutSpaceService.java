/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing15thnov_stage.dbscenarios.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testing15thnov_stage.dbscenarios.AllTypesWithoutSpace;

/**
 * Service object for domain model class {@link AllTypesWithoutSpace}.
 */
public interface AllTypesWithoutSpaceService {

    /**
     * Creates a new AllTypesWithoutSpace. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on AllTypesWithoutSpace if any.
     *
     * @param allTypesWithoutSpace Details of the AllTypesWithoutSpace to be created; value cannot be null.
     * @return The newly created AllTypesWithoutSpace.
     */
	AllTypesWithoutSpace create(@Valid AllTypesWithoutSpace allTypesWithoutSpace);


	/**
	 * Returns AllTypesWithoutSpace by given id if exists.
	 *
	 * @param alltypeswithoutspaceId The id of the AllTypesWithoutSpace to get; value cannot be null.
	 * @return AllTypesWithoutSpace associated with the given alltypeswithoutspaceId.
     * @throws EntityNotFoundException If no AllTypesWithoutSpace is found.
	 */
	AllTypesWithoutSpace getById(Integer alltypeswithoutspaceId) throws EntityNotFoundException;

    /**
	 * Find and return the AllTypesWithoutSpace by given id if exists, returns null otherwise.
	 *
	 * @param alltypeswithoutspaceId The id of the AllTypesWithoutSpace to get; value cannot be null.
	 * @return AllTypesWithoutSpace associated with the given alltypeswithoutspaceId.
	 */
	AllTypesWithoutSpace findById(Integer alltypeswithoutspaceId);


	/**
	 * Updates the details of an existing AllTypesWithoutSpace. It replaces all fields of the existing AllTypesWithoutSpace with the given allTypesWithoutSpace.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on AllTypesWithoutSpace if any.
     *
	 * @param allTypesWithoutSpace The details of the AllTypesWithoutSpace to be updated; value cannot be null.
	 * @return The updated AllTypesWithoutSpace.
	 * @throws EntityNotFoundException if no AllTypesWithoutSpace is found with given input.
	 */
	AllTypesWithoutSpace update(@Valid AllTypesWithoutSpace allTypesWithoutSpace) throws EntityNotFoundException;

    /**
	 * Deletes an existing AllTypesWithoutSpace with the given id.
	 *
	 * @param alltypeswithoutspaceId The id of the AllTypesWithoutSpace to be deleted; value cannot be null.
	 * @return The deleted AllTypesWithoutSpace.
	 * @throws EntityNotFoundException if no AllTypesWithoutSpace found with the given id.
	 */
	AllTypesWithoutSpace delete(Integer alltypeswithoutspaceId) throws EntityNotFoundException;

	/**
	 * Find all AllTypesWithoutSpaces matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching AllTypesWithoutSpaces.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<AllTypesWithoutSpace> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all AllTypesWithoutSpaces matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching AllTypesWithoutSpaces.
     *
     * @see Pageable
     * @see Page
	 */
    Page<AllTypesWithoutSpace> findAll(String query, Pageable pageable);

    /**
	 * Exports all AllTypesWithoutSpaces matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
	 */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the AllTypesWithoutSpaces in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the AllTypesWithoutSpace.
	 */
	long count(String query);

	/**
	 * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
	 * @return Paginated data with included fields.

     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
	Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);


}

