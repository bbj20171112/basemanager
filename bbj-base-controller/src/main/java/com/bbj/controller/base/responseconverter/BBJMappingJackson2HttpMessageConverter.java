package com.bbj.controller.base.responseconverter;

import java.io.IOException;
import java.lang.reflect.Type;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.bbj.bizlogic.base.domain.BBJResponse;

public class BBJMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter{

	@Override
	protected void writeInternal(Object object, Type type, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		System.out.println("object:" + object);
		super.writeInternal(new BBJResponse("success", object), type, outputMessage);
	}

	
}
