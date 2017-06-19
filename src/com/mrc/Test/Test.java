package com.mrc.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Used for generic testing
 * @author Duffey
 */
public class Test {

	public static void main(String[] args) {
		String	charStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890 ,!\"&#$%'()+/:;<=>?@[]^`{|}~\\";
		Set<Character>	chars = new HashSet<>();

		for (char c: charStr.toCharArray()) chars.add(c);
		
		System.out.println(chars.toString());
	}
}