package proj1fa14;
/**
 * Title: proj1fa14
 * 
 * Description: The Customer class. This class stores first, last names, age, and phone number in a customer object
 * it also has assessor and mutator methods for each of he instance variables and includes a tostring.
 * @author Jason Diaz
 *
 */
public class Customer {

	private String firstName;
	private String lastName;
	private int age;
	private String phoneNum;

	/**
	 * parameterized constructor --
	 * this creates a customer object. It stores a first and last name, age, and phone number all of which have to be
	 * passed through the parameters.
	 * @param fN - first name
	 * @param lN - last name
	 * @param a - age
	 * @param pN - phone number
	 */
	public Customer(String fN, String lN, int a, String pN)
	{
		firstName = fN;
		lastName = lN;
		age = a;
		phoneNum = pN;
	}

	/**
	 * getFirstName --
	 * allows the programmer to access what is stored in the variable for the first name.
	 * @return a string containing the first name.
	 */
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * getLastName --
	 * allows the programmer to access what is stored in the variable for the lastName.
	 * @return a string containing the last name.
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * getAge --
	 * allows the programmer to access what is stored in the variable for age.
	 * @return an integer containing the age.
	 */
	public int getAge()
	{
		return age;
	}

	/**
	 * getPhoneNum --
	 * allows the programmer to access what is stored in the variable for the phone number.
	 * @return a string containing the phone number.
	 */
	public String getPhoneNum()
	{
		return phoneNum;
	}

	/**
	 * setFirstName --
	 * allows the programmer update what i store in for first name.
	 * @param sFN the new first name that will be store in the variable for first name.
	 */
	public void setFirstName(String sFN)
	{
		firstName = sFN;
	}

	/**
	 * setLastName --
	 * allows the programmer to update what i stored in for last name.
	 * @param sLN new last name that will be stored for last name.
	 */
	public void setLastName(String sLN)
	{
		lastName = sLN;
	}

	/**
	 * setAge --
	 * allows the programmer to update what is stored in for age.
	 * @param sA the new age that will be stored in for the old one.
	 */
	public void setAge(int sA)
	{
		age = sA;
	}

	/**
	 * setPhoneNum --
	 * allows user to update the variable which store the customers phone number.
	 * @param sPN the number which the variable is going to be updated to.
	 */
	public void setPhoneNum(String sPN)
	{
		phoneNum = sPN;
	}

	/**
	 * toString --
	 * Returns a string representing the current state of the customer.
	 * @return the information of the customer.
	 */
	public String toString()
	{
		String str;
		str = "Name: " + lastName + ", " + firstName + " Age: " + age + " Phone Number: " + phoneNum;
		return str;
	}
}
