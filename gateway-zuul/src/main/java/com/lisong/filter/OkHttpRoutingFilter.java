/**
 * ymm56.com Inc.
 * Copyright (c) 2013-2018 All Rights Reserved.
 */
package com.lisong.filter;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 *
 * @author song.li
 * @version $Id: OkHttpRoutingFilter.java, v 0.1 2018-10-23 10:01 song.li Exp $$
 */
public class OkHttpRoutingFilter  extends ZuulFilter{


    @Override
    public String filterType() {
        return ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return SIMPLE_HOST_ROUTING_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return RequestContext.getCurrentContext().getRouteHost() != null
                && RequestContext.getCurrentContext().sendZuulResponse();
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }
}