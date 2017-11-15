/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing15thnov_stage.dbscenarios.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

import com.testing15thnov_stage.dbscenarios.TUcComposites2;
import com.testing15thnov_stage.dbscenarios.TUcComposites2Id;

/**
 * Specifies methods used to obtain and modify TUcComposites2 related information
 * which is stored in the database.
 */
@Repository("dbscenarios.TUcComposites2Dao")
public class TUcComposites2Dao extends WMGenericDaoImpl<TUcComposites2, TUcComposites2Id> {

    @Autowired
    @Qualifier("dbscenariosTemplate")
    private HibernateTemplate template;

    public HibernateTemplate getTemplate() {
        return this.template;
    }
}

