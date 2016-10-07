package com.mrc.Test;

import java.math.BigDecimal;

/**
 * Used for generic testing
 * @author Duffey
 */
public class Test {

	public static void main(String[] args) {
		String	largeNumStr = "2500.00";
		BigDecimal	largeNum = new BigDecimal(largeNumStr);
		
		System.out.println(largeNum);
	}
}