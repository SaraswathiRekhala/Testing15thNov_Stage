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

import com.testing15thnov_stage.dbscenarios.AutoWireProcedure1000nullTitles;

/**
 * Service object for domain model class {@link AutoWireProcedure1000nullTitles}.
 */
public interface AutoWireProcedure1000nullTitlesService {

    /**
     * Creates a new AutoWireProcedure1000nullTitles. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on AutoWireProcedure1000nullTitles if any.
     *
     * @param autoWireProcedure1000nullTitles Details of the AutoWireProcedure1000nullTitles to be created; value cannot be null.
     * @return The newly created AutoWireProcedure1000nullTitles.
     */
	AutoWireProcedure1000nullTitles create(@Valid AutoWireProcedure1000nullTitles autoWireProcedure1000nullTitles);


	/**
	 * Returns AutoWireProcedure1000nullTitles by given id if exists.
	 *
	 * @param autowireprocedure1000nulltitlesId The id of the AutoWireProcedure1000nullTitles to get; value cannot be null.
	 * @return AutoWireProcedure1000nullTitles associated with the given autowireprocedure1000nulltitlesId.
     * @throws EntityNotFoundException If no AutoWireProcedure1000nullTitles is found.
	 */
	AutoWireProcedure1000nullTitles getById(Integer autowireprocedure1000nulltitlesId) throws EntityNotFoundException;

    /**
	 * Find and return the AutoWireProcedure1000nullTitles by given id if exists, returns null otherwise.
	 *
	 * @param autowireprocedure1000nulltitlesId The id of the AutoWireProcedure1000nullTitles to get; value cannot be null.
	 * @return AutoWireProcedure1000nullTitles associated with the given autowireprocedure1000nulltitlesId.
	 */
	AutoWireProcedure1000nullTitles findById(Integer autowireprocedure1000nulltitlesId);


	/**
	 * Updates the details of an existing AutoWireProcedure1000nullTitles. It replaces all fields of the existing AutoWireProcedure1000nullTitles with the given autoWireProcedure1000nullTitles.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on AutoWireProcedure1000nullTitles if any.
     *
	 * @param autoWireProcedure1000nullTitles The details of the AutoWireProcedure1000nullTitles to be updated; value cannot be null.
	 * @return The updated AutoWireProcedure1000nullTitles.
	 * @throws EntityNotFoundException if no AutoWireProcedure1000nullTitles is found with given input.
	 */
	AutoWireProcedure1000nullTitles update(@Valid AutoWireProcedure1000nullTitles autoWireProcedure1000nullTitles) throws EntityNotFoundException;

    /**
	 * Deletes an existing AutoWireProcedure1000nullTitles with the given id.
	 *
	 * @param autowireprocedure1000nulltitlesId The id of the AutoWireProcedure1000nullTitles to be deleted; value cannot be null.
	 * @return The deleted AutoWireProcedure1000nullTitles.
	 * @throws EntityNotFoundException if no AutoWireProcedure1000nullTitles found with the given id.
	 */
	AutoWireProcedure1000nullTitles delete(Integer autowireprocedure1000nulltitlesId) throws EntityNotFoundException;

	/**
	 * Find all AutoWireProcedure1000nullTitles matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching AutoWireProcedure1000nullTitles.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<AutoWireProcedure1000nullTitles> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all AutoWireProcedure1000nullTitles matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching AutoWireProcedure1000nullTitles.
     *
     * @see Pageable
     * @see Page
	 */
    Page<AutoWireProcedure1000nullTitles> findAll(String query, Pageable pageable);

    /**
	 * Exports all AutoWireProcedure1000nullTitles matching the given input query to the given exportType format.
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
	 * Retrieve the count of the AutoWireProcedure1000nullTitles in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the AutoWireProcedure1000nullTitles.
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

