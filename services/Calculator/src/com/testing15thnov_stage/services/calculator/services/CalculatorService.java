/**This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

package com.testing15thnov_stage.services.calculator.services;
import com.testing15thnov_stage.services.calculator.*;
import java.util.List;

import com.wavemaker.runtime.soap.util.SoapSettingsResolver;
import com.wavemaker.runtime.soap.SoapServiceSettings;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import javax.xml.ws.BindingProvider;



@Service
public class CalculatorService{

    @Autowired
    @Qualifier("CalculatorSoapServiceSettings")
    private SoapServiceSettings soapServiceSettings;


	public SubtractResponse subtract(  com.testing15thnov_stage.services.calculator.Subtract parameters )
	          {
 	    Calculator calculator = new Calculator();
 CalculatorSoap calculatorsoap = calculator.getCalculatorSoap12();
 SoapSettingsResolver.setBindingProperties((BindingProvider)calculatorsoap, soapServiceSettings);
 return calculatorsoap.subtract(parameters );
	}

	public DivideResponse divide(  com.testing15thnov_stage.services.calculator.Divide parameters )
	          {
 	    Calculator calculator = new Calculator();
 CalculatorSoap calculatorsoap = calculator.getCalculatorSoap12();
 SoapSettingsResolver.setBindingProperties((BindingProvider)calculatorsoap, soapServiceSettings);
 return calculatorsoap.divide(parameters );
	}

	public AddResponse add(  com.testing15thnov_stage.services.calculator.Add parameters )
	          {
 	    Calculator calculator = new Calculator();
 CalculatorSoap calculatorsoap = calculator.getCalculatorSoap12();
 SoapSettingsResolver.setBindingProperties((BindingProvider)calculatorsoap, soapServiceSettings);
 return calculatorsoap.add(parameters );
	}

	public MultiplyResponse multiply(  com.testing15thnov_stage.services.calculator.Multiply parameters )
	          {
 	    Calculator calculator = new Calculator();
 CalculatorSoap calculatorsoap = calculator.getCalculatorSoap12();
 SoapSettingsResolver.setBindingProperties((BindingProvider)calculatorsoap, soapServiceSettings);
 return calculatorsoap.multiply(parameters );
	}
}