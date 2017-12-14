package com.mrc.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.text.StrSubstitutor;

/**
 * Used for generic testing
 * @author Duffey
 */
public class Test {

	public static void main(String[] args) {
		regex();
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
	}
}