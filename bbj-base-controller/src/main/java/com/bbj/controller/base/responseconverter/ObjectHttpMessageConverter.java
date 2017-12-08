package com.bbj.controller.base.responseconverter;

import org.springframework.core.convert.ConversionService;
import org.springframework.http.converter.ObjectToStringHttpMessageConverter;

public class ObjectHttpMessageConverter extends ObjectToStringHttpMessageConverter {

	public ObjectHttpMessageConverter(ConversionService conversionService) {
		super(conversionService);
		// TODO Auto-generated constructor stub
	}

	
}
