/**This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
package com.testing15thnov_stage.services.calculator.controller;

import com.testing15thnov_stage.services.calculator.services.CalculatorService;
import com.testing15thnov_stage.services.calculator.Add;
import com.testing15thnov_stage.services.calculator.AddResponse;
import com.testing15thnov_stage.services.calculator.Divide;
import com.testing15thnov_stage.services.calculator.DivideResponse;
import com.testing15thnov_stage.services.calculator.Multiply;
import com.testing15thnov_stage.services.calculator.MultiplyResponse;
import com.testing15thnov_stage.services.calculator.Subtract;
import com.testing15thnov_stage.services.calculator.SubtractResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public AddResponse add(@RequestBody Add parameters) {
        return calculatorService.add(parameters);
    }

    @RequestMapping(value = "/divide", method = RequestMethod.GET)
    public DivideResponse divide(@RequestParam(value = "intA", required = false) int intA, @RequestParam(value = "intB", required = false) int intB) {
        Divide parameters = new Divide();
        parameters.setIntA(intA);
        parameters.setIntB(intB);
        return calculatorService.divide(parameters);
    }

    @RequestMapping(value = "/multiply", method = RequestMethod.GET)
    public MultiplyResponse multiply(@RequestParam(value = "intA", required = false) int intA, @RequestParam(value = "intB", required = false) int intB) {
        Multiply parameters = new Multiply();
        parameters.setIntA(intA);
        parameters.setIntB(intB);
        return calculatorService.multiply(parameters);
    }

    @RequestMapping(value = "/subtract", method = RequestMethod.GET)
    public SubtractResponse subtract(@RequestParam(value = "intA", required = false) int intA, @RequestParam(value = "intB", required = false) int intB) {
        Subtract parameters = new Subtract();
        parameters.setIntA(intA);
        parameters.setIntB(intB);
        return calculatorService.subtract(parameters);
    }
}