/**
 * Logback: the reliable, generic, fast and flexible logging framework.
 * Copyright (C) 1999-2015, QOS.ch. All rights reserved.
 *
 * This program and the accompanying materials are dual-licensed under
 * either the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation
 *
 *   or (per the licensee's choosing)
 *
 * under the terms of the GNU Lesser General Public License version 2.1
 * as published by the Free Software Foundation.
 */
package com.eaz.logback.appenders.sift;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import ch.qos.logback.core.joran.spi.JoranException;

public class SiftExample {

    public static void main(String[] args) throws JoranException {
        Logger logger = LoggerFactory.getLogger(SiftExample.class);
        logger.debug("Application started");

        MDC.put("userid", "Alice");
        logger.debug("Alice says hello");
    }

}
