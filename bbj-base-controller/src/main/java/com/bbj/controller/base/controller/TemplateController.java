package com.bbj.controller.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value={"/template"})
public class TemplateController {

	@RequestMapping(value={"/404"})
	public String notFound(){
		System.out.println("404");
		return "template/404";
	}
	@RequestMapping(value={"/500"})
	public String error(){
		System.out.println("500");
		return "template/500";
	}
	@RequestMapping(value={"/css"})
	public String css(){
		System.out.println("css");
		return "template/css";
	}
	@RequestMapping(value={"/javascript"})
	public String javascript(){
		System.out.println("javascript");
		return "template/javascript";
	}
	@RequestMapping(value={"/invoice"})
	public String invoice(){
		System.out.println("invoice");
		return "template/invoice";
	}
	@RequestMapping(value={"/profile"})
	public String profile(){
		System.out.println("profile");
		return "template/profile";
	}
	@RequestMapping(value={"/lockscreen"})
	public String lockscreen(){
		System.out.println("lockscreen");
		return "template/lockscreen";
	}
	@RequestMapping(value={"/login"})
	public String login(){
		System.out.println("login");
		return "template/login";
	}
}
