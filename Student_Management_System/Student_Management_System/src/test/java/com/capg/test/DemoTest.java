package com.capg.test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DemoTest {

	@BeforeAll
	public static void m1() {
		System.out.println("Before All");
	}
	
	@AfterAll
	public static void m2() {
		System.out.println("After All");
	}
	
	@BeforeEach
	public void m3() {
		System.out.println("Before each test method");
	}
	
	@AfterEach
	public void m4() {
		System.out.println("After each test method");
	}
	
	@Test
	public void demo1() {
		Assertions.assertEquals("xyz", "xyz");
	}
	
	@Test
	public void demo2() {
		Assertions.assertNotNull(99, "test fail message");
	}
	
	@Test
	public void demo3() {
		Assertions.assertThrows(ArithmeticException.class, ()->{ //expecting the exception, it will fail if exception will not be there
			int res=7/0;
		});
	}
	
	@Test
	public void demo4() {
		Assertions.assertDoesNotThrow(()->{ //checking that it is throwing exception or not
			int res=7/7;
		});
	}
	
	@Test
	public void demo5() { //will check the reference, same will pass the test
		String s1="abc"; //abc ke lie ek hi baar string banegi and ek hi location allot hoga
		String s2="abc";
		Assertions.assertSame(s1, s2);
	}
	
	@Test
	public void demo6() {
		int age=19;
		if(age<18) {
			fail("age is less than 18");
		}
	}
	
	@Test
	public void demo7() { //sequence and elements both should be same
		int arr1[]= {1,2,3};
		int arr2[]= {1,2,3,};
		Assertions.assertArrayEquals(arr1, arr2);
	}
	
	@Test
	public void demo8() {
		boolean res=true;
		Assertions.assertTrue(res);
	}
	
	@Test
	public void demo9() {
		boolean res=false;
		Assertions.assertFalse(res);
	}
	
	@ParameterizedTest 
	@CsvSource({"2,3,5", "10,20,30", "-1,1,0"})
	void testAddition(int a, int b, int expected) {
		int res=a+b;
		Assertions.assertEquals(expected, res);
	}
	
	
}
