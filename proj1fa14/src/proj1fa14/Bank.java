package proj1fa14;

import java.util.*;
import java.io.*;

/**
 * Title: proj1fa14
 * 
 * Description: Bank class - This class includes a default constructor which uses the Account class and creates 
 * an array of accounts. The computer reads a file to store the values into each of the accounts in the array.
 * This class also contains methods to make a deposit, a withdrawal, and to find out what the accounts balance is. 
 * @author Jason Diaz
 *
 */
public class Bank {

	private Account[] accounts;
	private int numAccounts;

	/**
	 * default constructor --
	 * contains a reference to an account array with the size of 10. The data stored in those accounts is
	 * extracted from a external file.
	 * @throws Exception - used to inform the computer that we understand that the program will crash if this
	 * file is missing.
	 */
	public Bank() throws Exception
	{
		Scanner fileScan = new Scanner(new File("C:\\Users\\jason\\workspace\\proj1fa14\\bankdata.txt"));
		accounts = new Account[10];
		numAccounts = 0;
		Customer customer;
		Account account;
		for(int i = 0; i<9; i++)
		{
			String first = fileScan.next();
			//System.out.println(first);
			String last = fileScan.next();
			//System.out.println(last);
			int age = fileScan.nextInt();
			String pN = fileScan.next();
			int ba = fileScan.nextInt();
			int ch = fileScan.nextInt();
			String accNum = fileScan.next();
			customer = new Customer(first,last,age,pN);
			account = new Account(customer,ba,ch, accNum);
			accounts[i] = account;
			numAccounts++;
		}
		fileScan.close();
	}

	/**
	 * deposit --
	 * method to make a deposit. First it uses a for loop to find the account information to match it with the account
	 * passed through the parameters. After looping through each account it jumps into an if/else statement. If all
	 * the accounts have been checked and the counter is less than the size of the array that means the account has
	 * been found and the deposit can be made. The method will then return true signifying that this transaction has
	 * been processed. If no account was found then false is returned. 
	 * @param customerAcc - this is the customers account number passed as a string.
	 * @param amount - the amount the user will like to withdraw passed as a double.
	 * @return - a boolean which represents if the transaction was processed.
	 */
	public boolean deposit(String customerAcc, int amount)
	{
		int counter = 0;
		for(int i = 0; i<numAccounts; i++)
		{
			if(!accounts[counter].getAccountNum().equals(customerAcc))
				counter++;
			else
				i=numAccounts;
		}
		if(counter < numAccounts)
		{
			accounts[counter].deposit(amount);
			return true;
		}
		else
			return false;
	}

	/**
	 * withdrawal --
	 * method to make a withdrawal. First it uses a for loop to find the account information to match it with the
	 * account passed through the parameters. After looping through each account it jumps into an if/else statement.
	 * If all the accounts have been checked and the counter is less than the size of the array that means the account
	 * has been found also if the amount that the user wants to withdraw is less than or equal to the amount exist. The withdrawal
	 * can be made after these two conditions are met. The method will then return true signifying that this transaction has been
	 * processed. If no account was found then false is returned. 
	 * @param customerAcc - this is the customers account number passed as a string.
	 * @param amount - the amount the user will like to withdraw passed as a double.
	 * @return - a boolean which represents if the transaction was processed.
	 */
	public boolean withdrawal(String customerAcc, double amount)
	{
		int counter = 0;
		int dollars = (int) amount;
		double chan = amount - dollars;
		int change = (int) (chan * 100);
		for(int i = 0; i<numAccounts; i++)
		{
			if(!accounts[counter].getAccountNum().equals(customerAcc))
				counter++;
			else
				i = numAccounts;
		}
		if(counter < numAccounts && accounts[counter].withdrawal(dollars, change) == true)
		{
			accounts[counter].withdrawal(dollars, change);
			return true;
		}
		else
			return false;
	}

	/**
	 * balance --
	 * method to find an accounts balance. A for loop is used to find the account in the array. similar to the deposit and withdraw
	 * methods if the number the loop returns is greater than the amount of accounts than that account doesn't exist.
	 * @param - a string which contains the users account number.
	 * @return - a double if the account was found then it contains the balance. If not then a -1 is returned representing this. 
	 */
	public double balance(String customerAcc)
	{
		int counter = 0;
		for(int i = 0; i<numAccounts; i++)
		{
			if(!accounts[counter].getAccountNum().equals(customerAcc))
				counter++;
			else
				i=numAccounts;
		}
		if(counter < numAccounts)
			return accounts[counter].getBalance();

		else
			return -1;
	}

	/**
	 * toString --
	 * Returns a string representing the current state of the accounts.
	 * @return the status of all accounts.
	 */
	public String toString()
	{
		String str = new String();

		for(int i = 0; i<numAccounts; i++)
			str = str + accounts[i].toString() + "\n";

		return str;
	}
}

