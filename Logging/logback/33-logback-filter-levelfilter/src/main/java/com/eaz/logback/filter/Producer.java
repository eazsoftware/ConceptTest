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

public class Producer {

    public static void main(String[] args) throws InterruptedException {
        Logger logger = LoggerFactory.getLogger(Producer.class);

        for (int i = 0; i < 10; i++) {
            if (i % 5 == 0) {
                logger.warn("a warning message " + i);
            } else if (i % 3 == 0) {
                logger.info("hello world number" + i);
            } else {
                logger.debug("hello world number" + i);
            }
        }
        logger.error("Finish off with fireworks", new Exception("Just testing"));
    }
}
