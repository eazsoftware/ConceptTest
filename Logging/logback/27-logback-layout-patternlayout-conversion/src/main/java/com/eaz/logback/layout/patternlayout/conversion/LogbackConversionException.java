package com.eaz.logback.layout.patternlayout.conversion;

/**
 *
 * @author javier
 */
public class LogbackConversionException extends Exception {

    private static final long serialVersionUID = 7886010411742817L;

    public LogbackConversionException() throws Exception {
        throw new Exception("Default message");
    }

    public LogbackConversionException(String strMessage) throws Exception {
        throw new Exception(strMessage);
    }

}
