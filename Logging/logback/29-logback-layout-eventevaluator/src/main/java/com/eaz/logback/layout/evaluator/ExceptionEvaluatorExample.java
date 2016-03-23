/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eaz.logback.layout.evaluator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eaz.logback.layout.evaluator.exception.TestException;

public class ExceptionEvaluatorExample {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(ExceptionEvaluatorExample.class);

        for (int i = 0; i < 3; i++) {
            if (i == 1) {
                logger.debug("logging statement " + i, new TestException("do not display this"));
            } else {
                logger.debug("logging statement " + i, new Exception("display"));
            }
        }
    }
}
