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

import com.testing15thnov_stage.dbscenarios.TUcOne2oneParent;


/**
 * ServiceImpl object for domain model class TUcOne2oneParent.
 *
 * @see TUcOne2oneParent
 */
@Service("dbscenarios.TUcOne2oneParentService")
@Validated
public class TUcOne2oneParentServiceImpl implements TUcOne2oneParentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TUcOne2oneParentServiceImpl.class);


    @Autowired
    @Qualifier("dbscenarios.TUcOne2oneParentDao")
    private WMGenericDao<TUcOne2oneParent, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<TUcOne2oneParent, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenariosTransactionManager")
    @Override
	public TUcOne2oneParent create(TUcOne2oneParent tucOne2oneParent) {
        LOGGER.debug("Creating a new TUcOne2oneParent with information: {}", tucOne2oneParent);
        TUcOne2oneParent tucOne2oneParentCreated = this.wmGenericDao.create(tucOne2oneParent);
        return tucOne2oneParentCreated;
    }

	@Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public TUcOne2oneParent getById(Integer tucone2oneparentId) throws EntityNotFoundException {
        LOGGER.debug("Finding TUcOne2oneParent by id: {}", tucone2oneparentId);
        TUcOne2oneParent tucOne2oneParent = this.wmGenericDao.findById(tucone2oneparentId);
        if (tucOne2oneParent == null){
            LOGGER.debug("No TUcOne2oneParent found with id: {}", tucone2oneparentId);
            throw new EntityNotFoundException(String.valueOf(tucone2oneparentId));
        }
        return tucOne2oneParent;
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public TUcOne2oneParent findById(Integer tucone2oneparentId) {
        LOGGER.debug("Finding TUcOne2oneParent by id: {}", tucone2oneparentId);
        return this.wmGenericDao.findById(tucone2oneparentId);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public TUcOne2oneParent getByShortCol(Short shortCol) {
        Map<String, Object> shortColMap = new HashMap<>();
        shortColMap.put("shortCol", shortCol);

        LOGGER.debug("Finding TUcOne2oneParent by unique keys: {}", shortColMap);
        TUcOne2oneParent tucOne2oneParent = this.wmGenericDao.findByUniqueKey(shortColMap);

        if (tucOne2oneParent == null){
            LOGGER.debug("No TUcOne2oneParent found with given unique key values: {}", shortColMap);
            throw new EntityNotFoundException(String.valueOf(shortColMap));
        }

        return tucOne2oneParent;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenariosTransactionManager")
	@Override
	public TUcOne2oneParent update(TUcOne2oneParent tucOne2oneParent) throws EntityNotFoundException {
        LOGGER.debug("Updating TUcOne2oneParent with information: {}", tucOne2oneParent);
        this.wmGenericDao.update(tucOne2oneParent);

        Integer tucone2oneparentId = tucOne2oneParent.getPkId();

        return this.wmGenericDao.findById(tucone2oneparentId);
    }

    @Transactional(value = "dbscenariosTransactionManager")
	@Override
	public TUcOne2oneParent delete(Integer tucone2oneparentId) throws EntityNotFoundException {
        LOGGER.debug("Deleting TUcOne2oneParent with id: {}", tucone2oneparentId);
        TUcOne2oneParent deleted = this.wmGenericDao.findById(tucone2oneparentId);
        if (deleted == null) {
            LOGGER.debug("No TUcOne2oneParent found with id: {}", tucone2oneparentId);
            throw new EntityNotFoundException(String.valueOf(tucone2oneparentId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public Page<TUcOne2oneParent> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all TUcOne2oneParents");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Page<TUcOne2oneParent> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all TUcOne2oneParents");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios for table TUcOne2oneParent to {} format", exportType);
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
