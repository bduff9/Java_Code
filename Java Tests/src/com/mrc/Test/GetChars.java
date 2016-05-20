package com.mrc.Test;

import java.util.Arrays;

public class GetChars {

	public static void main(String[] args) {
		char[]	chars = new char[10];
		String	val = "XX";
		int	valLen = val.length(),
			length = 10;
		
		for (int i = 0; i < chars.length; i++) chars[i] = ("" + i).charAt(0);
		
		val.getChars(0, (valLen > length) ? length : valLen, chars, 5);
		
		System.out.println(val);
		System.out.println(Arrays.toString(chars));
	}
}