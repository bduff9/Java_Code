package com.mrc.Test;

/**
 * Used for generic testing
 * @author Duffey
 */
public class Test {

	public static void main(String[] args) {
		String str = "Hello";
		
		System.out.println(str);
		
		doSomething(str);
		
		System.out.println(str);
	}
	
	public static void doSomething(String s) {
		s = "Not hello";
	}
}