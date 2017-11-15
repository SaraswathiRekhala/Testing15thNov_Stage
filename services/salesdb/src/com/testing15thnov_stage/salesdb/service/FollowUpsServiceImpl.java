/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing15thnov_stage.salesdb.service;

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

import com.testing15thnov_stage.salesdb.FollowUps;


/**
 * ServiceImpl object for domain model class FollowUps.
 *
 * @see FollowUps
 */
@Service("salesdb.FollowUpsService")
@Validated
public class FollowUpsServiceImpl implements FollowUpsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FollowUpsServiceImpl.class);


    @Autowired
    @Qualifier("salesdb.FollowUpsDao")
    private WMGenericDao<FollowUps, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<FollowUps, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "salesdbTransactionManager")
    @Override
	public FollowUps create(FollowUps followUps) {
        LOGGER.debug("Creating a new FollowUps with information: {}", followUps);
        FollowUps followUpsCreated = this.wmGenericDao.create(followUps);
        return followUpsCreated;
    }

	@Transactional(readOnly = true, value = "salesdbTransactionManager")
	@Override
	public FollowUps getById(Integer followupsId) throws EntityNotFoundException {
        LOGGER.debug("Finding FollowUps by id: {}", followupsId);
        FollowUps followUps = this.wmGenericDao.findById(followupsId);
        if (followUps == null){
            LOGGER.debug("No FollowUps found with id: {}", followupsId);
            throw new EntityNotFoundException(String.valueOf(followupsId));
        }
        return followUps;
    }

    @Transactional(readOnly = true, value = "salesdbTransactionManager")
	@Override
	public FollowUps findById(Integer followupsId) {
        LOGGER.debug("Finding FollowUps by id: {}", followupsId);
        return this.wmGenericDao.findById(followupsId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "salesdbTransactionManager")
	@Override
	public FollowUps update(FollowUps followUps) throws EntityNotFoundException {
        LOGGER.debug("Updating FollowUps with information: {}", followUps);
        this.wmGenericDao.update(followUps);

        Integer followupsId = followUps.getId();

        return this.wmGenericDao.findById(followupsId);
    }

    @Transactional(value = "salesdbTransactionManager")
	@Override
	public FollowUps delete(Integer followupsId) throws EntityNotFoundException {
        LOGGER.debug("Deleting FollowUps with id: {}", followupsId);
        FollowUps deleted = this.wmGenericDao.findById(followupsId);
        if (deleted == null) {
            LOGGER.debug("No FollowUps found with id: {}", followupsId);
            throw new EntityNotFoundException(String.valueOf(followupsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "salesdbTransactionManager")
	@Override
	public Page<FollowUps> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all FollowUps");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "salesdbTransactionManager")
    @Override
    public Page<FollowUps> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all FollowUps");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "salesdbTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service salesdb for table FollowUps to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "salesdbTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "salesdbTransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}

