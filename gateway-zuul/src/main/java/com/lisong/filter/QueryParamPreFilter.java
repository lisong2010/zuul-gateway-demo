/**
 * ymm56.com Inc.
 * Copyright (c) 2013-2018 All Rights Reserved.
 */
package com.lisong.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 *
 * @author song.li
 * @version $Id: QueryParamPreFilter.java, v 0.1 2018-10-23 09:25 song.li Exp $$
 */
public class QueryParamPreFilter extends ZuulFilter{

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        return !ctx.containsKey(FilterConstants.FORWARD_TO_KEY) && !ctx.containsKey(FilterConstants.SERVICE_ID_KEY);
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        if(request.getParameter("sample") != null) {
            ctx.put(FilterConstants.SERVICE_ID_KEY, request.getParameter("foo"));
        }
        return null;
    }
}