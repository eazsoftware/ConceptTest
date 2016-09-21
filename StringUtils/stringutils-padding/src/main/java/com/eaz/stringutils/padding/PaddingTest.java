package com.eaz.stringutils.padding;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

public class PaddingTest {

	public static void main(String[] args) throws IOException {

		String str = "Pad Me";
		System.out.printf("%-15s[%s]\n", "Original:", str);

		System.out.println();

		System.out.printf("%-15s[%s]\n", "Left Padded:", StringUtils.leftPad(str, 10));
		System.out.printf("%-15s[%s]\n", "Right Padded:", StringUtils.rightPad(str, 10));
		System.out.printf("%-15s[%s]\n", "Centered:", StringUtils.center(str, 10));

		System.out.println();

		System.out.printf("%-15s[%s]\n", "Left Padded:", StringUtils.leftPad(str, 10, "*"));
		System.out.printf("%-15s[%s]\n", "Right Padded:", StringUtils.rightPad(str, 10, "*"));
		System.out.printf("%-15s[%s]\n", "Centered:", StringUtils.center(str, 10, "*"));
        
		str = "Pad is longer than expected";
        
        System.out.println();
        
		System.out.printf("%-15s[%s]\n", "Left Padded:", StringUtils.leftPad(str, 10, "*"));
		System.out.printf("%-15s[%s]\n", "Right Padded:", StringUtils.rightPad(str, 10, "*"));
		System.out.printf("%-15s[%s]\n", "Centered:", StringUtils.center(str, 10, "*"));        

	}

}