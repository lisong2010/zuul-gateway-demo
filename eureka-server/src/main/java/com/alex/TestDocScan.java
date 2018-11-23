/**
 * ymm56.com Inc.
 * Copyright (c) 2013-2018 All Rights Reserved.
 */
package com.alex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author song.li
 * @version $Id: TestDocScan.java, v 0.1 2018-11-23 11:08 song.li Exp $$
 */
@Configuration
public class TestDocScan {

    @Bean
    public User2 getUser2() {
        return new User2();
    }
}