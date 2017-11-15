/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing15thnov_stage.dbscenarios.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.LocalDateTime;
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

import com.testing15thnov_stage.dbscenarios.Uniquegrouping;


/**
 * ServiceImpl object for domain model class Uniquegrouping.
 *
 * @see Uniquegrouping
 */
@Service("dbscenarios.UniquegroupingService")
@Validated
public class UniquegroupingServiceImpl implements UniquegroupingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UniquegroupingServiceImpl.class);


    @Autowired
    @Qualifier("dbscenarios.UniquegroupingDao")
    private WMGenericDao<Uniquegrouping, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Uniquegrouping, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "dbscenariosTransactionManager")
    @Override
	public Uniquegrouping create(Uniquegrouping uniquegrouping) {
        LOGGER.debug("Creating a new Uniquegrouping with information: {}", uniquegrouping);
        Uniquegrouping uniquegroupingCreated = this.wmGenericDao.create(uniquegrouping);
        return uniquegroupingCreated;
    }

	@Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public Uniquegrouping getById(Integer uniquegroupingId) throws EntityNotFoundException {
        LOGGER.debug("Finding Uniquegrouping by id: {}", uniquegroupingId);
        Uniquegrouping uniquegrouping = this.wmGenericDao.findById(uniquegroupingId);
        if (uniquegrouping == null){
            LOGGER.debug("No Uniquegrouping found with id: {}", uniquegroupingId);
            throw new EntityNotFoundException(String.valueOf(uniquegroupingId));
        }
        return uniquegrouping;
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public Uniquegrouping findById(Integer uniquegroupingId) {
        LOGGER.debug("Finding Uniquegrouping by id: {}", uniquegroupingId);
        return this.wmGenericDao.findById(uniquegroupingId);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Uniquegrouping getByDatecolAndCharcol(Date datecol, String charcol) {
        Map<String, Object> datecolAndCharcolMap = new HashMap<>();
        datecolAndCharcolMap.put("datecol", datecol);
        datecolAndCharcolMap.put("charcol", charcol);

        LOGGER.debug("Finding Uniquegrouping by unique keys: {}", datecolAndCharcolMap);
        Uniquegrouping uniquegrouping = this.wmGenericDao.findByUniqueKey(datecolAndCharcolMap);

        if (uniquegrouping == null){
            LOGGER.debug("No Uniquegrouping found with given unique key values: {}", datecolAndCharcolMap);
            throw new EntityNotFoundException(String.valueOf(datecolAndCharcolMap));
        }

        return uniquegrouping;
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Uniquegrouping getByStringcol(String stringcol) {
        Map<String, Object> stringcolMap = new HashMap<>();
        stringcolMap.put("stringcol", stringcol);

        LOGGER.debug("Finding Uniquegrouping by unique keys: {}", stringcolMap);
        Uniquegrouping uniquegrouping = this.wmGenericDao.findByUniqueKey(stringcolMap);

        if (uniquegrouping == null){
            LOGGER.debug("No Uniquegrouping found with given unique key values: {}", stringcolMap);
            throw new EntityNotFoundException(String.valueOf(stringcolMap));
        }

        return uniquegrouping;
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Uniquegrouping getByDatecolAndCharcolAndDatetimecol(Date datecol, String charcol, LocalDateTime datetimecol) {
        Map<String, Object> datecolAndCharcolAndDatetimecolMap = new HashMap<>();
        datecolAndCharcolAndDatetimecolMap.put("datecol", datecol);
        datecolAndCharcolAndDatetimecolMap.put("charcol", charcol);
        datecolAndCharcolAndDatetimecolMap.put("datetimecol", datetimecol);

        LOGGER.debug("Finding Uniquegrouping by unique keys: {}", datecolAndCharcolAndDatetimecolMap);
        Uniquegrouping uniquegrouping = this.wmGenericDao.findByUniqueKey(datecolAndCharcolAndDatetimecolMap);

        if (uniquegrouping == null){
            LOGGER.debug("No Uniquegrouping found with given unique key values: {}", datecolAndCharcolAndDatetimecolMap);
            throw new EntityNotFoundException(String.valueOf(datecolAndCharcolAndDatetimecolMap));
        }

        return uniquegrouping;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "dbscenariosTransactionManager")
	@Override
	public Uniquegrouping update(Uniquegrouping uniquegrouping) throws EntityNotFoundException {
        LOGGER.debug("Updating Uniquegrouping with information: {}", uniquegrouping);
        this.wmGenericDao.update(uniquegrouping);

        Integer uniquegroupingId = uniquegrouping.getId();

        return this.wmGenericDao.findById(uniquegroupingId);
    }

    @Transactional(value = "dbscenariosTransactionManager")
	@Override
	public Uniquegrouping delete(Integer uniquegroupingId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Uniquegrouping with id: {}", uniquegroupingId);
        Uniquegrouping deleted = this.wmGenericDao.findById(uniquegroupingId);
        if (deleted == null) {
            LOGGER.debug("No Uniquegrouping found with id: {}", uniquegroupingId);
            throw new EntityNotFoundException(String.valueOf(uniquegroupingId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "dbscenariosTransactionManager")
	@Override
	public Page<Uniquegrouping> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Uniquegroupings");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Page<Uniquegrouping> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Uniquegroupings");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "dbscenariosTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service dbscenarios for table Uniquegrouping to {} format", exportType);
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

