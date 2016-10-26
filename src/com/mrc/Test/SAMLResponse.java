package com.mrc.Test;

import java.io.BufferedInputStream;
import java.util.Base64;
import java.util.Scanner;

public class SAMLResponse {

	private static final int	BASE64_LN = 76;

	public static void main(String[] unused) {
		Scanner	stdin = new Scanner(new BufferedInputStream(System.in));
		String	xml = "",
				byteXml, inp;
		int	x = 0,
			y;

		while (true) {
			inp = stdin.nextLine();

			if (inp.trim().length() == 0) break;

			if (xml.trim().length() > 0) xml += "\r\n";

			xml += inp;
		}

		byteXml = Base64.getEncoder().encodeToString(xml.getBytes());

		while (x < byteXml.length()) {
			y = Math.min(x + BASE64_LN, byteXml.length());

			System.out.println(byteXml.substring(x, y));

			x = y;
		}

		System.out.println();

		stdin.close();
	}
}