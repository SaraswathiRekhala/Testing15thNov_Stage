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

import com.testing15thnov_stage.dbscenarios.Table33;

/**
 * Service object for domain model class {@link Table33}.
 */
public interface Table33Service {

    /**
     * Creates a new Table33. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Table33 if any.
     *
     * @param table33 Details of the Table33 to be created; value cannot be null.
     * @return The newly created Table33.
     */
	Table33 create(@Valid Table33 table33);


	/**
	 * Returns Table33 by given id if exists.
	 *
	 * @param table33Id The id of the Table33 to get; value cannot be null.
	 * @return Table33 associated with the given table33Id.
     * @throws EntityNotFoundException If no Table33 is found.
	 */
	Table33 getById(String table33Id) throws EntityNotFoundException;

    /**
	 * Find and return the Table33 by given id if exists, returns null otherwise.
	 *
	 * @param table33Id The id of the Table33 to get; value cannot be null.
	 * @return Table33 associated with the given table33Id.
	 */
	Table33 findById(String table33Id);


	/**
	 * Updates the details of an existing Table33. It replaces all fields of the existing Table33 with the given table33.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Table33 if any.
     *
	 * @param table33 The details of the Table33 to be updated; value cannot be null.
	 * @return The updated Table33.
	 * @throws EntityNotFoundException if no Table33 is found with given input.
	 */
	Table33 update(@Valid Table33 table33) throws EntityNotFoundException;

    /**
	 * Deletes an existing Table33 with the given id.
	 *
	 * @param table33Id The id of the Table33 to be deleted; value cannot be null.
	 * @return The deleted Table33.
	 * @throws EntityNotFoundException if no Table33 found with the given id.
	 */
	Table33 delete(String table33Id) throws EntityNotFoundException;

	/**
	 * Find all Table33s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Table33s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Table33> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Table33s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Table33s.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Table33> findAll(String query, Pageable pageable);

    /**
	 * Exports all Table33s matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Table33s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Table33.
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
