package demo_project;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.Test;

import com.lpu.Calculator;
import com.lpu.Employee;

public class CalculatorTest {

    @Test
    public void addTest() {
        int res = Calculator.add(20, 30);
        assertEquals(50, res);
    }

    @Test
    public void reverseTest() {
        String actualRes = Calculator.reverseString("data");
        assertEquals("atad", actualRes);
    }

//    @Test
//    public void reverseTestNull() {
//        String actualRes = Calculator.reverseString(null);
//        assertEquals(null, actualRes); 
//    }
    @Test
    public void factorialTest() {
        long actualRes = Calculator.factorial(5);
        assertEquals(120, actualRes);
    }
    @Test
    public void palindromeTest() {
    	boolean actualRes=Calculator.isPalindrome("ata");
    	assertEquals(true,actualRes);
    }
    @Test
    public void testValidAge() {
    	Employee e=new Employee(10,"Allen",20,"CSE");
    	assertTrue(e.isValidAge());
    }
    @Test
    public void testValidName() {
        boolean a = Employee.isValidName("ksjkjhdkj");
        assertTrue(a);
    }
   public void testAEEx() {
	   assertThrows(ArithmaticException.class,()->{c.div(10,0);});
   }
}
