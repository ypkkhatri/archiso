package com.yog.fw.core.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.yog.fw.core.annotations.Allow;
import com.yog.fw.core.annotations.AllowTo;

/**
 * @author Yougeshwar
 * 
 * */
public class SecurityInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		if(handlerMethod.getMethod().isAnnotationPresent(Allow.class)) {
			
			return super.preHandle(request, response, handler);
		} else if(handlerMethod.getMethod().isAnnotationPresent(AllowTo.class)) {
			
			return super.preHandle(request, response, handler);
		} else {
//			response.
			return false;
		}
	}
}
