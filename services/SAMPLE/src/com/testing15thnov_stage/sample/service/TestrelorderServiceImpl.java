/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing15thnov_stage.sample.service;

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

import com.testing15thnov_stage.sample.Testrelorder;
import com.testing15thnov_stage.sample.TestrelorderId;
import com.testing15thnov_stage.sample.Testrelorderchild;


/**
 * ServiceImpl object for domain model class Testrelorder.
 *
 * @see Testrelorder
 */
@Service("SAMPLE.TestrelorderService")
@Validated
public class TestrelorderServiceImpl implements TestrelorderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestrelorderServiceImpl.class);

    @Lazy
    @Autowired
	@Qualifier("SAMPLE.TestrelorderchildService")
	private TestrelorderchildService testrelorderchildService;

    @Autowired
    @Qualifier("SAMPLE.TestrelorderDao")
    private WMGenericDao<Testrelorder, TestrelorderId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Testrelorder, TestrelorderId> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "SAMPLETransactionManager")
    @Override
	public Testrelorder create(Testrelorder testrelorder) {
        LOGGER.debug("Creating a new Testrelorder with information: {}", testrelorder);
        Testrelorder testrelorderCreated = this.wmGenericDao.create(testrelorder);
        if(testrelorderCreated.getTestrelorderchild() != null) {
            Testrelorderchild testrelorderchild = testrelorderCreated.getTestrelorderchild();
            LOGGER.debug("Creating a new child Testrelorderchild with information: {}", testrelorderchild);
            testrelorderchild.setTestrelorder(testrelorderCreated);
            testrelorderchildService.create(testrelorderchild);
        }
        return testrelorderCreated;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Testrelorder getById(TestrelorderId testrelorderId) throws EntityNotFoundException {
        LOGGER.debug("Finding Testrelorder by id: {}", testrelorderId);
        Testrelorder testrelorder = this.wmGenericDao.findById(testrelorderId);
        if (testrelorder == null){
            LOGGER.debug("No Testrelorder found with id: {}", testrelorderId);
            throw new EntityNotFoundException(String.valueOf(testrelorderId));
        }
        return testrelorder;
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Testrelorder findById(TestrelorderId testrelorderId) {
        LOGGER.debug("Finding Testrelorder by id: {}", testrelorderId);
        return this.wmGenericDao.findById(testrelorderId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "SAMPLETransactionManager")
	@Override
	public Testrelorder update(Testrelorder testrelorder) throws EntityNotFoundException {
        LOGGER.debug("Updating Testrelorder with information: {}", testrelorder);
        this.wmGenericDao.update(testrelorder);

        TestrelorderId testrelorderId = new TestrelorderId();
        testrelorderId.setColumn1(testrelorder.getColumn1());
        testrelorderId.setColumn2(testrelorder.getColumn2());

        return this.wmGenericDao.findById(testrelorderId);
    }

    @Transactional(value = "SAMPLETransactionManager")
	@Override
	public Testrelorder delete(TestrelorderId testrelorderId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Testrelorder with id: {}", testrelorderId);
        Testrelorder deleted = this.wmGenericDao.findById(testrelorderId);
        if (deleted == null) {
            LOGGER.debug("No Testrelorder found with id: {}", testrelorderId);
            throw new EntityNotFoundException(String.valueOf(testrelorderId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public Page<Testrelorder> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Testrelorders");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Page<Testrelorder> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Testrelorders");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service SAMPLE for table Testrelorder to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "SAMPLETransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TestrelorderchildService instance
	 */
	protected void setTestrelorderchildService(TestrelorderchildService service) {
        this.testrelorderchildService = service;
    }

}

