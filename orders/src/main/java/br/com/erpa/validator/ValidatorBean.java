package br.com.erpa.validator;

import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class ValidatorBean {
	
	
	public static Validator Validator() {
		return Validation.byDefaultProvider()
			    .configure()
			    .messageInterpolator(new ParameterMessageInterpolator())
			    .buildValidatorFactory()
			    .getValidator();
	}

}
