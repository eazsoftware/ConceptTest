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
package com.eaz.logback.layout.patternlayout.conversion;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.ConsoleAppender;

public class Coloring {

    static public void main(String[] args) throws Exception {
        Logger rootLogger = (Logger) LoggerFactory.getLogger(Coloring.class);

        //Conversion words 
        rootLogger.info("---> Coloring <---");
        //The %highlight conversion specifier prints its sub-pattern in bold-red for events of level ERROR, in red for WARN, in BLUE for INFO, and in the default color for other levels.
        printLog(rootLogger, "%magenta([%thread]) %highlight(%-5level) %cyan(%logger{15}) - %boldGreen(%msg%n)");
    }

    protected static void printLog(Logger rootLogger, String strPattern) {
        LoggerContext loggerContext = rootLogger.getLoggerContext();
        loggerContext.reset();

        PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setContext(loggerContext);
        encoder.setPattern(strPattern);
        encoder.start();

        ConsoleAppender<ILoggingEvent> appender = new ConsoleAppender<>();
        appender.setContext(loggerContext);
        appender.setEncoder(encoder);
        appender.start();

        rootLogger.addAppender(appender);

        rootLogger.trace("Message 1 - Trace");
        rootLogger.debug("Message 2 - Debug");
        rootLogger.info("Message 3 - Info");
        rootLogger.warn("Message 4 - Warn");
        rootLogger.error("Message 5 - Error");
    }  
    
}