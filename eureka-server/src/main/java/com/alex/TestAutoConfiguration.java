/**
 * ymm56.com Inc.
 * Copyright (c) 2013-2018 All Rights Reserved.
 */
package com.alex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @author song.li
 * @version $Id: TestAutoConfiguration.java, v 0.1 2018-11-05 19:33 song.li Exp $$
 */
@Configuration
@Import({ TestDocScan.class})
public class TestAutoConfiguration {

    @Bean
    public User getUser() {
        return new User();
    }


}