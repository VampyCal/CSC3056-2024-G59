package tests;

import model.Account;

import java.util.Date;

public class AccountTest {
    /**
     * Similar to testUserConstructor() of UserTest, this test method will
     * test the constructor of Account, using all its getter methods
     */

    public static void testConstructor() {

        //1- Set up test constructor
        String account_number = "123456"; // account number
        String username_of_account_holder = "test123@gmail.com"; // username
        String account_type = "testingAccount"; // account type
        Date account_opening_date = new Date(2000, 12, 21); // account opening date

        //2- Test run the test constructor object
        Account testAccount = new Account(account_number, username_of_account_holder, account_type, account_opening_date);

        //3- Verify (Assert)
        System.out.println("Starting the assertation of the method constructor testConstructor");

        // using asserts
        assert testAccount.getAccount_number().equals(account_number);
        assert testAccount.getUsername_of_account_holder().equals(username_of_account_holder);
        assert testAccount.getAccount_type().equals(account_type);
        assert testAccount.getAccount_opening_date().equals(account_opening_date);

        System.out.println("All Java assertions in the test suite passed (none failed)");
    }

    /**
     * this test method will test all the setter methods of ACcount
     */
    public static void testSetters() {

		//1- Set up test constructor
		String account_number = "123456"; // account number
		String username_of_account_holder = "test123@gmail.com"; // username
		String account_type = "testingAccount"; // account type
		Date account_opening_date = new Date(2000, 12, 21); // account opening date

		//2- Test run the test constructor object
		Account testAccount = new Account(account_number, username_of_account_holder, account_type, account_opening_date);

		//3 - Test Setter Methods by first setting the new values for fields
		String new_account_number = "1234567"; // account number
		String new_username_of_account_holder = "test1234@gmail.com"; // username
		String new_account_type = "testingAccountNew"; // account type
		Date new_account_opening_date = new Date(2000, 12, 22); // account opening date

		//4 - Set new values by Setter Methods
		testAccount.setAccount_number(new_account_number);
		testAccount.setUsername_of_account_holder(new_username_of_account_holder);
		testAccount.setAccount_type(new_account_type);
		testAccount.setAccount_opening_date(new_account_opening_date);

		// Verify (Assert)
		System.out.println("Starting the assertation of the Setters using testSetters method");

		// using asserts
		assert testAccount.getAccount_number().equals(new_account_number);
		assert testAccount.getUsername_of_account_holder().equals(new_username_of_account_holder);
		assert testAccount.getAccount_type().equals(new_account_type);
		assert testAccount.getAccount_opening_date().equals(new_account_opening_date);

		System.out.println("All Java assertions in the test suite passed (none failed)");
	}

    public static void main(String[] args) {
        testConstructor();
        testSetters();
    }

}
