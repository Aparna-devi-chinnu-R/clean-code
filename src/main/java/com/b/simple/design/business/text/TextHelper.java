package com.b.simple.design.business.text;

public class TextHelper {

	public String swapLastTwoCharacters(String str) {
		if(str.length() < 2) return str;
		char lastChar = str.charAt(str.length() - 1);
		char secondLastChar = str.charAt(str.length() - 2);

		String remainingString = str.substring(0, str.length() - 2);
		return remainingString + lastChar +secondLastChar;
	}

	public String truncateAInFirst2Positions(String str) {

		return null;
	}
}
