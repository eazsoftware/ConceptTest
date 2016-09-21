/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eaz.stringutils.padding;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author javier
 */
public class PadAndTrim {

    public static final String SPACE = " ";
    public static final String ZERO = "0";
    public static final String EMPTY = "";
    
    public static String padRight(String text, String character, int iRepeat) {
        return StringUtils.rightPad(StringUtils.defaultString(text), iRepeat, character);
    }     

    public static String padRightNTrimLeft(String text, String character, int iRepeat, int iTrim) {
        return StringUtils.left(padRight(text, character, iRepeat), iTrim);
    }
    
    public static String padLeft(String text, String character, int iRepeat) {
        return StringUtils.leftPad(StringUtils.defaultString(text), iRepeat, character);
    }     

    public static String padLeftNTrimRight(String text, String character, int iRepeat, int iTrim) {
        return StringUtils.right(padLeft(text, character, iRepeat), iTrim);
    }

    public static String trailing(String character, int iRepeat) {
        return StringUtils.repeat(character, iRepeat);
    }    

    public static void main(String[] args) throws IOException {

        /* *** padLeft ****************************************************** */
        
        String str = "Pad Me";
        System.out.printf("%-15s[%s]\n", "Original:", str);

        System.out.println();

        System.out.printf("%-15s[%s]\n", "String Padded with pad 0:", PadAndTrim.padLeft(str, SPACE, 0));
        System.out.printf("%-15s[%s]\n", "String Padded with pad 5:", PadAndTrim.padLeft(str, SPACE, 5));
        System.out.printf("%-15s[%s]\n", "String Padded with pad 10:", PadAndTrim.padLeft(str, SPACE, 10));
        
        System.out.println();
        
        str = "";
        
        System.out.printf("%-15s[%s]\n", "Empty String with pad 5:", PadAndTrim.padLeft(str, SPACE, 5));
        System.out.printf("%-15s[%s]\n", "Empty String with pad 10:", PadAndTrim.padLeft(str, SPACE, 10));

        System.out.println();
        
        str = null;
        
        System.out.printf("%-15s[%s]\n", "Null String with pad 5:", PadAndTrim.padLeft(str, SPACE, 5));
        System.out.printf("%-15s[%s]\n", "Null String with pad 10:", PadAndTrim.padLeft(str, SPACE, 10));

        System.out.println();
        
        /* *** padLeftNTrim ************************************************* */
        
        str = "Pad Me";
        System.out.printf("%-15s[%s]\n", "Original:", str);

        System.out.println();

        System.out.printf("%-15s[%s]\n", "Left String Padded with pad 0 and trim 0:",  PadAndTrim.padLeftNTrimRight(str, ZERO, 0, 0));
        System.out.printf("%-15s[%s]\n", "Left String Padded with pad 0 and trim 5:",  PadAndTrim.padLeftNTrimRight(str, ZERO, 0, 5));
        System.out.printf("%-15s[%s]\n", "Left String Padded with pad 5 and trim 5:",  PadAndTrim.padLeftNTrimRight(str, ZERO, 5, 5));
        System.out.printf("%-15s[%s]\n", "Left String Padded with pad 5 and trim 10:", PadAndTrim.padLeftNTrimRight(str, ZERO, 5, 10));
        System.out.printf("%-15s[%s]\n", "Left String Padded with pad 16 and trim 20:", PadAndTrim.padLeftNTrimRight(str, ZERO, 20, 16));
        System.out.printf("%-15s[%s]\n", "Left String Padded with pad 10 and trim 10:", PadAndTrim.padLeftNTrimRight(str, ZERO, 20, 10));
        System.out.printf("%-15s[%s]\n", "Left String Padded with pad 20 and trim 20:", PadAndTrim.padLeftNTrimRight(str, ZERO, 20, 20));
        
        System.out.println();
        
        /* *** trailing**** ************************************************* */
        System.out.printf("%-15s[%s]\n", "Trailing 20 empty characters:", PadAndTrim.trailing(EMPTY, 20));
        System.out.printf("%-15s[%s]\n", "Trailing 20 space characters:", PadAndTrim.trailing(SPACE, 20));        
        System.out.printf("%-15s[%s]\n", "Trailing 20 zero characters:", PadAndTrim.trailing(ZERO, 20));
        
        /* *** padRightNTrim ************************************************* */
        
        str = "Pad Me";
        System.out.printf("%-15s[%s]\n", "Original:", str);

        System.out.println();

        System.out.printf("%-15s[%s]\n", "Right String Padded with pad 0 and trim 0:",  PadAndTrim.padRightNTrimLeft(str, ZERO, 0, 0));
        System.out.printf("%-15s[%s]\n", "Right String Padded with pad 0 and trim 5:",  PadAndTrim.padRightNTrimLeft(str, ZERO, 0, 5));
        System.out.printf("%-15s[%s]\n", "Right String Padded with pad 5 and trim 5:",  PadAndTrim.padRightNTrimLeft(str, ZERO, 5, 5));
        System.out.printf("%-15s[%s]\n", "Right String Padded with pad 5 and trim 10:", PadAndTrim.padRightNTrimLeft(str, ZERO, 5, 10));
        System.out.printf("%-15s[%s]\n", "Right String Padded with pad 16 and trim 20:", PadAndTrim.padRightNTrimLeft(str, ZERO, 20, 16));
        System.out.printf("%-15s[%s]\n", "Right String Padded with pad 10 and trim 10:", PadAndTrim.padRightNTrimLeft(str, ZERO, 20, 10));
        System.out.printf("%-15s[%s]\n", "Right String Padded with pad 20 and trim 20:", PadAndTrim.padRightNTrimLeft(str, ZERO, 20, 20));
        
        System.out.println();        
        
    }

}
