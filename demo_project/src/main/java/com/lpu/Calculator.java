package com.lpu;

public class Calculator {


	    public static int add(int a, int b) {
	        return (a + b);
	    }

	    public static String reverseString(String data) {
	        String rev = "";

	        for (int i = data.length() - 1; i >= 0; i--) {
	            rev = rev + data.charAt(i);
	        }

	        return rev;
	    }
	    public static long factorial(int n) {
	        if (n < 0) {
	            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
	        }

	        long result = 1;
	        for (int i = 1; i <= n; i++) {
	            result *= i;
	        }
	        return result;
	    }
	    public static boolean isPalindrome(String str) {
	        if (str == null) return false;

	        String reversed = new StringBuilder(str).reverse().toString();
	        return str.equals(reversed);
	    }
	    
}
