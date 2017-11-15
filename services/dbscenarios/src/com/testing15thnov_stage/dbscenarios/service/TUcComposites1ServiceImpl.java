/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing15thnov_stage.dbscenarios.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testing15thnov_stage.dbscenarios.TUcComposites1;


/**
 * ServiceImpl object for domain model class TUcComposites1.
 *
 * @see TUcComposites1
 */
@Service("dbscenarios.TUcComposites1Service")
@Validated
public class TUcComposites1ServiceImpl implements TUcComposites1Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(TUcComposites1ServiceImpl.class);


    @Autowired
    @Qualifier("dbscenarios.TUcComposites1Dao")
    private WMGenericDao<TUcComposites1, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TUcComposites1, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenariosTransactionManager")
    @Override
	public TUcComposites1 create(TUcComposites1 tucComposites1) {
        LOGGER.debug("Creating a new TUcComposites1 with information: {}", tucComposites1);
        TUcComposites1 tucComposites1Created = this.wmGenericDao.create(tucComposites1);
        return tucComposites1Created;
    }

	@Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public TUcComposites1 getById(Integer tuccomposites1Id) throws EntityNotFoundException {
        LOGGER.debug("Finding TUcComposites1 by id: {}", tuccomposites1Id);
        TUcComposites1 tucComposites1 = this.wmGenericDao.findById(tuccomposites1Id);
        if (tucComposites1 == null){
            LOGGER.debug("No TUcComposites1 found with id: {}", tuccomposites1Id);
            throw new EntityNotFoundException(String.valueOf(tuccomposites1Id));
        }
        return tucComposites1;
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public TUcComposites1 findById(Integer tuccomposites1Id) {
        LOGGER.debug("Finding TUcComposites1 by id: {}", tuccomposites1Id);
        return this.wmGenericDao.findById(tuccomposites1Id);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public TUcComposites1 getByByteColAndCharColAndShortColAndStringCol(Short byteCol, String charCol, Short shortCol, String stringCol) {
        Map<String, Object> byteColAndCharColAndShortColAndStringColMap = new HashMap<>();
        byteColAndCharColAndShortColAndStringColMap.put("byteCol", byteCol);
        byteColAndCharColAndShortColAndStringColMap.put("charCol", charCol);
        byteColAndCharColAndShortColAndStringColMap.put("shortCol", shortCol);
        byteColAndCharColAndShortColAndStringColMap.put("stringCol", stringCol);

        LOGGER.debug("Finding TUcComposites1 by unique keys: {}", byteColAndCharColAndShortColAndStringColMap);
        TUcComposites1 tucComposites1 = this.wmGenericDao.findByUniqueKey(byteColAndCharColAndShortColAndStringColMap);

        if (tucComposites1 == null){
            LOGGER.debug("No TUcComposites1 found with given unique key values: {}", byteColAndCharColAndShortColAndStringColMap);
            throw new EntityNotFoundException(String.valueOf(byteColAndCharColAndShortColAndStringColMap));
        }

        return tucComposites1;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenariosTransactionManager")
	@Override
	public TUcComposites1 update(TUcComposites1 tucComposites1) throws EntityNotFoundException {
        LOGGER.debug("Updating TUcComposites1 with information: {}", tucComposites1);
        this.wmGenericDao.update(tucComposites1);

        Integer tuccomposites1Id = tucComposites1.getId();

        return this.wmGenericDao.findById(tuccomposites1Id);
    }

    @Transactional(value = "dbscenariosTransactionManager")
	@Override
	public TUcComposites1 delete(Integer tuccomposites1Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting TUcComposites1 with id: {}", tuccomposites1Id);
        TUcComposites1 deleted = this.wmGenericDao.findById(tuccomposites1Id);
        if (deleted == null) {
            LOGGER.debug("No TUcComposites1 found with id: {}", tuccomposites1Id);
            throw new EntityNotFoundException(String.valueOf(tuccomposites1Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public Page<TUcComposites1> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all TUcComposites1s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Page<TUcComposites1> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all TUcComposites1s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios for table TUcComposites1 to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}

