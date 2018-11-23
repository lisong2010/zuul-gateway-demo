/**
 * ymm56.com Inc.
 * Copyright (c) 2013-2018 All Rights Reserved.
 */
package com.lisong;

import java.util.Objects;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;

/**
 *
 * @author song.li
 * @version $Id: MyHealthIndicator.java, v 0.1 2018-11-22 11:27 song.li Exp $$
 */
public class MyHealthIndicator extends AbstractHealthIndicator {
    String status = "DOWN";
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    protected void doHealthCheck(Builder builder) throws Exception {
        if(Objects.equals(status, "UP")) {
            builder.up();
        } else {
            builder.down();
        }
    }
}