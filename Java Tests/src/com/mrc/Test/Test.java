package com.mrc.Test;

/**
 * Used for generic testing
 * @author Duffey
 */
public class Test {

	public static void main(String[] args) {
		String	largeNumStr = "000000006100020800";
		long	largeNum = Long.valueOf(largeNumStr, 10);
		
		System.out.println(largeNum);
	}
}