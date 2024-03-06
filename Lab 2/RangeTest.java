package org.jfree.data.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.jfree.data.Range; 
import org.junit.*; 

public class RangeTest {
	
	private Range rangeObjectUnderTest;

	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-1, 1);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * TODO 2.2.1 equals(java.lang.Object obj) method Test Cases
	 */
	
	// TC1 - Invalid (Null) input values
	@Test
	public void testEqualsWithNullValueShouldReturnFalse() {
		assertEquals("Method should return false value", false, rangeObjectUnderTest.equals(null));
	}
	
	// TC2 - Invalid input values - Range with different lower but same upper
	@Test
	public void testEqualsWithDifferentLowerValueShouldReturnFalse() {
		assertEquals("Method should return false value", false, rangeObjectUnderTest.equals(new Range(1, 1)));
	}
	
	// TC3 - Invalid input values - Range with different upper  but same lower
	@Test
	public void testEqualsWithDifferentUpperValueShouldReturnFalse() {
		assertEquals("Method should return false value", false, rangeObjectUnderTest.equals(new Range(-1, 5)));
	}
	
	// TC4 - Valid input values
	@Test
	public void testEqualsWithValidInputValueShouldReturnTrue() {
		assertEquals("Method should return true value", true, rangeObjectUnderTest.equals(new Range(-1, 1)));
	}
	
	// TC5 - Invalid input values - Any object that is not Range
	@Test
	public void testEqualsWithInvalidInputValueOfNotTypeRangeShouldReturnFalse() {
		assertEquals("Method should return false value", false, rangeObjectUnderTest.equals("test Value"));
	}
	
	// TC6 - Invalid input type - Range with lower value as null
	@Test
	public void testEqualsWithNullLowerValueShouldThrowNullPointerException() {
		
		try {
			rangeObjectUnderTest.equals(new Range((Double) null, 1));
			fail("No exception thrown. The expected outcome was: a thrown Exception of type: NullPointerException");
		} catch(Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(NullPointerException.class));
		}
		
	}
	
	// TC7 - Invalid input type - Range with upper value as null
	@Test
	public void testEqualsWithNullUpperValueShouldThrowNullPointerException() {
		
		try {
			rangeObjectUnderTest.equals(new Range(-1, (Double) null));
			fail("No exception thrown. The expected outcome was: a thrown Exception of type: NullPointerException");
		} catch(Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(NullPointerException.class));
		}
	}
	
	/**
	 * TODO 2.2.1 getCentralValue method Test Cases
	 */
	
	// TC1 - Input variables just above the minimum 
	@Test
	public void testGetCentralValuesWithValuesJustAboveTheMinumum() {
		Range rangeObject = new Range(-1.0000001, -1);
		double delta = 0.0001; // Added for floating-point imprecision related issues
		assertEquals("Method should return -1 value", -1, rangeObject.getCentralValue(), delta);
	}
	
	//TC2 - Input variables at the minimum
	@Test
	public void testGetCentralValuesWithValuesAtTheMinimum() {
		Range rangeObject = new Range(-1, -0.5);
		double delta = 0.0001; // Added for floating-point imprecision related issues
		assertEquals("Method should return -0.75 value", -0.75, rangeObject.getCentralValue(), delta);
	}
	
	//TC3 - Input variables at typical value
	@Test
	public void testGetCentralValuesWithTypicalValues() {
		Range rangeObject = new Range(2, 3);
		double delta = 0.0001; // Added for floating-point imprecision related issues
		assertEquals("Method should return 2.5 value", 2.5, rangeObject.getCentralValue(), delta);
	}
	
	//TC4 - Input variables at just below the maximum
	@Test
	public void testGetCentralValuesWithValuesJustBelowTheMaximum() {
		Range rangeObject = new Range(6, 12.5);
		double delta = 0.0001; // Added for floating-point imprecision related issues
		assertEquals("Method should return 9.25 value", 9.25, rangeObject.getCentralValue(), delta);
	}

	//TC5 - Input variables at the maximum
	@Test
	public void testGetCentralValuesWithValuesAtTheMaximum() {
		Range rangeObject = new Range(12.5, 13);
		double delta = 0.0001; // Added for floating-point imprecision related issues
		assertEquals("Method should return 12.75 value", 12.75, rangeObject.getCentralValue(), delta);
	}
	
	/**
	 * TODO 2.2.3 constrain(Double value) method Test Cases
	 */
	
	// TC1 - Input variables just above the minimum 
	@Test
	public void testConstrainWithValuesJustAboveTheMinumum() {
		Range rangeObject = new Range(2, 13);
		double delta = 0.0001; // Added for floating-point imprecision related issues
		assertEquals("Method should return 2.0 value", 2.0, rangeObject.constrain(2.0), delta);
	}
	
	// TC2 - Input variables the minimum 
	@Test
	public void testConstrainWithValuesAtTheMinumum() {
		Range rangeObject = new Range(2, 13);
		double delta = 0.0001; // Added for floating-point imprecision related issues
		assertEquals("Method should return 2.1 value", 2.1, rangeObject.constrain(2.1), delta);
	}
	
	// TC3 - Input variables At Typical Value
	@Test
	public void testConstrainWithValuesAtTypcialValue() {
		Range rangeObject = new Range(2, 13);
		double delta = 0.0001; // Added for floating-point imprecision related issues
		assertEquals("Method should return 5.0 value", 5.0, rangeObject.constrain(5.0), delta);
	}
	
	// TC4 - Input variables just below the maximum 
	@Test
	public void testConstrainWithValuesJustBelowTheMaximum() {
		Range rangeObject = new Range(2, 13);
		double delta = 0.0001; // Added for floating-point imprecision related issues
		assertEquals("Method should return 12.9 value", 12.9, rangeObject.constrain(12.9), delta);
	}
	
	// TC4 - Input variables at the maximum 
	@Test
	public void testConstrainWithValuesAtTheMaximum() {
		Range rangeObject = new Range(2, 13);
		double delta = 0.0001; // Added for floating-point imprecision related issues
		assertEquals("Method should return 13.0 value", 13.0, rangeObject.constrain(13.0), delta);
	}
	
	/**
	 * TODO 2.2.4 toString() method Test Cases
	 */
	
	// TC1 - Input variables just above the minimum
	@Test
	public void testToStringWithValuesJustAboveTheMinimum() {
		Range rangeObject = new Range(Double.MIN_VALUE + 0.1, 1);
		assertEquals("Wrong Range Value Returned - Should be 'Range[0.55,1.0]'", "Range[0.55,1.0]", rangeObject.toString());
	}
	
	// TC2 - Input variables just at the minimum
	@Test
	public void testToStringWithValuesAtTheMinimum() {
		Range rangeObject = new Range(Double.MIN_VALUE, 1);
		assertEquals("Wrong Range Value Returned - Should be 'Range[0.5,1.0]'", "Range[0.5,1.0]", rangeObject.toString());
	}
	
	// TC3 - Input variables at typical value
	@Test
	public void testToStringWithValuesAtTypicalValue() {
		Range rangeObject1 = new Range(2,5);
		assertEquals("Wrong Range Value Returned - Should be 'Range[2,5]'", "Range[2,5]", rangeObject1.toString());
	}
	
	// TC4 - Input variables just below the maximum
	@Test
	public void testToStringWithValuesJustBelowTheMaximum() {
		Range rangeObject = new Range(2.0 , Double.MAX_VALUE-0.1);
		assertEquals("Wrong Range Value Returned - Should be 'Range[8.988465674311579E307,1.7976931348623157E308]'", 
				"Range[8.988465674311579E307,1.7976931348623157E308]", rangeObject.toString());
	}
	
	// TC5 - Input variables just at the maximum
	@Test
	public void testToStringWithValuesJustAtTheMaximum() {
		Range rangeObject = new Range(2.0 , Double.MAX_VALUE);
		assertEquals("Wrong Range Value Returned - Should be 'Range[8.988465674311579E307,1.7976931348623157E308]'", 
				"Range[8.988465674311579E307,1.7976931348623157E308]", rangeObject.toString());
	}
	
	/**
	 * TODO 2.2.5 getUpperBound()method Test Cases
	 */
	
	// TC1 - Input variables just above the minimum 
	@Test
	public void testGetUpperBoundWithValuesJustAboveTheMinimum() {
		Range rangeObject = new Range(-2, Double.MIN_VALUE + 0.1);
		double delta = 0.0001; // Added for floating-point imprecision related issues
		assertEquals("Wrong Upper Bound Value Returned - Should be", 0.1, rangeObject.getUpperBound(), delta);
	}
	
	// TC2 - Input variables just at the minimum 
	@Test
	public void testGetUpperBoundWithValuesJustAtTheMinimum() {
		Range rangeObject = new Range(-2, Double.MIN_VALUE);
		double delta = 0.0001; // Added for floating-point imprecision related issues
		assertEquals("Wrong Upper Bound Value Returned", Double.MIN_VALUE, rangeObject.getUpperBound(), delta);
	}
	
	// TC3 - Input variables at typical value 
	@Test
	public void testGetUpperBoundWithValuesAtTypicalValue() {
		Range rangeObject = new Range(2, 5);
		double delta = 0.0001; // Added for floating-point imprecision related issues
		assertEquals("Wrong Upper Bound Value Returned", 5, rangeObject.getUpperBound(), delta);
	}
	
	// TC4 - Input variables just below the maximum
	@Test
	public void testGetUpperBoundWithValuesJustBelowTheMaximum() {
		Range rangeObject = new Range(1, Double.MAX_VALUE-0.1);
		double delta = 0.0001; // Added for floating-point imprecision related issues
		assertEquals("Wrong Upper Bound Value Returned", 1.7976931348623157E308, rangeObject.getUpperBound(), delta);
	}
	
	// TC5 - Input variables at the maximum
	@Test
	public void testGetUpperBoundWithValuesJustAtTheMaximum() {
		Range rangeObject = new Range(1, Double.MAX_VALUE);
		double delta = 0.0001; // Added for floating-point imprecision related issues
		assertEquals("Wrong Upper Bound Value Returned", 1.7976931348623157E308, rangeObject.getUpperBound(), delta);
	}
	
	

}
