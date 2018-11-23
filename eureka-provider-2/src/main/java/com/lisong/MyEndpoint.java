/**
 * ymm56.com Inc.
 * Copyright (c) 2013-2018 All Rights Reserved.
 */
package com.lisong;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author song.li
 * @version $Id: MyEndpoint.java, v 0.1 2018-11-23 10:08 song.li Exp $$
 */
@WebEndpoint(id = "test")
public class MyEndpoint {

    @Autowired
    private ApplicationContext applicationContext;

    @ReadOperation
    public User getMyEndpoint() {
        String[] beanNames = BeanFactoryUtils.beanNamesForAnnotationIncludingAncestors(
                applicationContext, Endpoint.class);
        return new User("alex", "32");
    }

    class User {
        String name;
        String age;

        public User(String name, String age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }
}