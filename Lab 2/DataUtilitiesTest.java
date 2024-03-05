package org.jfree.data.test;

import static org.junit.Assert.*;


import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.Values2D;
import org.jfree.data.DataUtilities;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

public class DataUtilitiesTest extends DataUtilities {
	private Values2D values2D;

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
	
	// 2.1.3 createNewArray() method Test Cases
	
	@Test
	public void testCreateValidNumberArray() {
		double[] array1D = new double[]{-3.22, 5.43};
		try { DataUtilities.createNumberArray(array1D);
	fail ("No exception thrown. Valid array data input."); 
	}
	catch (Exception e) {
		assertTrue("Invalid array data", e.getClass().equals(IllegalArgumentException.class));
	} 
	@Test
	public void testCreateNullNumberArray() {
		try { DataUtilities.createNumberArray(null);
	fail ("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException"); 
	}
	catch (Exception e) {
		assertTrue("Invalid array data", e.getClass().equals(IllegalArgumentException.class));
	} 
	
		}
	@Test
	public void testValidReturnCreateNumberArray() { 
		double[] array1D = new double[]{0.0, 1.3};
		createNumberArray(array1D);
		assertEquals("Does not produce Number", java.lang.Number[].class, DataUtilities.createNumberArray(array1D)); 
	} 
	
	@Test
	public void testInvalidDoubleReturnCreateNumberArray() { 
		double[] array1D = new double[]{0, 3};
		createNumberArray(array1D);
		assertNotEquals("Does not produce Number", double[].class, DataUtilities.createNumberArray(array1D)); 
	} 
	
}
