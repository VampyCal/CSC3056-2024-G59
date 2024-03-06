package org.jfree.data.test;

import static org.junit.Assert.*;


import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.Values2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.DataUtilities;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {
	private Values2D values2D;
	private KeyedValues KeyedValues;
	@Before
	public void setUp() throws Exception {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
		values2D = testValues;
		//row 1
		testValues.addValue(1, 0, 0);
		testValues.addValue(2, 0, 1);
		testValues.addValue(0, 0, 2);
		//row 2
		testValues.addValue(3, 1, 0);
		testValues.addValue(4, 1, 1);
		testValues.addValue(0, 1, 2);
		//row3
		testValues.addValue(5, 2, 0);
		testValues.addValue(6, 2, 1);
		testValues.addValue(0, 0, 2);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	//
	// TODO 2.1.1 calculaterColumnTotal() method Test Cases
	//
	
	
	// TC1 Valid data and valid column index
	@Test 
	public void testValidDataCalculateColumnTotal() {
		assertEquals("Wrong sum returned. It should be 9.0", 9.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d); 
		}
	
	// TC2 Invalid null data and valid column index
	@Test
	public void testNullDataColumnTotal() { 
		try { DataUtilities.calculateColumnTotal(null, 0);
	fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
	}
	catch (Exception e) {
		assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
	} 
	}	
	
	// TC3 Valid data and invalid column index
	@Test 
	public void testInvlaidColumnCalculateColumnTotal() {
		try { DataUtilities.calculateColumnTotal(values2D, 3);
	fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
	}
	catch (Exception e) {
		assertTrue("Index out of bound, expected output 0.0", e.getClass().equals(IllegalArgumentException.class));
	} 
		}
	
	// TC4 Valid data and invalid column index
	@Test 
	public void testNegativeCalculateColumnTotal() {
		try { DataUtilities.calculateColumnTotal(values2D, -1);
	fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
	}
	catch (Exception e) {
		assertTrue("Index out of bound, expect output 0.0", e.getClass().equals(IllegalArgumentException.class));
	} 
		}
	
	// TC5 Valid data and invalid column index
	@Test 
	public void testAlphaCalculateColumnTotal() {
		try { DataUtilities.calculateColumnTotal(values2D, 'a');
	fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
	}
	catch (Exception e) {
		assertTrue("Index out of bound, expect output 0.0", e.getClass().equals(IllegalArgumentException.class));
	} 
		}
	
	
	//
	// TODO 2.1.2 calculateRowTotal() method Test Cases
	//
	
	
	// TC1 Valid data and valid row index
	@Test 
	public void testValidDataCalculateRowTotal() {
		assertEquals("Wrong sum returned. It should be 3.0", 3.0, DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d); 
		}
	
	// TC2 Invalid null data and valid row index
	@Test
	public void testNullDataRowTotal() { 
		try { DataUtilities.calculateRowTotal(null, 0);
	fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
	}
	catch (Exception e) {
		assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
	} 
	}	
	
	// TC3 Valid data and invalid row index
	@Test 
	public void testInvalidRowCalculateRowTotal() {
		try { DataUtilities.calculateRowTotal(values2D, 3);
	fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
	}
	catch (Exception e) {
		assertTrue("Index out of bound, expected output 0.0", e.getClass().equals(IllegalArgumentException.class));
	} 
		}
	
	// TC4 Valid data and invalid row index
	@Test 
	public void testNegativeRowCalculateRowTotal() {
		try { DataUtilities.calculateRowTotal(values2D, -1);
	fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
	}
	catch (Exception e) {
		assertTrue("Index out of bound, expect output 0.0", e.getClass().equals(IllegalArgumentException.class));
	} 
		}
	
	// TC5 Valid data and invalid row index
	@Test 
	public void testAlphaCalculateRowTotal() {
		try { DataUtilities.calculateRowTotal(values2D, 'a');
	fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
	}
	catch (Exception e) {
		assertTrue("Index out of bound, expect output 0.0", e.getClass().equals(IllegalArgumentException.class));
	} 
		}
	
	
	//
	// TODO 2.1.3 createNumberArray() method Test Cases
	//
	
	
	// TC1 test that valid data can be input into method createNumberArray()
	@Test
	public void testCreateValidNumberArray() {
		double[] array1D = new double[]{3.33, 5.43};
		try { DataUtilities.createNumberArray(array1D);
	fail ("No exception thrown. Valid array data input."); 
	}
	catch (Exception e) {
		assertTrue("Invalid array data", e.getClass().equals(IllegalArgumentException.class));
	} 
	
		}
	
	// TC2 test that invalid null data cannot be input into method createNumberArray() and generates an exception
	@Test
	public void testCreateNullNumberArray() {
		try { DataUtilities.createNumberArray(null);
	fail ("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
	}
	catch (Exception e) {
		assertTrue("Invalid array data", e.getClass().equals(IllegalArgumentException.class));
	} 
	}
	
	// TC3 test that invalid char data cannot be input into method createNumberArray() and generates an exception	
	@Test
	public void testCreateAlphaNumberArray() {
	double[] array1D = new double[]{'b', 'c'};
		try { DataUtilities.createNumberArray(array1D);
	fail ("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
		}
	catch (Exception e) {
			assertTrue("Invalid array data", e.getClass().equals(IllegalArgumentException.class));
	} 
	
		}
	
	// TC4 test the output for createNumberArray() is a Number[] array object
	@Test
	public void testValidReturnCreateNumberArray() { 
		double[] array1D = new double[]{0.0, 1.3};
		Number[] array1D2 = new Number[]{0.0, 1.3};
		assertArrayEquals("createNumberArray() creates a Number object", array1D2, DataUtilities.createNumberArray(array1D));
	} 
	
	
	
	//
	// TODO 2.1.4 createNumberArray2D() method Test Cases
	//
	
	
	// TC1 test that valid data can be input into method createNumberArray2D()
	@Test
	public void testCreateValidNumberArray2D() {
		double[][] array2D = { {1.0, 6.0}, {9.0, 9.0} };
        createNumberArray2D(array2D);
        assertArrayEquals("createNumberArray2D() creates a Number object", array2D, DataUtilities.createNumberArray2D(array2D));
		} 
	
	// TC2 test that the return data form createNumberArray2D() method is a 2D Number Array
	@Test
	public void testCreateValidNumberArray2D2() {
        double[][] array2D = { {1.0,6.0}, {9.0, 9.0} };
        Number[][] array2D2 = { {1.0,6.0}, {9.0, 9.0} };
        createNumberArray2D(array2D);
        assertArrayEquals("createNumberArray2D() creates a Number object", array2D2 ,DataUtilities.createNumberArray2D(array2D));
		} 
	
	// TC3 test that invalid null data cannot be input into method createNumberArray2D() and generates an exception
	@Test
	public void testCreateNullNumberArray2D() {
		try { DataUtilities.createNumberArray2D(null);
	fail ("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
	}
	catch (Exception e) {
		assertTrue("Invalid array data", e.getClass().equals(IllegalArgumentException.class));
	} 
	
		}
	
	// TC4 test that invalid char data cannot be input into method createNumberArray2D() and generates an exception
	@Test
	public void testInvalidCreateNumberArray2D() { 
        double[][] array2D = { {'a', 'r' }, {'2', '3'} };
 
		try { DataUtilities.createNumberArray2D(array2D);
	fail ("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
	}
	catch (Exception e) {
		assertTrue("Invalid array data", e.getClass().equals(IllegalArgumentException.class));
	} 
	} 

	
	
	//
	// TODO 2.1.5 getCumulativePercentage() method Test Cases
	//
	
	
	// TC1 Test the return output from getCumulativePercentage() method is correct
	@Test
	public void testGetCumulativePercentage() {
		KeyedValues testObject = new DefaultKeyedValues(); 
		DefaultKeyedValues keyvalues = new DefaultKeyedValues(); 
		keyvalues.addValue((Comparable) 0.0, 2.0); 
		keyvalues.addValue((Comparable) 1.0, 4.0);
		keyvalues.addValue((Comparable) 2.0, 6.0);
		KeyedValues = testObject = DataUtilities.getCumulativePercentages((KeyedValues) keyvalues);
		assertEquals((double) testObject.getValue(1), 0.5, 0.000000001d);
		
	}
	
	// TC2 Test invalid negative input cannot be input into the getCumulativePercentage() method
	@Test
	public void testNegativeValuesGetCumulativePercentage() {
		KeyedValues testObject = new DefaultKeyedValues(); 
		DefaultKeyedValues keyvalues = new DefaultKeyedValues(); 
		keyvalues.addValue((Comparable) 0.0,  9.0); 
		keyvalues.addValue((Comparable) 1.0, -5.0);
		keyvalues.addValue((Comparable) 2.0, -4.0);
		KeyedValues = testObject = DataUtilities.getCumulativePercentages((KeyedValues) keyvalues);
		assertEquals((double) testObject.getValue(2), 0.0, 0.000000001d);
		
	}	
	
	// TC3 Test invalid null input cannot be input into the getCumulativePercentage() method
	@Test
	public void testNullGetCumulativePercentage() {
		KeyedValues testObject = new DefaultKeyedValues(); 
		DefaultKeyedValues keyvalues = new DefaultKeyedValues(); 
		keyvalues.addValue((Comparable) 0.0, null); 
		keyvalues.addValue((Comparable) 1.0, null);
		keyvalues.addValue((Comparable) 2.0, null);
		KeyedValues = testObject = DataUtilities.getCumulativePercentages((KeyedValues) keyvalues);
		assertEquals((double) testObject.getValue(0), 0.0, 0.000000001d);
		
	}	
	
	// TC4 Test null exception correctly works in the getCumulativePercentage() method
	@Test
	public void testNullExceptionGetCumulativePercentage() {
		try { DataUtilities.getCumulativePercentages((KeyedValues) null);
	fail ("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
	}
	catch (Exception e) {
		assertTrue("Invalid array data", e.getClass().equals(IllegalArgumentException.class));
	} 
	}
	
	// TC5 Test invalid alphabet input into the getCumulativePercentage() method
	@Test
	public void testAlphaGetCumulativePercentage() {
		KeyedValues testObject = new DefaultKeyedValues(); 
		DefaultKeyedValues keyvalues = new DefaultKeyedValues(); 
		keyvalues.addValue((Comparable) 0.0, 'a'); 
		keyvalues.addValue((Comparable) 1.0, '&');
		keyvalues.addValue((Comparable) 2.0, 'c');
		try { KeyedValues = testObject = DataUtilities.getCumulativePercentages((KeyedValues) keyvalues);
	fail ("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
	}
	catch (Exception e) {
		assertTrue("Invalid array data", e.getClass().equals(IllegalArgumentException.class));
	}	
	}	
}
	
	
}
