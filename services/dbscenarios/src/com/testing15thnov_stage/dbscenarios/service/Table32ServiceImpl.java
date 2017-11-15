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
import org.springframework.context.annotation.Lazy;
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

import com.testing15thnov_stage.dbscenarios.Table32;
import com.testing15thnov_stage.dbscenarios.Table33;


/**
 * ServiceImpl object for domain model class Table32.
 *
 * @see Table32
 */
@Service("dbscenarios.Table32Service")
@Validated
public class Table32ServiceImpl implements Table32Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table32ServiceImpl.class);

    @Lazy
    @Autowired
	@Qualifier("dbscenarios.Table33Service")
	private Table33Service table33Service;

    @Autowired
    @Qualifier("dbscenarios.Table32Dao")
    private WMGenericDao<Table32, String> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Table32, String> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenariosTransactionManager")
    @Override
	public Table32 create(Table32 table32) {
        LOGGER.debug("Creating a new Table32 with information: {}", table32);
        Table32 table32Created = this.wmGenericDao.create(table32);
        if(table32Created.getTable33() != null) {
            Table33 table33 = table32Created.getTable33();
            LOGGER.debug("Creating a new child Table33 with information: {}", table33);
            table33.setTable32(table32Created);
            table33Service.create(table33);
        }
        return table32Created;
    }

	@Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public Table32 getById(String table32Id) throws EntityNotFoundException {
        LOGGER.debug("Finding Table32 by id: {}", table32Id);
        Table32 table32 = this.wmGenericDao.findById(table32Id);
        if (table32 == null){
            LOGGER.debug("No Table32 found with id: {}", table32Id);
            throw new EntityNotFoundException(String.valueOf(table32Id));
        }
        return table32;
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public Table32 findById(String table32Id) {
        LOGGER.debug("Finding Table32 by id: {}", table32Id);
        return this.wmGenericDao.findById(table32Id);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenariosTransactionManager")
	@Override
	public Table32 update(Table32 table32) throws EntityNotFoundException {
        LOGGER.debug("Updating Table32 with information: {}", table32);
        this.wmGenericDao.update(table32);

        String table32Id = table32.getId();

        return this.wmGenericDao.findById(table32Id);
    }

    @Transactional(value = "dbscenariosTransactionManager")
	@Override
	public Table32 delete(String table32Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table32 with id: {}", table32Id);
        Table32 deleted = this.wmGenericDao.findById(table32Id);
        if (deleted == null) {
            LOGGER.debug("No Table32 found with id: {}", table32Id);
            throw new EntityNotFoundException(String.valueOf(table32Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public Page<Table32> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Table32s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Page<Table32> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Table32s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios for table Table32 to {} format", exportType);
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


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service Table33Service instance
	 */
	protected void setTable33Service(Table33Service service) {
        this.table33Service = service;
    }

}

