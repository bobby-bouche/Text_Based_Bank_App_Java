package driver_class;

import data_classes.Bank;
import data_classes.BankAccount;
import keyboard_class.Keyboard;


public class Driver {
	
	// Driver fields
	private Bank bank;
	private Keyboard kb;
	
	
	// constructor
	public Driver() {
		
		bank  = new Bank("BiB Vancouver", "123 make-believe dr.");
		kb    = new Keyboard();
	}
	
	
	// method to launch main menu
	public void runMainMenu() {
		
		int choice;
		boolean proceed  = true;
		String errorMsg  = "Invalid entry, enter an integer value in the range (1-3)\n";
		
		while(proceed) {
			
			System.out.println(
		            "Main Menu:\n"
		            + "1. Customer Menu\n"
		            + "2. Administrator Menu\n"
		            + "3. Exit\n");
			
			choice = kb.readInteger(errorMsg, 1, 3);
		
			switch(choice) {
			
				case 1:
					runCustomerMenu();
					break;
					
				case 2:
					runAdministratorMenu();
					break;
					
				case 3:
					System.out.println("Bye for now!");
					proceed = false;
					break;
					
				default:
					System.out.println("Invalid selection: " + choice + ", please try again.\n");
				
			}
		}
	}
	
	
	// method to run customer menu
	public void runCustomerMenu() {
		
		int choice;
		boolean proceed  = true;
		String errorMsg  = "Invalid entry, enter an integer value in the range (1-2)";
		
		while(proceed) {
			
			System.out.println(
		            "Customer Menu:\n"
		            + "1. Select account\n"
		            + "2. Back\n");
			
			choice = kb.readInteger(errorMsg, 1, 2);
			
			switch(choice) {
			
				case 1:
					runAccountsMenu();
					break;
					
				case 2:
					System.out.println("returing to main menu..\n");
					proceed = false;
					break;
					
				default:
					System.out.println("Invalid selection: " + choice + ", please try again.\n");
				
			}	
		}	
	}
	
	
	// method to run administration menu
	public void runAdministratorMenu() {
		
		int choice;
		boolean proceed  = true;
		String errorMsg  = "Invalid entry, enter an integer value in the range (1-5)";
		
		while(proceed) {
			
			System.out.println(
		            "Administrator Menu:\n"
                    + "1. Add account\n"
                    + "2. Delete account\n"
                    + "3. Search by account number\n"                
                    + "4. Display all accounts\n"
                    + "5. Back\n");
			
			choice = kb.readInteger(errorMsg, 1, 5);
			
			switch(choice) {
			
				case 1:
					bank.openNewAccount();
					break;
					
				case 2:
					String deleteAccNum;
					String deletePromptMsg = "Enter account number: ";
					String deleteErrorMsg  = "Error, Please try again.\n";
					deleteAccNum = kb.readAccountNumber(deletePromptMsg, deleteErrorMsg);
					bank.deleteAccount(deleteAccNum);
					break;
					
				case 3:
					String displayAccNum;
					String displayPromptMsg = "Enter account number: ";
					String displayErrorMsg  = "Error, Please try again.\n";
					displayAccNum = kb.readAccountNumber(displayPromptMsg, displayErrorMsg);
					bank.displayAccountInformation(displayAccNum);
					break;
					
				case 4:
					bank.displayAllAccounts();
					break;
					
				case 5:
					proceed = false;
					System.out.println("returing to main menu..\n");
					break;
					
				default:
					System.out.println("Invalid selection: " + choice + ", please try again.\n");
					break;
						
			}
		}	
	}
	
	
	// method to run accounts menu
	public void runAccountsMenu() {
		
		int choice;
		boolean proceed  = true;
		String errorMsg  = "Invalid entry, enter an integer value in the range (1-3)";
		
		while(proceed) {
			
			System.out.println(
					"Accounts Menu:\n"
					+ "1. Checking account\n"
					+ "2. Savings account\n"
					+ "3. Back\n");
			
			choice = kb.readInteger(errorMsg, 1, 6);
			
			switch(choice) {
			
				case 1:
					String checkingAccNum;
					String checkingPromptmsg = "Enter account number: ";
					String checkingErrorMsg  = "Error, Checking account numbers must start with the letter 'C' and contain 5 numbers. (e.g C12345)\nPlease try again:\n";
					checkingAccNum = kb.readAccountNumber(checkingPromptmsg,checkingErrorMsg, "C");
					System.out.println(bank.getAccount(checkingAccNum));
					
					if(!(bank.getAccount(checkingAccNum) == null)) {
						runSelectedAccountMenu(checkingAccNum);
					}
					break;
					
				case 2:
					String savingsAccNum;
					String savingsPromptmsg = "Enter account number: ";
					String savingsErrorMsg  = "Error, Savings account numbers must start with the letter 'S' and contain 5 numbers. (e.g S12345)\nPlease try again:\n";
					savingsAccNum = kb.readAccountNumber(savingsPromptmsg,savingsErrorMsg, "S");
					System.out.println(bank.getAccount(savingsAccNum));
					
					if(!(bank.getAccount(savingsAccNum) == null)) {
						runSelectedAccountMenu(savingsAccNum);
					}
					break;	
					
				case 3:
					proceed = false;
					System.out.println("returning to customer menu..\n");
					break;
					
				default:
					System.out.println("Invalid selection: " + choice + ", please try again.\n");
					break;
			
			}
		}
	}
	
	
	// method to run selected account menu
	public void runSelectedAccountMenu(String accNum) {
		
		BankAccount account;
		account = bank.getAccount(accNum);
		
		int choice;
		boolean proceed  = true;
		String errorMsg  = "Invalid entry, enter an integer value in the range (1-5)";
		
		while(proceed) {
			
			System.out.println("Checking Account Menu:\n"
					+ "1. Check Balance\n"
					+ "2. Deposit\n"
					+ "3. Withraw\n"
					+ "4. Transfer\n"
					+ "5. back\n");
			
			choice = kb.readInteger(errorMsg, 1, 5);
			
			switch(choice) {
			
				case 1:
					System.out.println("Balance: $" + account.getBalance() + "\n");
					break;
					
				case 2:
					double depositAmount;
					String depositPromptMsg = "Enter amount you wish to deposit: \n";
					String depositErrorMsg  = "Error, Please try again.\n";
					
					depositAmount = kb.readDouble(depositPromptMsg, depositErrorMsg);
					account.deposit(depositAmount);
					
					System.out.println("$" + depositAmount + " has been deposited to your account..\n");
					break;
					
				case 3:
					double withdrawAmount;
					String withdrawPromptMsg = "Enter amount you wish to withdraw:\n";
					String withdrawErrorMsg  = "Error, Please try again.\n";
					
					withdrawAmount = kb.readDouble(withdrawPromptMsg, withdrawErrorMsg);
					account.withdraw(withdrawAmount);
					
					System.out.println("$" + withdrawAmount + " has been withdrawn from your account..\n");
					System.out.println("Remaining balance: $" + account.getBalance());
					break;
					
				case 4:
					Double transferAmount;
					String transferPromptMsg = "Enter amount you wish to transfer:\n";
					String transferErrorMsg  = "Error, Please try again.\n";
					transferAmount = kb.readDouble(transferPromptMsg, transferErrorMsg);
					
					String receivierAccNum;
					BankAccount receiver;
					String receiverPromptMsg = "Enter receiver account number:\n";
					receivierAccNum = kb.readAccountNumber(receiverPromptMsg, transferErrorMsg);
					receiver = bank.getAccount(receivierAccNum);
					
					account.transfer(transferAmount, account);
					
					System.out.println(transferAmount + " has been transferred to " + receiver.getAccNum());
					break;
					
					
				case 5:
					proceed = false;
					System.out.println("Returing to accounts menu..\n");
					break;
					
				default:
					System.out.println("Invalid selection: " + choice + ", please try again.\n");
					break;
			}
		}
	}
	

	// main method
	public static void main(String[] args) {
		
		Driver driver;
		driver = new Driver();
		
		try {
			
			driver.runMainMenu();
			
		}catch(NullPointerException e) {
			System.out.println(e);
			
		}catch(IllegalArgumentException e) {
			System.out.println(e);
			
		}catch(Exception e) {
			System.out.println(e);
			
		}
	}
	
}
