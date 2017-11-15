/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing15thnov_stage.dbscenarios.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

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

import com.testing15thnov_stage.dbscenarios.DateTable;


/**
 * ServiceImpl object for domain model class DateTable.
 *
 * @see DateTable
 */
@Service("dbscenarios.DateTableService")
@Validated
public class DateTableServiceImpl implements DateTableService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateTableServiceImpl.class);


    @Autowired
    @Qualifier("dbscenarios.DateTableDao")
    private WMGenericDao<DateTable, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<DateTable, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenariosTransactionManager")
    @Override
	public DateTable create(DateTable dateTable) {
        LOGGER.debug("Creating a new DateTable with information: {}", dateTable);
        DateTable dateTableCreated = this.wmGenericDao.create(dateTable);
        return dateTableCreated;
    }

	@Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public DateTable getById(Integer datetableId) throws EntityNotFoundException {
        LOGGER.debug("Finding DateTable by id: {}", datetableId);
        DateTable dateTable = this.wmGenericDao.findById(datetableId);
        if (dateTable == null){
            LOGGER.debug("No DateTable found with id: {}", datetableId);
            throw new EntityNotFoundException(String.valueOf(datetableId));
        }
        return dateTable;
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public DateTable findById(Integer datetableId) {
        LOGGER.debug("Finding DateTable by id: {}", datetableId);
        return this.wmGenericDao.findById(datetableId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenariosTransactionManager")
	@Override
	public DateTable update(DateTable dateTable) throws EntityNotFoundException {
        LOGGER.debug("Updating DateTable with information: {}", dateTable);
        this.wmGenericDao.update(dateTable);

        Integer datetableId = dateTable.getId();

        return this.wmGenericDao.findById(datetableId);
    }

    @Transactional(value = "dbscenariosTransactionManager")
	@Override
	public DateTable delete(Integer datetableId) throws EntityNotFoundException {
        LOGGER.debug("Deleting DateTable with id: {}", datetableId);
        DateTable deleted = this.wmGenericDao.findById(datetableId);
        if (deleted == null) {
            LOGGER.debug("No DateTable found with id: {}", datetableId);
            throw new EntityNotFoundException(String.valueOf(datetableId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public Page<DateTable> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all DateTables");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Page<DateTable> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all DateTables");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios for table DateTable to {} format", exportType);
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

