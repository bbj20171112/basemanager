package com.bbj.controller.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 组件控制器
 * @author bage
 * 
 *
 */
@Controller
@RequestMapping({"/base/widgets"})
public class WidgetsController {

	/**
	 * 跳转到grid页面 
	 * @param request
	 * @return 跳转的页面
	 */
	@RequestMapping({"/grid"})
	public String grid(HttpServletRequest request){
		request.setAttribute("test", "abcd");
		return "widgets/grid";
	}
	@RequestMapping({"/button"})
    public String getButton(HttpServletRequest request){
        request.setAttribute("test", "abcd");
        return "widgets/button";
    }
	
	@RequestMapping({"/login"})
    public String login(HttpServletRequest request){
        request.setAttribute("test", "abcd");
        //System.out.println(request.getParameter("userName").toString()+request.getParameter("password").toString());
        return "widgets/login";
    }
	
	@RequestMapping({"/register"}) 
    public String register(HttpServletRequest request){
        request.setAttribute("test", "abcd");
        return "widgets/register";
    }
	
	@RequestMapping({"/bbjwidgets"}) 
    public String bbjwidgets(HttpServletRequest request){
        request.setAttribute("test", "abcd");
        return "widgets/bbjwidgets";
    }
	public void a() {}
}
