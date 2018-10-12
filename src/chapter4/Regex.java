package chapter4;

import java.util.regex.Pattern;

public class Regex {
	
	public static void main (String[] args) {
		System.out.println(Pattern.matches("[amn]", "abcd"));//false (not a or m or n)
		System.out.println(Pattern.matches("^[\\s]*$", ""));//true (among a or m or n)
		System.out.println(Pattern.matches("[amn]+", ""));//false (m and a comes more than once)
		System.out.println(Pattern.matches("^[+0-9]{2,3}-[6789]{1}[0-9]{2}-[0-9]{3}-[0-9]{4}$", "+91-995-303-8949"));//true
	}
}
