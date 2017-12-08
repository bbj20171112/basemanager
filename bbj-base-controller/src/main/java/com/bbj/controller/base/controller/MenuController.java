package com.bbj.controller.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value={"/menu"})
public class MenuController {

	@Autowired
	private com.bbj.bizlogic.base.service.MenuService MenuService;
	
	@RequestMapping(value={"/","/index"})
	public String index(){
		return "menu/index";
	}
	
	@RequestMapping(value={"/starter"})
	public String starter(){
		return "/AdminLTE/starter";
	}
	
	@RequestMapping(value={"/json"})
	@ResponseBody
	public String json(){
		System.out.println("IndexController.json() is work " );
		return "你好";
	}
	

	@RequestMapping(value={"/retrieve"})
	@ResponseBody
	public Object retrieve(){
		return MenuService.retrieve();
	}
	

	@RequestMapping(value={"/header"})
	public String header(){
		return "/menu/header";
	}
	
}
