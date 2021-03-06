/**This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
package com.testing15thnov_stage.myjavaservice.controller;

import com.testing15thnov_stage.myjavaservice.MyJavaService;
import com.testing15thnov_stage.dbscenarios.PersonBackup;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

@RestController
@RequestMapping(value = "/myJava")
public class MyJavaController {

    @Autowired
    private MyJavaService myJavaService;

    @RequestMapping(value = "/andUpdate", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "")
    public PersonBackup createAndUpdate(@RequestBody PersonBackup person) {
        return myJavaService.createAndUpdate(person);
    }
}
