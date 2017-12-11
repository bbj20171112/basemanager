package com.bbj.controller.base.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter
{

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // 将请求和响应强制转换成Http形式
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        // 处理响应乱码
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 放行的时候应该传入增强后的request对象
        chain.doFilter(req, res);
    }

    public void destroy() {

    }

}
