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

import com.testing15thnov_stage.dbscenarios.TimestampCol;

/**
 * Service object for domain model class {@link TimestampCol}.
 */
public interface TimestampColService {

    /**
     * Creates a new TimestampCol. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on TimestampCol if any.
     *
     * @param timestampCol Details of the TimestampCol to be created; value cannot be null.
     * @return The newly created TimestampCol.
     */
	TimestampCol create(@Valid TimestampCol timestampCol);


	/**
	 * Returns TimestampCol by given id if exists.
	 *
	 * @param timestampcolId The id of the TimestampCol to get; value cannot be null.
	 * @return TimestampCol associated with the given timestampcolId.
     * @throws EntityNotFoundException If no TimestampCol is found.
	 */
	TimestampCol getById(Integer timestampcolId) throws EntityNotFoundException;

    /**
	 * Find and return the TimestampCol by given id if exists, returns null otherwise.
	 *
	 * @param timestampcolId The id of the TimestampCol to get; value cannot be null.
	 * @return TimestampCol associated with the given timestampcolId.
	 */
	TimestampCol findById(Integer timestampcolId);


	/**
	 * Updates the details of an existing TimestampCol. It replaces all fields of the existing TimestampCol with the given timestampCol.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on TimestampCol if any.
     *
	 * @param timestampCol The details of the TimestampCol to be updated; value cannot be null.
	 * @return The updated TimestampCol.
	 * @throws EntityNotFoundException if no TimestampCol is found with given input.
	 */
	TimestampCol update(@Valid TimestampCol timestampCol) throws EntityNotFoundException;

    /**
	 * Deletes an existing TimestampCol with the given id.
	 *
	 * @param timestampcolId The id of the TimestampCol to be deleted; value cannot be null.
	 * @return The deleted TimestampCol.
	 * @throws EntityNotFoundException if no TimestampCol found with the given id.
	 */
	TimestampCol delete(Integer timestampcolId) throws EntityNotFoundException;

	/**
	 * Find all TimestampCols matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TimestampCols.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<TimestampCol> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all TimestampCols matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TimestampCols.
     *
     * @see Pageable
     * @see Page
	 */
    Page<TimestampCol> findAll(String query, Pageable pageable);

    /**
	 * Exports all TimestampCols matching the given input query to the given exportType format.
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
	 * Retrieve the count of the TimestampCols in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the TimestampCol.
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

