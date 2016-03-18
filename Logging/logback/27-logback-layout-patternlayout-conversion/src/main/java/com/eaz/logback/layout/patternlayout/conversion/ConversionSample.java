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

public class ConversionSample {

    static public void main(String[] args) throws Exception {
        Logger rootLogger = (Logger) LoggerFactory.getLogger(ConversionSample.class);

        //printLog(rootLogger, "%-5level [%thread]: %message%n");
        //logger, lo, c
        rootLogger.info("---> logger <---");
        printLog(rootLogger, "%logger: %message%n");
        printLog(rootLogger, "%logger{20}: %message%n");
        printLog(rootLogger, "%logger{50}: %message%n");
        printLog(rootLogger, "%logger{100}: %message%n");
        //class, C
        rootLogger.info("---> class <---");
        printLog(rootLogger, "%class: %message%n");
        printLog(rootLogger, "%class{50}: %message%n");
        //contextName, cn
        rootLogger.info("---> contextName <---");
        printLog(rootLogger, "%contextName: %message%n");
        //date, d
        rootLogger.info("---> date <---");
        printLog(rootLogger, "%date: %message%n");
        printLog(rootLogger, "%date{ISO8601}: %message%n");
        printLog(rootLogger, "%date{HH:mm:ss.SSS}: %message%n");
        printLog(rootLogger, "%date{dd MMM yyyy;HH:mm:ss.SSS}: %message%n");
        printLog(rootLogger, "%date{\"HH:mm:ss.SSS, zzz\"}: %message%n"); //"Finally I realized that pattern "zzz" is not replaced if the pattern is not surrounded by double quotes": http://jira.qos.ch/browse/LOGBACK-688
        //file, F
        rootLogger.info("---> file <---");
        printLog(rootLogger, "%file: %message%n");
        //caller
        rootLogger.info("---> caller <---");
        printLog(rootLogger, "%caller: %message%n");
        printLog(rootLogger, "%caller{0}: %message%n");
        printLog(rootLogger, "%caller{1}: %message%n");
        printLog(rootLogger, "%caller{2}: %message%n");
        //line, L
        rootLogger.info("---> caller <---");
        printLog(rootLogger, "%line: %message%n");
        //message, msg, m
        rootLogger.info("---> message <---");
        printLog(rootLogger, "%message%n");
        printLog(rootLogger, "%msg%n");
        printLog(rootLogger, "%m%n");
        //method, M
        rootLogger.info("---> message <---");
        printLog(rootLogger, "%method: %message%n");
        //n
        rootLogger.info("---> n <---");
        printLog(rootLogger, "%n%message%n");
        //level, le, p
        rootLogger.info("---> level <---");
        printLog(rootLogger, "%level: %message%n");
        //relative, r
        rootLogger.info("---> relative <---");
        printLog(rootLogger, "%relative: %message%n");
        Thread.sleep(100);
        printLog(rootLogger, "%relative: %message%n");
        //thread, t
        rootLogger.info("---> thread <---");
        printLog(rootLogger, "%thread: %message%n");
        //mdc, X

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