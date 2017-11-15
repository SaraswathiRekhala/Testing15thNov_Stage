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

import com.testing15thnov_stage.dbscenarios.TUcOne2oneChild;
import com.testing15thnov_stage.dbscenarios.TUcOne2oneParent;


/**
 * ServiceImpl object for domain model class TUcOne2oneChild.
 *
 * @see TUcOne2oneChild
 */
@Service("dbscenarios.TUcOne2oneChildService")
@Validated
public class TUcOne2oneChildServiceImpl implements TUcOne2oneChildService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TUcOne2oneChildServiceImpl.class);

    @Lazy
    @Autowired
	@Qualifier("dbscenarios.TUcOne2oneParentService")
	private TUcOne2oneParentService tUcOne2oneParentService;

    @Autowired
    @Qualifier("dbscenarios.TUcOne2oneChildDao")
    private WMGenericDao<TUcOne2oneChild, Short> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TUcOne2oneChild, Short> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenariosTransactionManager")
    @Override
	public TUcOne2oneChild create(TUcOne2oneChild tucOne2oneChild) {
        LOGGER.debug("Creating a new TUcOne2oneChild with information: {}", tucOne2oneChild);
        TUcOne2oneChild tucOne2oneChildCreated = this.wmGenericDao.create(tucOne2oneChild);
        if(tucOne2oneChildCreated.getTucOne2oneParent() != null) {
            TUcOne2oneParent tucOne2oneParent = tucOne2oneChildCreated.getTucOne2oneParent();
            LOGGER.debug("Creating a new child TUcOne2oneParent with information: {}", tucOne2oneParent);
            tucOne2oneParent.setTucOne2oneChild(tucOne2oneChildCreated);
            tUcOne2oneParentService.create(tucOne2oneParent);
        }
        return tucOne2oneChildCreated;
    }

	@Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public TUcOne2oneChild getById(Short tucone2onechildId) throws EntityNotFoundException {
        LOGGER.debug("Finding TUcOne2oneChild by id: {}", tucone2onechildId);
        TUcOne2oneChild tucOne2oneChild = this.wmGenericDao.findById(tucone2onechildId);
        if (tucOne2oneChild == null){
            LOGGER.debug("No TUcOne2oneChild found with id: {}", tucone2onechildId);
            throw new EntityNotFoundException(String.valueOf(tucone2onechildId));
        }
        return tucOne2oneChild;
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public TUcOne2oneChild findById(Short tucone2onechildId) {
        LOGGER.debug("Finding TUcOne2oneChild by id: {}", tucone2onechildId);
        return this.wmGenericDao.findById(tucone2onechildId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenariosTransactionManager")
	@Override
	public TUcOne2oneChild update(TUcOne2oneChild tucOne2oneChild) throws EntityNotFoundException {
        LOGGER.debug("Updating TUcOne2oneChild with information: {}", tucOne2oneChild);
        this.wmGenericDao.update(tucOne2oneChild);

        Short tucone2onechildId = tucOne2oneChild.getShortid();

        return this.wmGenericDao.findById(tucone2onechildId);
    }

    @Transactional(value = "dbscenariosTransactionManager")
	@Override
	public TUcOne2oneChild delete(Short tucone2onechildId) throws EntityNotFoundException {
        LOGGER.debug("Deleting TUcOne2oneChild with id: {}", tucone2onechildId);
        TUcOne2oneChild deleted = this.wmGenericDao.findById(tucone2onechildId);
        if (deleted == null) {
            LOGGER.debug("No TUcOne2oneChild found with id: {}", tucone2onechildId);
            throw new EntityNotFoundException(String.valueOf(tucone2onechildId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public Page<TUcOne2oneChild> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all TUcOne2oneChilds");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Page<TUcOne2oneChild> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all TUcOne2oneChilds");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios for table TUcOne2oneChild to {} format", exportType);
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
	 * @param service TUcOne2oneParentService instance
	 */
	protected void setTUcOne2oneParentService(TUcOne2oneParentService service) {
        this.tUcOne2oneParentService = service;
    }

}
