package tests;

import model.User;
import utils.TestUtils;
public class UserTest {

	public static void main(String[] args) {
		
		UserTest UserConstructor = new UserTest();
		UserTest.testUserConstructor();
		
	}
	
	public static void testUserConstructor() {
		// move all the test code of User Constructor from the main() to this method
		// TODO Auto-generated method stub
		
		//1- Set up test constructor
		String test_username = "mike"; // email address
		String test_password = "mypassword"; // password
		String test_first_name = "Mike"; // first name
		String test_last_name = "Smith"; // last name
		String test_mobile_number = "07771234567" ; // mobile number
		
		//2- Test run the test constructor object
		User testUser = new User(test_username, test_password, test_first_name, test_last_name, test_mobile_number);

		//3- Verify (Assert)
		System.out.println("Starting the assertation of the method constructor testUserConstructor");
		
		// Test Case 1- Test getUsername()
		if (testUser.getUsername() == test_username) 
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getUsername Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getUsername FAILED" + TestUtils.TEXT_COLOR_RESET);
		
		// Test Case 2- Test getPassword()
		if (testUser.getPassword() == test_password) 
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getPassword Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC2-getPassword FAILED" + TestUtils.TEXT_COLOR_RESET);
		
		// Test Case 3- Test getFirst_name()
		if (testUser.getFirst_name() == test_first_name) 
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC3-getFirst_name Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC3-getFirst_name FAILED" + TestUtils.TEXT_COLOR_RESET);
		
		// Test Case 4- Test getLast_name()
		if (testUser.getLast_name() == test_last_name) 
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC4-getLast_name Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC4-getLast_name FAILED" + TestUtils.TEXT_COLOR_RESET);
		
		// Test Case 5- Test getMobile_number()
		if (testUser.getMobile_number() == test_mobile_number) 
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC5-getMobile_number Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC5-getMobile_number FAILED" + TestUtils.TEXT_COLOR_RESET);
		
		// using asserts
		assert testUser.getUsername() == test_username;
		// TODO4 Add all 4 other insertions like the one above. to verify the other 4 field of the class
		assert testUser.getPassword() == test_password;
		assert testUser.getFirst_name() == test_first_name;
		assert testUser.getLast_name() == test_last_name;
		assert testUser.getMobile_number() == test_mobile_number;
		
		System.out.println("All Java assertions in the test suite passed (none failed)");
	}

	
}
