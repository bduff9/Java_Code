package com.mrc.ExtObjs;

public class Add1 {

	public static void main(String[] parms) {
		int num = Integer.parseInt(parms[0]);
		num =+ Integer.parseInt(parms[1]);
		parms[0] = "" + num;
	}

}
