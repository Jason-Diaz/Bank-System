package proj1fa14;
/**
 * Title: proj1fa14
 * 
 * Description: The Account class. This class stores a customer reference, a balance, and an account number in an
 * account object it also has assessor and mutator methods for each of he instance variables and includes a tostring.
 * @author Jason Diaz
 *
 */
public class Account {
	private Customer ref;
	private int balance;
	private int change;
	private String accountNum;

	/**
	 * parameterized constructor --
	 * creates an Account object. An account contains a customer refrence, a balance, and an account number.
	 * @param cust - customer reference
	 * @param bal - balance
	 * @param acc - account number
	 */
	public Account(Customer cust, int bal, int cha, String acc)
	{
		ref = cust;
		balance = bal;
		change = cha;
		accountNum = acc;
	}

	/**
	 * getCustomer --
	 * allows the programmer access the customer object.
	 * @return a reference to a customer object.
	 */
	public Customer getCustomer()
	{
		return ref;
	}

	/**
	 * getBalance --
	 * allows the programmer to access the balance of the account.
	 * @return a double representing the balance.
	 */
	public double getBalance()
	{
		return balance;
	}

	/**
	 * getAccountNum --
	 * allows the programmer to access the account number.
	 * @return a string containing the account number.
	 */
	public String getAccountNum()
	{
		return accountNum;
	}

	/**
	 * setCustomer --
	 * allows customer to set to a new customer.
	 * @param fer - a reference to a customer object.
	 */
	public void setCustomer(Customer fer)
	{
		ref = fer;
	}

	/**
	 * setBalance --
	 * allows the balance to be changed.
	 * @param bal - the new balance.
	 */
	public void setBalance(int bal)
	{
		balance = bal;
	}

	/**
	 * setAccountNum --
	 * allows the variable for account number to be changed.
	 * @param accNum - the new account number. 
	 */
	public void setAccountNum(String accNum)
	{
		accountNum = accNum; 
	}

	/**
	 * withdrawal --
	 * allows a withdrawal to be made from an account. First checks if their are sufficient funds in the account. 
	 * @param with -- the amount to be withdrawn.
	 * @return - a boolean representing if the transaction was successful.
	 */
	public boolean withdrawal(int with, int chang)
	{
		if(with <= balance && chang <= change)
		{
			balance = balance - with;
			change = change - chang;
			return true;
		}
		else
			return false;
	}

	/**
	 * deposit --
	 * allows a deposit to be made into an account.
	 * @param dep - the amount to be deposited.
	 */
	public void deposit(int dep)
	{
		balance = balance + dep;
	}

	/**
	 * toString --
	 * Returns a string representing the current state of the account.
	 * @return the status of the account.
	 */
	public String toString()
	{
		String str;
		str = ref.toString() + "\nBalance: $" + balance + "." + change + " Account Number: " + accountNum;
		return str;
	}
}
