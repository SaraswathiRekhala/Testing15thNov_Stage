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

import com.testing15thnov_stage.dbscenarios.TOne2oneComposites1;
import com.testing15thnov_stage.dbscenarios.TOne2oneComposites1Id;

/**
 * Service object for domain model class {@link TOne2oneComposites1}.
 */
public interface TOne2oneComposites1Service {

    /**
     * Creates a new TOne2oneComposites1. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on TOne2oneComposites1 if any.
     *
     * @param tone2oneComposites1 Details of the TOne2oneComposites1 to be created; value cannot be null.
     * @return The newly created TOne2oneComposites1.
     */
	TOne2oneComposites1 create(@Valid TOne2oneComposites1 tone2oneComposites1);


	/**
	 * Returns TOne2oneComposites1 by given id if exists.
	 *
	 * @param tone2onecomposites1Id The id of the TOne2oneComposites1 to get; value cannot be null.
	 * @return TOne2oneComposites1 associated with the given tone2onecomposites1Id.
     * @throws EntityNotFoundException If no TOne2oneComposites1 is found.
	 */
	TOne2oneComposites1 getById(TOne2oneComposites1Id tone2onecomposites1Id) throws EntityNotFoundException;

    /**
	 * Find and return the TOne2oneComposites1 by given id if exists, returns null otherwise.
	 *
	 * @param tone2onecomposites1Id The id of the TOne2oneComposites1 to get; value cannot be null.
	 * @return TOne2oneComposites1 associated with the given tone2onecomposites1Id.
	 */
	TOne2oneComposites1 findById(TOne2oneComposites1Id tone2onecomposites1Id);


	/**
	 * Updates the details of an existing TOne2oneComposites1. It replaces all fields of the existing TOne2oneComposites1 with the given tone2oneComposites1.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on TOne2oneComposites1 if any.
     *
	 * @param tone2oneComposites1 The details of the TOne2oneComposites1 to be updated; value cannot be null.
	 * @return The updated TOne2oneComposites1.
	 * @throws EntityNotFoundException if no TOne2oneComposites1 is found with given input.
	 */
	TOne2oneComposites1 update(@Valid TOne2oneComposites1 tone2oneComposites1) throws EntityNotFoundException;

    /**
	 * Deletes an existing TOne2oneComposites1 with the given id.
	 *
	 * @param tone2onecomposites1Id The id of the TOne2oneComposites1 to be deleted; value cannot be null.
	 * @return The deleted TOne2oneComposites1.
	 * @throws EntityNotFoundException if no TOne2oneComposites1 found with the given id.
	 */
	TOne2oneComposites1 delete(TOne2oneComposites1Id tone2onecomposites1Id) throws EntityNotFoundException;

	/**
	 * Find all TOne2oneComposites1s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TOne2oneComposites1s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<TOne2oneComposites1> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all TOne2oneComposites1s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TOne2oneComposites1s.
     *
     * @see Pageable
     * @see Page
	 */
    Page<TOne2oneComposites1> findAll(String query, Pageable pageable);

    /**
	 * Exports all TOne2oneComposites1s matching the given input query to the given exportType format.
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
	 * Retrieve the count of the TOne2oneComposites1s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the TOne2oneComposites1.
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

