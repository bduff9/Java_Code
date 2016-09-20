package com.mrc.Test;

public class Immutable {

	private static void changeVal(int val) {
		val++;
	}

	public static void main(String[] parms) {
		int	x = 0;
		
		System.out.println(x);
		
		changeVal(x);
		
		System.out.println(x);
	}
}