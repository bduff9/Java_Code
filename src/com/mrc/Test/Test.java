package com.mrc.Test;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.apache.commons.lang.text.StrSubstitutor;

/**
 * Used for generic testing
 * @author Duffey
 */
public class Test {

	public static void main(String[] args) {
		stringSub();

		String	test = "1234567890";
		int	index = 10;

		if (test != null && test.trim().length() > index)
			System.out.println(test.charAt(index));
	}

	public static void parseURLQueryString() {
		Map<String, String>	parms = new HashMap<>();
		String[]	nameValuePairs;
		String[]	parm;
		String	query = "salesforce=12412411251&case_id=123456";

		if (query == null || query.trim().length() == 0) return;

		nameValuePairs = query.split("&");

		for (String nameValuePair : nameValuePairs) {
			parm = nameValuePair.split("=");

			if (parm.length == 2) parms.put(parm[0], parm[1]);
		}

		System.out.println("Warranty: " + parms.get("warranty"));
		System.out.println("Case ID: " + parms.get("case_id"));
	}

	public static void testObjectStrings() {
		List<Object>	strings = new ArrayList<>();

		strings.add("test1");
		strings.add("test2");
		strings.add("test3");

		for (Object stringObj : strings) {
			System.out.println("Cast: " + (String) stringObj);
			System.out.println("toString: " + stringObj.toString());
		}
	}

	public static void generateRandomKey() {
		KeyGenerator	keyGen;
		SecretKey secretKey;

		try {
			keyGen = KeyGenerator.getInstance("AES");

			keyGen.init(128); // for example

			secretKey = keyGen.generateKey();

			System.out.println(secretKey.getEncoded());
			System.out.println(UUID.randomUUID());
		} catch (NoSuchAlgorithmException ex) {
			System.err.println("Error in generating random key");
			ex.printStackTrace();
		}
	}

	public static void testStringFormatter() {
		String	var1 = "blue";
		String	var2 = "hedgehog";
		String	result = String.format("The fastest %1$s animal is the %1$s %2$s!", var1, var2);

		System.out.println(result);
	}

	public static void replaceNullChars() {
		char[]	origArray = new char[]{ 'a', '\0', 'c', 'd' };
		String	fixedString = Arrays.toString(origArray).replace('\0', 'b');

		System.out.println("Original: " + Arrays.toString(origArray));
		System.out.println("Fixed:    " + fixedString);
	}

	public static void parseTableName() {
		String[]	test = new String[1];
		String	table = "DUFFMENU.MRCSEC1";

		test = table.split("\\.");

		System.out.println(prettyPrintArray(test));
	}

	public static void getDateLong() {
		Date	date = new Date();
		long	dateLong = date.getTime();

		System.out.println("Date:      " + date);
		System.out.println("Date long: " + dateLong);
		System.out.println("Date:      " + new Date(dateLong));
	}

	public static void padString() {
		int	length = 50;
		String	str = "test";

		System.out.println("Normal:    ***" + str + "***");
		System.out.println("Left Pad:  ***" + String.format("%" + length + "s", str) + "***");
		System.out.println("Right Pad: ***" + String.format("%-" + length + "s", str) + "***");
	}

	public static void deDupeArray() {
		String[]	dupes = { "3", "1", "2", "3", "3" };
		String[]	unique;
		Set<String>	uniqueList = new LinkedHashSet<>(Arrays.asList(dupes));

		System.out.println("Array before de-duping: " + Arrays.toString(dupes));

		unique = uniqueList.toArray(new String[uniqueList.size()]);

		System.out.println("Array after de-duping: " + Arrays.toString(unique));
	}

	public static void loopTest() {
		final int	LOOPS = 10;

		for (int i = 0; i < LOOPS; i++) {
			System.out.println("Outer loop: " + i);

			for (int j = 0; j < LOOPS; j++) {
				System.out.println("  Inner loop 1: " + j);

				if (j > 0) continue;

				System.out.println("  Inner loop 2: " + j);

				if (i > 5) break;
			}
		}
	}

	public static void splitTests() {
		final String	DELIM = ";;";
		String	test1 = "";
		String	test2 = ";TEST;";
		String	test3 = ";TEST;;TEST2;";
		// Split
		String[]	result1 = test1.split(DELIM);
		String[]	result2 = test2.split(DELIM);
		String[]	result3 = test3.split(DELIM);

		System.out.println(prettyPrintArray(result1));
		System.out.println(prettyPrintArray(result2));
		System.out.println(prettyPrintArray(result3));

		// Regex
		Pattern	p = Pattern.compile(";(.+?);");
		Matcher	m1 = p.matcher(test1);
		Matcher	m2 = p.matcher(test2);
		Matcher	m3 = p.matcher(test3);
		List<String>	matches1 = new ArrayList<>();
		List<String>	matches2 = new ArrayList<>();
		List<String>	matches3 = new ArrayList<>();

		while (m1.find()) matches1.add(m1.group(1));
		while (m2.find()) matches2.add(m2.group(1));
		while (m3.find()) matches3.add(m3.group(1));

		System.out.println(prettyPrintArray(matches1.toArray(new String[matches1.size()])));
		System.out.println(prettyPrintArray(matches2.toArray(new String[matches2.size()])));
		System.out.println(prettyPrintArray(matches3.toArray(new String[matches3.size()])));
	}

	private static String prettyPrintArray(String[] arr) {
		return Arrays.toString(arr);
	}

	public static void centuryCodeDates() {
		SimpleDateFormat	sdf;
		Integer	century = 1;
		Integer	yearSuffix = 15;
		Integer monthDay = 1029;
		Integer	yearPrefix = 19 + century;
		Integer	year = yearPrefix * 100 + yearSuffix;
		Integer	date = year * 10000 + monthDay;
		String	dateFmt = "yyyyMMdd";


		try {
			sdf = new SimpleDateFormat(dateFmt);
			System.out.println(sdf.parse(Integer.toString(date, 10)).toString());
		} catch(ParseException ex) {
			System.err.println("Failed to parse date " + date + ": " + ex.getMessage());
		}
	}

	public static void regex() {
		String	app = null;
		String	qtype, appNumberStr;
		Integer	appNumber;
		Pattern	p = Pattern.compile("([IRSM])(\\d{1,5})");
		Matcher	m = p.matcher(app);

		if (!m.find()) return;

		System.out.println("It matches");

		qtype = m.group(1).trim();
		appNumberStr = m.group(2).trim();
		appNumber = Integer.parseInt(appNumberStr, 10);

		if (appNumber < 1) return;

		System.out.println("--- RESULTS ---");
		System.out.println(qtype);
		System.out.println(appNumber);
	}

	public static void stringSub() {
		Map<String, String>	values = new HashMap<>();
		StrSubstitutor	sub = new StrSubstitutor(values);
		String	test = "Hello, ${name}";
		String	newString;

		values.put("name", "Brian");

		newString = sub.replace(test);

		System.out.println(newString);

		values.put("name", "Sally");

		newString = sub.replace(test);

		System.out.println(newString);
	}
}
