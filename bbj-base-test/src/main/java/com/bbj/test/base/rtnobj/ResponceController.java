package com.bbj.test.base.rtnobj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbj.test.base.crud.DemoDomain;

@Controller
@RequestMapping("/example/response")
public class ResponceController {

	@RequestMapping("/test")
	@ResponseBody
	public Object test() {
		System.out.println("test");
		return new DemoDomain();
	}
	
}
