package com.spring.microservices.zuul.zuulfilter;

import javax.servlet.http.HttpServletRequest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter{
    
    private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Override
	public Object run() throws ZuulException {
	    HttpServletRequest request= RequestContext.getCurrentContext().getRequest();
	    logger.info("request -> {} request uri -> {}",request,request.getRequestURI());
		return null;
	}

	@Override
	public boolean shouldFilter() {
	
		return true;
	}
    /*
     * Incase of Multiple filters when this filter should execute
     * **/
	@Override
	public int filterOrder() {
		
		return 1;
	}
    
	/*
	 * When it should execute
	 * **/
	@Override
	public String filterType() {
		
		//return "pre";
		//return "post";
		return "pre";
	}

}
