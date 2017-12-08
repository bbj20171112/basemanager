package com.bbj.controller.base.filter;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.DispatcherServlet;

public class BBJDispatcherServlet extends DispatcherServlet
{

    private static final long serialVersionUID = 1L;

    @Override
    protected void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("BBJDispatcherServlet.doService() is work ");
        //1:判断是否是ajax请求
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = request;
            if (httpRequest.getHeader("x-requested-with") != null
                    && "XMLHttpRequest".equalsIgnoreCase(httpRequest.getHeader("x-requested-with"))) {
                System.out.println("is ajax");
                Map<String, String> map = new HashMap<String, String>();
                Enumeration<?> paramNames = request.getParameterNames();
                while (paramNames.hasMoreElements()) {
                    String paramName = (String) paramNames.nextElement();

                    String[] paramValues = request.getParameterValues(paramName);
                    if (paramValues.length == 1) {
                        String paramValue = paramValues[0];
                        if (paramValue.length() != 0) {
                            System.out.println("参数：" + paramName + "=" + paramValue);
                            map.put(paramName, paramValue);
                        }
                    }
                }
            }
            else {
                System.out.println("not ajax");
            }
        }
        super.doService(request, response);
    }

    @Override
    protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.doDispatch(request, response);
    }

}
