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

public class FormatModifiersSample {

    static public void main(String[] args) throws Exception {
        Logger rootLogger = (Logger) LoggerFactory.getLogger(FormatModifiersSample.class);

        rootLogger.info("---> Format modifiers <---");
        //Left justity: false; Min width: 20; Max width: none; Left pad with spaces if the logger name is less than 20 characters long.
        printLog(rootLogger, "%20logger: %message%n");
        //Left justity: true; Min width: 20; Max width: none; Right pad with spaces if the logger name is less than 20 characters long.
        printLog(rootLogger, "%-20logger: %message%n");
        //Left justity: NA; Min width: none; Max width: 30; Truncate from the beginning if the logger name is longer than 30 characters.
        printLog(rootLogger, "%.30logger: %message%n");
        //Left justity: false; Min width: 20; Max width: 30; Left pad with spaces if the logger name is shorter than 20 characters. However, if logger name is longer than 30 characters, then truncate from the beginning.
        printLog(rootLogger, "%20.30logger: %message%n");
        //Left justity: true; Min width: 20; Max width: 30; Right pad with spaces if the logger name is shorter than 20 characters. However, if logger name is longer than 30 characters, then truncate from the beginning.
        printLog(rootLogger, "%-20.30logger: %message%n");
        //Left justity: NA; Min width: none; Max width: 30; Truncate from the end if the logger name is longer than 30 characters.
        printLog(rootLogger, "%.-30logger: %message%n");

        //Format modifier truncation
        rootLogger.info("---> Format modifiers truncation <---");
        printLog(rootLogger, "[%20.20logger]%n");
        printLog(rootLogger, "[%80.80logger]%n");
        printLog(rootLogger, "[%-80.80logger]%n");
        printLog(rootLogger, "[%80.-80logger]%n");
    }

    protected static void printLog(Logger rootLogger, String strPattern, Exception exception) {
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

        rootLogger.error("Message 5 - Error", exception);
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