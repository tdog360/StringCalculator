package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }
	
	@Test
    public void testBunchOfNumbers(){
    	assertEquals(64, Calculator.add("15,15,10,20,1,3"));
    }
	
	@Test
	public void testNewLine() throws Exception {
		assertEquals(5, Calculator.add("3\n2"));
	}
	
	@Test
	public void testNewLineWithComma() throws Exception {
		assertEquals(6, Calculator.add("3\n2,1"));
	}
	
	@Test
	public void testOneNegativeNumber() throws Exception {
		try {
			assertEquals(5, Calculator.add("-3,4,2\n2"));
		}
		catch (Exception e) {
			String message = "Negatives not allowed: -3";
			assertEquals(message, e.getMessage());
		}
	}
	
	@Test
	public void testNegativeNumbers() throws Exception {
		try {
			assertEquals(-3, Calculator.add("-3,-4,2\n2"));
		}
		catch (Exception e) {
			String message = "Negatives not allowed: -3,-4";
			assertEquals(message, e.getMessage());
		}
	}
	
	@Test
	public void testMoreNegativeNumbers() throws Exception {
		try {
			assertEquals(-4, Calculator.add("2,-4,3,-5"));
		}
		catch (Exception e) {
			String message = "Negatives not allowed: -4,-5";
			assertEquals(message, e.getMessage());
		}
	}
	
	@Test
	public void TestBiggerThan1000() throws Exception {
		assertEquals(42, Calculator.add("4\n36,2,1001"));
	}

}