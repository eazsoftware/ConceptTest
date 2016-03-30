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
package com.eaz.logback.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class FilterEvents {

    public static void main(String[] args) throws InterruptedException {
        Logger logger = (Logger) LoggerFactory.getLogger(FilterEvents.class);

        for (int i = 0; i < 10; i++) {
            switch (i) {
                case 3:
                    MDC.put("username", "sebastien");
                    MDC.put("password", "nopass");
                    logger.debug("logging statement first {}", i);
                    MDC.remove("username");
                    MDC.remove("password");
                    break;
                case 6:
                    Marker billing = MarkerFactory.getMarker("billing");
                    MDC.put("password", "differentpass");
                    logger.error(billing, "billing statement second {}", i);
                    MDC.remove("password");
                    break;
                default:
                    MDC.put("password", "nopass");
                    logger.info("logging statement third {}", i);
                    MDC.remove("password");
                    break;
            }
        }
    }
}
