/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing15thnov_stage.db123__.service;

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

import com.testing15thnov_stage.db123__.ViewDefaultValues;
import com.testing15thnov_stage.db123__.ViewDefaultValuesId;

/**
 * Service object for domain model class {@link ViewDefaultValues}.
 */
public interface ViewDefaultValuesService {

    /**
     * Creates a new ViewDefaultValues. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on ViewDefaultValues if any.
     *
     * @param viewDefaultValues Details of the ViewDefaultValues to be created; value cannot be null.
     * @return The newly created ViewDefaultValues.
     */
	ViewDefaultValues create(@Valid ViewDefaultValues viewDefaultValues);


	/**
	 * Returns ViewDefaultValues by given id if exists.
	 *
	 * @param viewdefaultvaluesId The id of the ViewDefaultValues to get; value cannot be null.
	 * @return ViewDefaultValues associated with the given viewdefaultvaluesId.
     * @throws EntityNotFoundException If no ViewDefaultValues is found.
	 */
	ViewDefaultValues getById(ViewDefaultValuesId viewdefaultvaluesId) throws EntityNotFoundException;

    /**
	 * Find and return the ViewDefaultValues by given id if exists, returns null otherwise.
	 *
	 * @param viewdefaultvaluesId The id of the ViewDefaultValues to get; value cannot be null.
	 * @return ViewDefaultValues associated with the given viewdefaultvaluesId.
	 */
	ViewDefaultValues findById(ViewDefaultValuesId viewdefaultvaluesId);


	/**
	 * Updates the details of an existing ViewDefaultValues. It replaces all fields of the existing ViewDefaultValues with the given viewDefaultValues.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on ViewDefaultValues if any.
     *
	 * @param viewDefaultValues The details of the ViewDefaultValues to be updated; value cannot be null.
	 * @return The updated ViewDefaultValues.
	 * @throws EntityNotFoundException if no ViewDefaultValues is found with given input.
	 */
	ViewDefaultValues update(@Valid ViewDefaultValues viewDefaultValues) throws EntityNotFoundException;

    /**
	 * Deletes an existing ViewDefaultValues with the given id.
	 *
	 * @param viewdefaultvaluesId The id of the ViewDefaultValues to be deleted; value cannot be null.
	 * @return The deleted ViewDefaultValues.
	 * @throws EntityNotFoundException if no ViewDefaultValues found with the given id.
	 */
	ViewDefaultValues delete(ViewDefaultValuesId viewdefaultvaluesId) throws EntityNotFoundException;

	/**
	 * Find all ViewDefaultValues matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching ViewDefaultValues.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<ViewDefaultValues> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all ViewDefaultValues matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching ViewDefaultValues.
     *
     * @see Pageable
     * @see Page
	 */
    Page<ViewDefaultValues> findAll(String query, Pageable pageable);

    /**
	 * Exports all ViewDefaultValues matching the given input query to the given exportType format.
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
	 * Retrieve the count of the ViewDefaultValues in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the ViewDefaultValues.
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

