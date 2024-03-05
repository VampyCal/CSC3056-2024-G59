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

	// 2.1.1 calculaterColumnTotal() method Test Cases
	
	@Test // Valid data and valid column number
	public void testValidDataCalculateColumnTotal() {
		assertEquals("Wrong sum returned. It should be 9.0", 9.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d); 
		}
	
	@Test
	public void testNullDataColumnTotal() { 
		try { DataUtilities.calculateColumnTotal(null, 0);
	fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
	}
	catch (Exception e) {
		assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
	} 
	}	
	
	@Test // Valid data and invalid column number
	public void testInvlaidColumnCalculateColumnTotal() {
		try { DataUtilities.calculateColumnTotal(values2D, 3);
	fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
	}
	catch (Exception e) {
		assertTrue("Index out of bound, expected output 0.0", e.getClass().equals(IllegalArgumentException.class));
	} 
		}
	
	@Test // Valid data and invalid column number
	public void testNegativeCalculateColumnTotal() {
		try { DataUtilities.calculateColumnTotal(values2D, -1);
	fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
	}
	catch (Exception e) {
		assertTrue("Index out of bound, expect output 0.0", e.getClass().equals(IllegalArgumentException.class));
	} 
		}
	
	// 2.1.2 calculateRowTotal() method Test Cases
	
	@Test // Valid data and valid row number
	public void testValidDataCalculateRowTotal() {
		assertEquals("Wrong sum returned. It should be 3.0", 3.0, DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d); 
		}
	
	@Test
	public void testNullDataRowTotal() { 
		try { DataUtilities.calculateRowTotal(null, 0);
	fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
	}
	catch (Exception e) {
		assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
	} 
	}	
	
	@Test // Valid data and invalid row number
	public void testInvalidRowCalculateRowTotal() {
		try { DataUtilities.calculateRowTotal(values2D, 3);
	fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
	}
	catch (Exception e) {
		assertTrue("Index out of bound, expected output 0.0", e.getClass().equals(IllegalArgumentException.class));
	} 
		}
	
	@Test // Valid data and invalid row number
	public void testNegativeRowCalculateRowTotal() {
		try { DataUtilities.calculateRowTotal(values2D, -1);
	fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
	}
	catch (Exception e) {
		assertTrue("Index out of bound, expect output 0.0", e.getClass().equals(IllegalArgumentException.class));
	} 
		}
	
	// 2.1.3 createNumberArray() method Test Cases
	
	// test that valid data can be input into method createNumberArray()
	@Test
	public void testCreateValidNumberArray() {
		double[] array1D = new double[]{-3.22, 5.43};
		try { DataUtilities.createNumberArray(array1D);
	fail ("No exception thrown. Valid array data input."); 
	}
	catch (Exception e) {
		assertTrue("Invalid array data", e.getClass().equals(IllegalArgumentException.class));
	} 
	
		}
	// test that invalid null data cannot be input into method createNumberArray() and generates an exception
	@Test
	public void testCreateNullNumberArray() {
		try { DataUtilities.createNumberArray(null);
	fail ("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
	}
	catch (Exception e) {
		assertTrue("Invalid array data", e.getClass().equals(IllegalArgumentException.class));
	} 
	
		}
	
	// test the output for createNumberArray() is a Number[] array object
	@Test
	public void testValidReturnCreateNumberArray() { 
		double[] array1D = new double[]{0.0, 1.3};
		Number[] array1D2 = new Number[]{0.0, 1.3};
		assertArrayEquals("createNumberArray() creates a Number object", array1D2, DataUtilities.createNumberArray(array1D));
	} 
	
	//test the output for createNumberArray is no a double[] array object
	@Test
	public void testInvalidDoubleReturnCreateNumberArray() { 
		double[] array1D = new double[]{0, 3};
		createNumberArray(array1D);
		assertNotEquals("Does not produce Number", double[].class, DataUtilities.createNumberArray(array1D)); 
	} 
	
	// 2.1.4 testCreateNumberArray2D method Test Cases
	
	/*
	// test that valid data can be input into method createNumberArray2D()
	@Test
	public void testCreateValidNumberArray2D() {
		double[][] array2D = new double[][]{};
		try { DataUtilities.createNumberArray2D(array2D);
	fail ("No exception thrown. Valid array data input."); 
	}
	catch (Exception e) {
		assertTrue("Invalid array data", e.getClass().equals(IllegalArgumentException.class));
	} 
	
		} */
	
	// test that invalid null data cannot be input into method createNumberArray2D() and generates an exception
	@Test
	public void testCreateNullNumberArray2D() {
		try { DataUtilities.createNumberArray2D(null);
	fail ("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
	}
	catch (Exception e) {
		assertTrue("Invalid array data", e.getClass().equals(IllegalArgumentException.class));
	} 
	
		}
	/*
	// test the output for createNumberArray2D() is a Number[] array object
	@Test
	public void testValidReturnCreateNumberArray2D() { 
		double[][] array2D = new double[][]{};
		Number[][] array2D2 = new Number[][]{};
		assertArrayEquals("createNumberArray() creates a Number object", array2D2, DataUtilities.createNumberArray2D(array2D));
	} 
	
	//test the output for createNumberArray is no a double[] array object
	@Test
	public void testInvalidDoubleReturnCreateNumberArray2D() { 
		double[][] array2D = new double[][]{};
		createNumberArray2D(array2D);
		assertNotEquals("Does not produce Number", double[][].class, DataUtilities.createNumberArray2D(array2D)); 
	} */
	
	// 2.1.5 testGetCumulativePercentage() method Test Cases
	
	// Tests correct values 
	@Test
	public void testGetCumulativePercentage() {
		KeyedValues testObject = new DefaultKeyedValues(); 
		DefaultKeyedValues keyvalues = new DefaultKeyedValues(); 
		keyvalues.addValue((Comparable) 0.0, 6.0); 
		keyvalues.addValue((Comparable) 1.0, 11.0);
		keyvalues.addValue((Comparable) 2.0, 3.0);
		KeyedValues = testObject = DataUtilities.getCumulativePercentages((KeyedValues) keyvalues);
		assertEquals((double) testObject.getValue(2), 1.0, 0.000000001d);
		
	}
	
	
}
