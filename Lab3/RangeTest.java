package org.jfree.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
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
	 * TODO 3 - Adding test cases for increasing code coverage
	 */
	
	// TC1 - Testing creating a Range function where lower bound is higher than upper bound
	@Test
	public void testRangeWithLowerValueLargerThanUpperValue() {
		try {
			new Range(5, 2);
			fail("No exception thrown. The expected outcome was: a thrown Exception of type: IllegalArgumentException");
		} catch(Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}
		
	}
	
	// TC - contains(double value) method
	// TC1 - Testing contain() method with value less than lower bound of Range object
	@Test
	public void testContainsWithValueLessThanLowerBound() {
	    assertFalse("Method should return false for value less than lower bound", rangeObjectUnderTest.contains(-2));
	}

	// TC2 - Testing contain() method with value greater than upper bound of Range object
	@Test
	public void testContainsWithValueGreaterThanUpperBound() {
	    assertFalse("Method should return false for value greater than upper bound", rangeObjectUnderTest.contains(2));
	}
	
	
	// TC - intersects(double lower, double upper) method
	
	// TC1 - Testing intersects() method with lower <= lower value of range object, upper > lower value of range object,
	@Test
	public void testIntersectsWithLowerLessThanOrEqualToThisLowerAndUpperGreaterThanThisLower() {
	    assertTrue("Method should return true for intersecting ranges", rangeObjectUnderTest.intersects(-2, 0));
	}

	// TC2 - Testing intersects() method with lower <= this.lower, upper <= upper value of range object, and upper >= lower
	@Test
	public void testIntersectsWithLowerLessThanOrEqualToThisLowerAndUpperLessThanOrEqualToThisUpperAndUpperGreaterThanOrEqualToLower() {
	    assertTrue("Method should return true for intersecting ranges", rangeObjectUnderTest.intersects(-2, 0.5));
	}

	// TC3 - Testing intersects() method with lower > this.lower, upper < upper value of range object,and upper >= lower
	@Test
	public void testIntersectsWithLowerGreaterThanThisLowerAndUpperLessThanThisUpperAndUpperGreaterThanOrEqualToLower() {
	    assertTrue("Method should return true for intersecting ranges", rangeObjectUnderTest.intersects(-0.5, 0.5));
	}

	// TC4 - Testing intersects() method with lower > lower value of range object,, upper >= lower value of range object,
	@Test
	public void testIntersectsWithLowerGreaterThanThisLowerAndUpperGreaterThanOrEqualToThisLower() {
	    assertTrue("Method should return true for intersecting ranges", rangeObjectUnderTest.intersects(0, 1));
	}

	// TC5 - Testing intersects() method with lower > upper value of range object
	@Test
	public void testIntersectsWithLowerGreaterThanThisUpper() {
	    assertFalse("Method should return false for non-intersecting ranges", rangeObjectUnderTest.intersects(1.5, 2));
	}

	
	// TC - constrain(double value) method
	
	// TC1 - Value greater than upper bound
	@Test
	public void testConstrainWithValueGreaterThanUpperBound() {
	    double constrainedValue = rangeObjectUnderTest.constrain(2.5);
	    double delta = 0.0001; // Added for floating-point imprecision related issues
	    assertEquals("Method should return upper bound when value is greater than upper bound", 1.0, constrainedValue, delta);
	}

	// TC2 - Value less than lower bound
	@Test
	public void testConstrainWithValueLessThanLowerBound() {
	    double constrainedValue = rangeObjectUnderTest.constrain(-2.0);
	    double delta = 0.0001; // Added for floating-point imprecision related issues
	    assertEquals("Method should return lower bound when value is less than lower bound", -1.0, constrainedValue, delta);
	}

	
	// TC - expandToInclude(Range range, double value) method
	
	// TC1 - range is null
	@Test
	public void testExpandToIncludeWithNullRange() {
	    Range result = Range.expandToInclude(null, 2);
	    assertEquals("Method should return new Range with value as both lower and upper bound when range is null", new Range(2, 2), result);
	}

	// TC2 - value < range lower bound
	@Test
	public void testExpandToIncludeWithValueLessThanLowerBound() {
	    Range range = new Range(0, 2);
	    Range result = Range.expandToInclude(range, -1);
	    assertEquals("Method should return new Range with value as lower bound when value is less than lower bound of range", new Range(-1, 2), result);
	}

	// TC3 - value > range upper bound
	@Test
	public void testExpandToIncludeWithValueGreaterThanUpperBound() {
	    Range range = new Range(0, 2);
	    Range result = Range.expandToInclude(range, 3);
	    assertEquals("Method should return new Range with value as upper bound when value is greater than upper bound of range", new Range(0, 3), result);
	}

	// TC4 - value within range bounds
	@Test
	public void testExpandToIncludeWithValueWithinBounds() {
	    Range range = new Range(0, 2);
	    Range result = Range.expandToInclude(range, 1);
	    assertSame("Method should return the same range when value is within the range bounds", range, result);
	}

	
	// TC - getLength() method
	// TC1 - Valid range
	@Test
	public void testGetLengthWithValidRange() {
	    double expectedLength = 2.0; // Assuming upper = 1 and lower = -1
	    double actualLength = rangeObjectUnderTest.getLength();
	    double delta = 0.0001; // Added for floating-point imprecision related issues
	    assertEquals("Method should return the correct length of the range", expectedLength, actualLength, delta);
	}
	
	
	// TC - combine(Range range1, Range range2) method
	// TC1 - Both ranges are not null
	@Test
	public void testCombineWithBothRangesNotNull() {
	    Range range1 = new Range(1, 3);
	    Range range2 = new Range(2, 4);
	    Range result = Range.combine(range1, range2);
	    assertEquals("Method should return a new Range that covers both input ranges", new Range(1, 4), result);
	}
	
	
	// TC2 - Testing combine() method where range1 is null, range2 is not null
	@Test
	public void testCombineWithRange1Null() {
	    Range result = Range.combine(null, new Range(2, 3));
	    assertEquals("Method should return range2 when range1 is null", new Range(2, 3), result);
	}

	// TC3 - Testing combine() method where range2 is null, range1 is not null
	@Test
	public void testCombineWithRange2Null() {
	    Range result = Range.combine(new Range(-1, 1), null);
	    assertEquals("Method should return range1 when range2 is null", new Range(-1, 1), result);
	}

	// TC4 - Testing combine() method where both range1 and range2 are null
	@Test
	public void testCombineWithBothRangesNull() {
	    Range result = Range.combine(null, null);
	    assertNull("Method should return null when both ranges are null", result);
	}
	
	
	// TC - Expand(Range range, double lowerMargin, double upperMargin) method
	// TC1 - Valid range with lower and upper margins
	@Test
	public void testExpandWithValidRangeAndMargins() {
	    Range range = new Range(1, 3); // Assuming range bounds
	    double lowerMargin = 0.1;
	    double upperMargin = 0.2;
	    
	    double expectedLowerBound = 0.8; // Assuming lower bound after expansion
	    double expectedUpperBound = 3.4; // Assuming upper bound after expansion

	    Range expandedRange = Range.expand(range, lowerMargin, upperMargin);
	    double delta = 0.0001; // Added for floating-point imprecision related issues
	    
	    assertEquals("Method should return a new Range with expanded bounds", expectedLowerBound, expandedRange.getLowerBound(), delta);
	    assertEquals("Method should return a new Range with expanded bounds", expectedUpperBound, expandedRange.getUpperBound(), delta);
	}
	
	// TC2 - Range is null
	@Test
	public void testExpandWithNullRange() {
		try {
			Range.expand(null, 0.1, 0.2);
			fail("No exception thrown. The expected outcome was: a thrown Exception of type: IllegalArgumentException");
		} catch(Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}
		
	}
	
	// TC - Shift(Range base, double delta) function
	// TC1 - Valid range and delta
	@Test
	public void testShiftWithValidRangeAndDelta() {
	    Range base = new Range(1, 3); // Assuming range bounds
	    double delta = 0.0001; // Added for floating-point imprecision related issues
	    
	    double expectedLowerBound = 2.5; // Assuming lower bound after shifting
	    double expectedUpperBound = 4.5; // Assuming upper bound after shifting

	    Range shiftedRange = Range.shift(base, delta);
	    
	    assertEquals("Method should return a new Range with shifted bounds", expectedLowerBound, shiftedRange.getLowerBound(), delta);
	    assertEquals("Method should return a new Range with shifted bounds", expectedUpperBound, shiftedRange.getUpperBound(), delta);
	}

	
	// TC2 - allowZeroCrossing is true
	@Test
	public void testShiftWithAllowZeroCrossingTrue() {
	    Range base = new Range(1, 3); // Assuming range bounds
	    double delta = 0.0001; // Added for floating-point imprecision related issues
	    boolean allowZeroCrossing = true;
	    
	    double expectedLowerBound = 2.5; // Assuming lower bound after shifting
	    double expectedUpperBound = 4.5; // Assuming upper bound after shifting

	    Range shiftedRange = Range.shift(base, delta, allowZeroCrossing);
	    
	    assertEquals("Method should return a new Range with shifted bounds when allowZeroCrossing is true", expectedLowerBound, shiftedRange.getLowerBound(), delta);
	    assertEquals("Method should return a new Range with shifted bounds when allowZeroCrossing is true", expectedUpperBound, shiftedRange.getUpperBound(), delta);
	}
	
	// TC - hashcode() function
	
	// TC1 - Test hash code generation
	@Test
	public void testHashCode() {
	    Range range = new Range(1.5, 3.5); // Assuming range bounds
	    
	    // Expected hash code value calculated manually
	    int expectedHashCode = 31 * Double.hashCode(1.5) + Double.hashCode(3.5);
	    
	    int actualHashCode = range.hashCode();
	    
	    assertEquals("Hash code should be generated correctly", expectedHashCode, actualHashCode);
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
