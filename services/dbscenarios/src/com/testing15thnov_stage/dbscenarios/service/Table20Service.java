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

import com.testing15thnov_stage.dbscenarios.Table20;

/**
 * Service object for domain model class {@link Table20}.
 */
public interface Table20Service {

    /**
     * Creates a new Table20. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Table20 if any.
     *
     * @param table20 Details of the Table20 to be created; value cannot be null.
     * @return The newly created Table20.
     */
	Table20 create(@Valid Table20 table20);


	/**
	 * Returns Table20 by given id if exists.
	 *
	 * @param table20Id The id of the Table20 to get; value cannot be null.
	 * @return Table20 associated with the given table20Id.
     * @throws EntityNotFoundException If no Table20 is found.
	 */
	Table20 getById(Integer table20Id) throws EntityNotFoundException;

    /**
	 * Find and return the Table20 by given id if exists, returns null otherwise.
	 *
	 * @param table20Id The id of the Table20 to get; value cannot be null.
	 * @return Table20 associated with the given table20Id.
	 */
	Table20 findById(Integer table20Id);


	/**
	 * Updates the details of an existing Table20. It replaces all fields of the existing Table20 with the given table20.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Table20 if any.
     *
	 * @param table20 The details of the Table20 to be updated; value cannot be null.
	 * @return The updated Table20.
	 * @throws EntityNotFoundException if no Table20 is found with given input.
	 */
	Table20 update(@Valid Table20 table20) throws EntityNotFoundException;

    /**
	 * Deletes an existing Table20 with the given id.
	 *
	 * @param table20Id The id of the Table20 to be deleted; value cannot be null.
	 * @return The deleted Table20.
	 * @throws EntityNotFoundException if no Table20 found with the given id.
	 */
	Table20 delete(Integer table20Id) throws EntityNotFoundException;

	/**
	 * Find all Table20s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Table20s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Table20> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Table20s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Table20s.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Table20> findAll(String query, Pageable pageable);

    /**
	 * Exports all Table20s matching the given input query to the given exportType format.
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
	 * Retrieve the count of the Table20s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Table20.
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

    /*
     * Returns the associated table20sForColumn3 for given Table20 id.
     *
     * @param id value of id; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Table20 instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Table20> findAssociatedTable20sForColumn3(Integer id, Pageable pageable);

}

