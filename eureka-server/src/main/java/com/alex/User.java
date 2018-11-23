/**
 * ymm56.com Inc.
 * Copyright (c) 2013-2018 All Rights Reserved.
 */
package com.alex;

import com.sun.prism.impl.Disposer.Record;
import java.lang.invoke.MethodHandles.Lookup;
import java.util.Hashtable;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

/**
 *
 * @author song.li
 * @version $Id: User.java, v 0.1 2018-11-05 19:33 song.li Exp $$
 */
public class User {
    private static final String DNS_PROVIDER_URL = "dns:";
    private static final String DNS_NAMING_FACTORY = "com.sun.jndi.dns.DnsContextFactory";
    private static final String JAVA_NAMING_FACTORY_INITIAL = "java.naming.factory.initial";
    private static final String JAVA_NAMING_PROVIDER_URL = "java.naming.provider.url";

    private static final String A_RECORD_TYPE = "A";
    private static final String CNAME_RECORD_TYPE = "CNAME";
    private static final String TXT_RECORD_TYPE = "TXT";

    public static void main(String[] args) {
        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(JAVA_NAMING_FACTORY_INITIAL, DNS_NAMING_FACTORY);
        env.put(JAVA_NAMING_PROVIDER_URL, DNS_PROVIDER_URL);

        try {
            DirContext dirContext =  new InitialDirContext(env);
            dirContext.getAttributes("eureka.huodongke.com", new String[]{TXT_RECORD_TYPE});
        } catch (Throwable e) {
            throw new RuntimeException("Cannot get dir context for some reason", e);
        }
    }
}