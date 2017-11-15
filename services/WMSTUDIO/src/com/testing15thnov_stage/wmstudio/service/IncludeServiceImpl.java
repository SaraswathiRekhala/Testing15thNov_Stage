/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing15thnov_stage.wmstudio.service;

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

import com.testing15thnov_stage.wmstudio.Include;
import com.testing15thnov_stage.wmstudio.IncludeId;


/**
 * ServiceImpl object for domain model class Include.
 *
 * @see Include
 */
@Service("WMSTUDIO.IncludeService")
@Validated
public class IncludeServiceImpl implements IncludeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IncludeServiceImpl.class);


    @Autowired
    @Qualifier("WMSTUDIO.IncludeDao")
    private WMGenericDao<Include, IncludeId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Include, IncludeId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
    @Override
	public Include create(Include include) {
        LOGGER.debug("Creating a new Include with information: {}", include);
        Include includeCreated = this.wmGenericDao.create(include);
        return includeCreated;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Include getById(IncludeId includeId) throws EntityNotFoundException {
        LOGGER.debug("Finding Include by id: {}", includeId);
        Include include = this.wmGenericDao.findById(includeId);
        if (include == null){
            LOGGER.debug("No Include found with id: {}", includeId);
            throw new EntityNotFoundException(String.valueOf(includeId));
        }
        return include;
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Include findById(IncludeId includeId) {
        LOGGER.debug("Finding Include by id: {}", includeId);
        return this.wmGenericDao.findById(includeId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "WMSTUDIOTransactionManager")
	@Override
	public Include update(Include include) throws EntityNotFoundException {
        LOGGER.debug("Updating Include with information: {}", include);
        this.wmGenericDao.update(include);

        IncludeId includeId = new IncludeId();
        includeId.setId(include.getId());
        includeId.setFirstName(include.getFirstName());
        includeId.setSalary(include.getSalary());
        includeId.setSalary2(include.getSalary2());

        return this.wmGenericDao.findById(includeId);
    }

    @Transactional(value = "WMSTUDIOTransactionManager")
	@Override
	public Include delete(IncludeId includeId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Include with id: {}", includeId);
        Include deleted = this.wmGenericDao.findById(includeId);
        if (deleted == null) {
            LOGGER.debug("No Include found with id: {}", includeId);
            throw new EntityNotFoundException(String.valueOf(includeId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public Page<Include> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Includes");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Page<Include> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Includes");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service WMSTUDIO for table Include to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "WMSTUDIOTransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}

