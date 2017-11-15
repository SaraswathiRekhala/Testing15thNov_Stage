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

import com.testing15thnov_stage.dbscenarios.TCompositesMany2one1;

/**
 * Service object for domain model class {@link TCompositesMany2one1}.
 */
public interface TCompositesMany2one1Service {

    /**
     * Creates a new TCompositesMany2one1. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on TCompositesMany2one1 if any.
     *
     * @param tcompositesMany2one1 Details of the TCompositesMany2one1 to be created; value cannot be null.
     * @return The newly created TCompositesMany2one1.
     */
	TCompositesMany2one1 create(@Valid TCompositesMany2one1 tcompositesMany2one1);


	/**
	 * Returns TCompositesMany2one1 by given id if exists.
	 *
	 * @param tcompositesmany2one1Id The id of the TCompositesMany2one1 to get; value cannot be null.
	 * @return TCompositesMany2one1 associated with the given tcompositesmany2one1Id.
     * @throws EntityNotFoundException If no TCompositesMany2one1 is found.
	 */
	TCompositesMany2one1 getById(Integer tcompositesmany2one1Id) throws EntityNotFoundException;

    /**
	 * Find and return the TCompositesMany2one1 by given id if exists, returns null otherwise.
	 *
	 * @param tcompositesmany2one1Id The id of the TCompositesMany2one1 to get; value cannot be null.
	 * @return TCompositesMany2one1 associated with the given tcompositesmany2one1Id.
	 */
	TCompositesMany2one1 findById(Integer tcompositesmany2one1Id);


	/**
	 * Updates the details of an existing TCompositesMany2one1. It replaces all fields of the existing TCompositesMany2one1 with the given tcompositesMany2one1.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on TCompositesMany2one1 if any.
     *
	 * @param tcompositesMany2one1 The details of the TCompositesMany2one1 to be updated; value cannot be null.
	 * @return The updated TCompositesMany2one1.
	 * @throws EntityNotFoundException if no TCompositesMany2one1 is found with given input.
	 */
	TCompositesMany2one1 update(@Valid TCompositesMany2one1 tcompositesMany2one1) throws EntityNotFoundException;

    /**
	 * Deletes an existing TCompositesMany2one1 with the given id.
	 *
	 * @param tcompositesmany2one1Id The id of the TCompositesMany2one1 to be deleted; value cannot be null.
	 * @return The deleted TCompositesMany2one1.
	 * @throws EntityNotFoundException if no TCompositesMany2one1 found with the given id.
	 */
	TCompositesMany2one1 delete(Integer tcompositesmany2one1Id) throws EntityNotFoundException;

	/**
	 * Find all TCompositesMany2one1s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TCompositesMany2one1s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<TCompositesMany2one1> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all TCompositesMany2one1s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching TCompositesMany2one1s.
     *
     * @see Pageable
     * @see Page
	 */
    Page<TCompositesMany2one1> findAll(String query, Pageable pageable);

    /**
	 * Exports all TCompositesMany2one1s matching the given input query to the given exportType format.
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
	 * Retrieve the count of the TCompositesMany2one1s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the TCompositesMany2one1.
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

