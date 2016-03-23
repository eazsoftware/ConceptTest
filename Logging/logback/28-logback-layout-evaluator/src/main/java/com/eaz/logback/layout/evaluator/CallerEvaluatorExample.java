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
package com.eaz.logback.layout.evaluator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CallerEvaluatorExample {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(CallerEvaluatorExample.class);

        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                logger.debug("who calls thee?");
            } else {
                logger.debug("I know me " + i);
            }
        }
    }
}
