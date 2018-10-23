/**
 * ymm56.com Inc.
 * Copyright (c) 2013-2018 All Rights Reserved.
 */
package com.lisong.filter;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author song.li
 * @version $Id: AddResponseHeaderFilter.java, v 0.1 2018-10-23 09:56 song.li Exp $$
 */
public class AddResponseHeaderFilter extends ZuulFilter{

    @Override
    public String filterType() {
        return POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return SEND_RESPONSE_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext contxt = RequestContext.getCurrentContext();
        HttpServletResponse response = contxt.getResponse();
        response.addHeader("X_Sample", UUID.randomUUID().toString());
        return null;
    }
}