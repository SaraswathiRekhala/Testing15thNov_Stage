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

import com.testing15thnov_stage.dbscenarios.Uc;
import com.testing15thnov_stage.dbscenarios.Up;


/**
 * ServiceImpl object for domain model class Up.
 *
 * @see Up
 */
@Service("dbscenarios.UpService")
@Validated
public class UpServiceImpl implements UpService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpServiceImpl.class);

    @Lazy
    @Autowired
	@Qualifier("dbscenarios.UcService")
	private UcService ucService;

    @Autowired
    @Qualifier("dbscenarios.UpDao")
    private WMGenericDao<Up, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Up, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenariosTransactionManager")
    @Override
	public Up create(Up up) {
        LOGGER.debug("Creating a new Up with information: {}", up);
        Up upCreated = this.wmGenericDao.create(up);
        if(upCreated.getUc() != null) {
            Uc uc = upCreated.getUc();
            LOGGER.debug("Creating a new child Uc with information: {}", uc);
            uc.setUp(upCreated);
            ucService.create(uc);
        }
        return upCreated;
    }

	@Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public Up getById(Integer upId) throws EntityNotFoundException {
        LOGGER.debug("Finding Up by id: {}", upId);
        Up up = this.wmGenericDao.findById(upId);
        if (up == null){
            LOGGER.debug("No Up found with id: {}", upId);
            throw new EntityNotFoundException(String.valueOf(upId));
        }
        return up;
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public Up findById(Integer upId) {
        LOGGER.debug("Finding Up by id: {}", upId);
        return this.wmGenericDao.findById(upId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenariosTransactionManager")
	@Override
	public Up update(Up up) throws EntityNotFoundException {
        LOGGER.debug("Updating Up with information: {}", up);
        this.wmGenericDao.update(up);

        Integer upId = up.getId();

        return this.wmGenericDao.findById(upId);
    }

    @Transactional(value = "dbscenariosTransactionManager")
	@Override
	public Up delete(Integer upId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Up with id: {}", upId);
        Up deleted = this.wmGenericDao.findById(upId);
        if (deleted == null) {
            LOGGER.debug("No Up found with id: {}", upId);
            throw new EntityNotFoundException(String.valueOf(upId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public Page<Up> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Ups");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Page<Up> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Ups");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios for table Up to {} format", exportType);
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
	 * @param service UcService instance
	 */
	protected void setUcService(UcService service) {
        this.ucService = service;
    }

}

