package com.mrc.Test;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		Table1 tbl1 = new Table1();
		Table2 tbl2 = new Table2();
		System.out.println(tbl1.getName());
		
		String[] test = {"1", "A", "2", "B", "3", "C"};
		int iLen = test.length;
		String[] questions = new String[iLen / 2];
		String[] answers = new String[iLen / 2];
		for (int i = 0, j = 0; i < iLen; i++) {
			questions[j] = test[i++];
			answers[j++] = test[i];
		}
		System.out.println(Arrays.toString(questions));
		System.out.println(Arrays.toString(answers));
		
	}

}
