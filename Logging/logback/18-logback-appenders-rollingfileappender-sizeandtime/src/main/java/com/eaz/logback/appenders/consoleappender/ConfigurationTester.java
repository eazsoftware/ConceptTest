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
package com.eaz.logback.appenders.consoleappender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import ch.qos.logback.classic.LoggerContext;
import com.eaz.logback.appenders.consoleappender.sub.sample.Bar;
import java.io.IOException;
import java.util.Calendar;

/**
 *
 * This class can be used to check the result of a configuration file.
 *
 * @author S&eacute;bastien Pennec
 */
public class ConfigurationTester {

    public static void main(String[] args) throws InterruptedException, IOException {
        Logger logger = (Logger) LoggerFactory.getLogger(ConfigurationTester.class);
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();

        logger.debug("**Hello {}", new Bar());
        MDC.put("testKey", "testValueFromMDC");
        MDC.put("testKey2", "value2");
        for (int i = 0; i < 10; i++) {
            logger.debug("logging statement " + i);
            logger.debug(strExtraordinaryHugeLogMessage);
            Thread.sleep(100);
        }
        Bar bar = new Bar();
        bar.createLoggingRequest();
    }

    private static String strExtraordinaryHugeLogMessage = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus pharetra erat ligula, at commodo ipsum vulputate a. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vivamus pharetra semper sem, id bibendum eros iaculis sit amet. Etiam rutrum pellentesque lacus, vitae faucibus justo facilisis a. Ut consectetur eu odio vitae pretium. Nullam viverra metus at nisl rutrum, dapibus rutrum sem condimentum. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque vitae metus ante. Mauris luctus lacus in augue facilisis, sit amet ornare mi tristique. In sit amet arcu dapibus, mattis nibh ut, vehicula nunc."
            + "Morbi suscipit leo eu pretium porttitor. Phasellus sagittis sit amet risus et iaculis. Integer ac congue neque, ut dignissim eros. Praesent elementum laoreet sollicitudin. In ultrices ipsum id neque aliquet pretium. Vivamus pulvinar et sapien quis feugiat. Duis eleifend pellentesque ipsum, vitae ornare nibh efficitur at. Nulla aliquam, risus a mollis molestie, leo sem placerat lacus, in hendrerit enim dui ac elit."
            + "Duis lectus purus, semper sed nisl in, ultrices varius mi. Etiam a interdum turpis. Aenean malesuada urna ac molestie sagittis. Nunc placerat ornare commodo. Morbi sagittis quis ex eu maximus. Suspendisse sed ante ipsum. Cras mattis diam est, id porta erat ullamcorper nec. Aliquam vel eleifend turpis."
            + "Cras lorem justo, ultrices quis lacinia eget, gravida ut turpis. Quisque nec ultrices justo. Praesent erat neque, rhoncus sit amet dolor non, faucibus tincidunt arcu. Morbi viverra elementum sapien, eu malesuada augue vehicula finibus. Donec accumsan ex cursus imperdiet feugiat. Nullam tristique quis nulla eu venenatis. Donec nec nulla mauris. Quisque dictum velit vel pretium egestas. Interdum et malesuada fames ac ante ipsum primis in faucibus. Quisque sodales finibus odio elementum malesuada. Quisque vulputate lacus id commodo placerat. Sed maximus massa accumsan bibendum tristique."
            + "Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed vitae magna iaculis, cursus justo eu, sodales ipsum. Nunc varius tempus tellus et ultrices. Aenean aliquet tempor lacinia. Maecenas ut turpis purus. Fusce vestibulum rutrum felis ut dictum. Sed quis neque et lacus malesuada hendrerit sed non ligula. Aenean laoreet, turpis nec ultricies mollis, tellus risus molestie odio, eu rutrum nibh sapien vel justo. Aenean placerat luctus nibh vel accumsan."
            + "Donec vulputate sapien quis eleifend bibendum. Donec tristique magna a mollis lacinia. Aenean accumsan, magna ultrices maximus porttitor, lacus risus viverra arcu, eget sollicitudin est diam eget sem. Nunc sed enim nibh. Suspendisse placerat turpis a lorem suscipit, id commodo felis elementum. Nam porttitor dolor ac libero dignissim tincidunt. Duis sit amet interdum nibh, sit amet tempor purus. Nullam ut dui ac est blandit tristique eu id nisl. Aliquam ante felis, blandit eget viverra eget, ultrices eget nulla. Vestibulum volutpat nulla in lorem sagittis congue. Cras a ultrices enim. Fusce eu justo nec lectus varius egestas. Suspendisse et risus vitae nunc imperdiet tincidunt."
            + "Nullam metus quam, fermentum at est ac, molestie vestibulum odio. Etiam tincidunt lacus vel lacinia molestie. Mauris aliquam purus ac ipsum dapibus, at tristique magna fermentum. Nulla facilisi. Nullam malesuada euismod mi.";
}
