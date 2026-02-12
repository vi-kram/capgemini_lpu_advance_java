package Com.practice;

import com.practice.Calculator;

public class CalculatorTest {
	public void dividetest() {
		Calculator c=new Calculator();
		int actualRes=c.divide(10, 2);
		assertEquals(5, actualRes);
	}
}
