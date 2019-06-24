package proj1fa14;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Title: proj1fa14
 * 
 * Description: This is the application class. It creates a Bank object. The program then displays a window which allows the user to
 * pick what they would like to do: display accounts, balance inquiry, deposit, withdrawal, and exit. The program 
 * loops to the main menu until the user clicks exit.  
 * @author Jason Diaz
 *
 */
public class Proj1App {

	public static void main(String [] args) throws Exception 
	//main method including throws Exception to be able to read the .txt file
	{

		Bank chasing = new Bank();

		int choice = 0;
		int amount = 0;
		String accInquiry = new String();
		String[] choices = {"Display Accounts", "Balance Inquiry", "Deposit", "Withdrawal", "Exit"};
		//main menu choices
		while(choice != 4)
		{
			choice = JOptionPane.showOptionDialog(null,
					"Thank you for choosing Chasing bank",//text displayed in the window
					"Main Menu",						  //text displayed in the window's title bar
					JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					choices,              		       	 //text to be displayed in each button
					choices[0]);            			 //default button
			//displays the main menu
			switch (choice)
			//allows the use of cases instead of writing nested if/else statements
			{
			case 0:
				JTextArea text = new JTextArea(20,30);
				JScrollPane scroll = new JScrollPane(text);
				text.setText(chasing.toString());
				JOptionPane.showMessageDialog(
						null,
						scroll,
						"Display Accounts",
						JOptionPane.DEFAULT_OPTION);
				break;
			case 1:
				accInquiry = JOptionPane.showInputDialog("What is your account number?");

				if(chasing.balance(accInquiry) != -1)
				{
					JOptionPane.showMessageDialog(null,"Your balance is: $" + chasing.balance(accInquiry), "Balance Inquiry",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Sorry wrong account number", "Balance Inquiry",JOptionPane.INFORMATION_MESSAGE);
				}
				break;
			case 2:
				accInquiry = JOptionPane.showInputDialog("What is your account number?");
				if(chasing.deposit(accInquiry, amount) == true)
				{
					amount = (int) Double.parseDouble(JOptionPane.showInputDialog("How much would you like to deposit?"));
					chasing.deposit(accInquiry,amount);
					JOptionPane.showMessageDialog(null,"Your new account balance is: $" + chasing.balance(accInquiry),"Deposit",JOptionPane.INFORMATION_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null,"Sorry wrong account number", "Balance Inquiry",JOptionPane.INFORMATION_MESSAGE);
				break;
			case 3:
				accInquiry = JOptionPane.showInputDialog("What is your account number?");
				if(chasing.withdrawal(accInquiry,amount)==true)
				{
					amount = (int) Double.parseDouble(JOptionPane.showInputDialog("How much would you like to withdraw?"));
					if(chasing.withdrawal(accInquiry,amount) == true)
					{
						JOptionPane.showMessageDialog(null,"Your withdrawal has been processed." + "\nYour new account balance is: $" + chasing.balance(accInquiry), "Withdraw",JOptionPane.INFORMATION_MESSAGE);
					}
					else
						JOptionPane.showMessageDialog(null,"You do not have sufficient funds in"
								+ "\nthis account to process this transaction." + "\nYour account balance is: $" + chasing.balance(accInquiry), "Withdraw",JOptionPane.INFORMATION_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null,"Sorry wrong account number", "Withdraw",JOptionPane.INFORMATION_MESSAGE);
			}//end cases
		}//end while
	}//end main
}//end proj1fa14