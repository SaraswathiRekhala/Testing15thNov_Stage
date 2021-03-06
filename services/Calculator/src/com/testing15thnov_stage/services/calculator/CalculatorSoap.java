/*Copyright (c) 2017-2018 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing15thnov_stage.services.calculator;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.11
 * 2017-11-15T04:52:30.790Z
 * Generated source version: 2.7.11
 * 
 */
@WebService(targetNamespace = "http://tempuri.org/", name = "CalculatorSoap")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface CalculatorSoap {

    @WebMethod(operationName = "Subtract", action = "http://tempuri.org/Subtract")
    @WebResult(name = "SubtractResponse", targetNamespace = "http://tempuri.org/", partName = "parameters")
    public SubtractResponse subtract(
        @WebParam(partName = "parameters", name = "Subtract", targetNamespace = "http://tempuri.org/")
        Subtract parameters
    );

    @WebMethod(operationName = "Divide", action = "http://tempuri.org/Divide")
    @WebResult(name = "DivideResponse", targetNamespace = "http://tempuri.org/", partName = "parameters")
    public DivideResponse divide(
        @WebParam(partName = "parameters", name = "Divide", targetNamespace = "http://tempuri.org/")
        Divide parameters
    );

    /**
     * Adds two integers. This is a test WebService. ??DNE Online
     */
    @WebMethod(operationName = "Add", action = "http://tempuri.org/Add")
    @WebResult(name = "AddResponse", targetNamespace = "http://tempuri.org/", partName = "parameters")
    public AddResponse add(
        @WebParam(partName = "parameters", name = "Add", targetNamespace = "http://tempuri.org/")
        Add parameters
    );

    @WebMethod(operationName = "Multiply", action = "http://tempuri.org/Multiply")
    @WebResult(name = "MultiplyResponse", targetNamespace = "http://tempuri.org/", partName = "parameters")
    public MultiplyResponse multiply(
        @WebParam(partName = "parameters", name = "Multiply", targetNamespace = "http://tempuri.org/")
        Multiply parameters
    );
}
