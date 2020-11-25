package com.tzlabs.proxyserver;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class TrackingFilter extends ZuulFilter{
	
    private static final int      FILTER_ORDER =  1;
    private static final boolean  SHOULD_FILTER=true;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    public boolean shouldFilter() {
        return SHOULD_FILTER;
    }


    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
		ctx.addZuulRequestHeader("tmx-correlation-id", "TZAPPS_ZUUL_FILTER"); 
        return null;
    }
}
