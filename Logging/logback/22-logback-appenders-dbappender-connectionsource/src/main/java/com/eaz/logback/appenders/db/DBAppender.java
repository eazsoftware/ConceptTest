/**
 * Logback: the reliable, generic, fast and flexible logging framework.
 * Copyright (C) 1999-2015, QOS.ch. All rights reserved.
 *
 * This program and the accompanying materials are dual-licensed under either
 * the terms of the Eclipse Public License v1.0 as published by the Eclipse
 * Foundation
 *
 * or (per the licensee's choosing)
 *
 * under the terms of the GNU Lesser General Public License version 2.1 as
 * published by the Free Software Foundation.
 */
package com.eaz.logback.appenders.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This application generates log messages in numbers specified by the user.
 *
 */
public class DBAppender {

    static public void main(String[] args) throws Exception {
        Logger logger = LoggerFactory.getLogger(DBAppender.class);

        int runLength = 25;
        
        for (int i = 1; i <= runLength; i++) {
            if ((i % 10) < 9) {
                logger.debug("This is a debug message. Message number: " + i);
            } else {
                logger.warn("This is a warning message. Message number: " + i);
            }

            if (i == 13) { //For testing Evaluator condition (email on any ERROR)
                logger.error("Bad things always happen on Friday 13th");
            }
        }

        logger.error("At last an error.", new Exception("Just testing"));
    }
    
}
