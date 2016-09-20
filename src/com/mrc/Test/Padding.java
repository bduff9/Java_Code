package com.mrc.Test;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Random;

public class Padding {

	/**
	 * @param val A positive integer value
	 * @param size The size to fill to
	 * @return The given value left padded with the given number of digits
	 */
	public static String padZero(BigInteger val, int size) {
		StringBuilder sb = new StringBuilder();
		BigInteger valCopy = val,
				ten = BigInteger.valueOf(10);
		int len = 0;
		
		do {
		    valCopy = valCopy.divide(ten);
		    len++;
		} while (!valCopy.equals(BigInteger.ZERO));

		for (int i = size; i > len; i--) sb.append('0');

		sb.append(val);

		return sb.toString();       
	}

	public static void main(String[] args) {
		Random rdm;
		long start; 

		// Using own function
		rdm = new Random(0);
		start = System.nanoTime();

		for (int i = 10000000; i != 0; i--){
			padZero(BigInteger.valueOf(rdm.nextInt(999999999)), 24);
		}
		System.out.println("Own function: " + ((System.nanoTime() - start) / 1E9) + " sec");
		
		// Using String.format
		rdm = new Random(0);        
		start = System.nanoTime();

		for (int i = 10000000; i != 0; i--){
			String.format("%024d", rdm.nextInt(999999999));
		}
		System.out.println("String.format: " + ((System.nanoTime() - start) / 1E9) + " sec");

		// Using Decimalformat
		rdm = new Random(0);        
		start = System.nanoTime();

		for (int i = 10000000; i != 0; i--){
			DecimalFormat df = new DecimalFormat("000000000000000000000000");
			df.format(rdm.nextInt(999999999));
		}
		System.out.println("Decimalformat: " + ((System.nanoTime() - start) / 1E9) + " sec");
	}

}