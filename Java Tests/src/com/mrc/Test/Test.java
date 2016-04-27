package com.mrc.Test;

import org.apache.commons.lang.StringUtils;

/**
 * Used for generic testing
 * @author Duffey
 */
public class Test {

	public static void main(String[] args) {
		String	url = "MRCISSUES.I00010s?slnk=1&CUSNO=${CUSNO}&test=${CUSNO}",
				fld = "CUSNO",
				replace = "${" + fld + "}",
				value = "12345";
		
		System.out.println(url);
		
		url = StringUtils.replace(url, replace, value);
		
		System.out.println(url);
	}
	
	public static void doSomething(String s) {
		s = "Not hello";
	}
}