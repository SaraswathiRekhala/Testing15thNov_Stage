/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing15thnov_stage.sample.service;

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

import com.testing15thnov_stage.sample.Testrelorder;
import com.testing15thnov_stage.sample.TestrelorderId;

/**
 * Service object for domain model class {@link Testrelorder}.
 */
public interface TestrelorderService {

    /**
     * Creates a new Testrelorder. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Testrelorder if any.
     *
     * @param testrelorder Details of the Testrelorder to be created; value cannot be null.
     * @return The newly created Testrelorder.
     */
	Testrelorder create(@Valid Testrelorder testrelorder);


	/**
	 * Returns Testrelorder by given id if exists.
	 *
	 * @param testrelorderId The id of the Testrelorder to get; value cannot be null.
	 * @return Testrelorder associated with the given testrelorderId.
     * @throws EntityNotFoundException If no Testrelorder is found.
	 */
	Testrelorder getById(TestrelorderId testrelorderId) throws EntityNotFoundException;

    /**
	 * Find and return the Testrelorder by given id if exists, returns null otherwise.
	 *
	 * @param testrelorderId The id of the Testrelorder to get; value cannot be null.
	 * @return Testrelorder associated with the given testrelorderId.
	 */
	Testrelorder findById(TestrelorderId testrelorderId);


	/**
	 * Updates the details of an existing Testrelorder. It replaces all fields of the existing Testrelorder with the given testrelorder.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Testrelorder if any.
     *
	 * @param testrelorder The details of the Testrelorder to be updated; value cannot be null.
	 * @return The updated Testrelorder.
	 * @throws EntityNotFoundException if no Testrelorder is found with given input.
	 */
	Testrelorder update(@Valid Testrelorder testrelorder) throws EntityNotFoundException;

    /**
	 * Deletes an existing Testrelorder with the given id.
	 *
	 * @param testrelorderId The id of the Testrelorder to be deleted; value cannot be null.
	 * @return The deleted Testrelorder.
	 * @throws EntityNotFoundException if no Testrelorder found with the given id.
	 */
	Testrelorder delete(TestrelorderId testrelorderId) throws EntityNotFoundException;

	/**
	 * Find all Testrelorders matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Testrelorders.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Testrelorder> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Testrelorders matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Testrelorders.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Testrelorder> findAll(String query, Pageable pageable);

    /**
	 * Exports all Testrelorders matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Testrelorders in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Testrelorder.
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

