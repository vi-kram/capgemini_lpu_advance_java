package com.connectDataBase;

public class Program {
	public static boolean isPalindrome(String str) {

	    StringBuilder s = new StringBuilder(str);

	    return (s.reverse().toString().equals(str)) ? true : false;
	}

	public static void main(String[] args) {
	    System.out.println(isPalindrome("abab"));
	}

	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}
}
