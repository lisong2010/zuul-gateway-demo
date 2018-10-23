package com.lisong; /**
 * ymm56.com Inc.
 * Copyright (c) 2013-2018 All Rights Reserved.
 */

import com.lisong.filter.AddResponseHeaderFilter;
import com.lisong.filter.PasswordFilter;
import com.lisong.filter.PreZuulFilter;
import com.lisong.filter.QueryParamPreFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author song.li
 * @version $Id: ZuulApplication.java, v 0.1 2018-10-22 16:44 song.li Exp $$
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {

    @Bean
    public QueryParamPreFilter queryParamPreFilter() {
        return new QueryParamPreFilter();
    }

    @Bean
    public AddResponseHeaderFilter addResponseHeaderFilter() {
        return new AddResponseHeaderFilter();
    }

    @Bean
    public PreZuulFilter preZuulFilter() {
        return new PreZuulFilter();
    }

    @Bean
    public PasswordFilter passwordFilter(){
        return new PasswordFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}