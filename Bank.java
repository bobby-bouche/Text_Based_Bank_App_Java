package data_classes;

import java.util.Map;

import keyboard_class.Keyboard;

import java.util.HashMap;

import validation_classes.StringValidationException;


public class Bank {
	
	// Bank fields
	private String name;
	private String address;
	private Keyboard kb;
	
	private Map<String, BankAccount> accounts;
	
	
	// constructor
	public Bank(String name, String address) {
		
		super();
		validateString(name);
		this.name = name;
		validateString(address);
		this.address = address;
	
		accounts = new HashMap<>();
		kb       = new Keyboard();
	}
	
	
	// method to validate String
	protected static void validateString(String strInput) {
		
		if(strInput == null || strInput.isBlank()) {
			throw new StringValidationException("Error - Invalid string: " + strInput);
		}
	}
	
		
	// get methods
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	
//	// method to add account
//	public void addAccount(BankAccount acc) {
//		validateAccount(acc);
//		accounts.put(acc.getAccNum(), acc);
//	}
	
	
	// method to retrieve account
	public BankAccount getAccount(String accNum) {
		
		BankAccount account = null;
		validateString(accNum);
		if(accounts.containsKey(accNum)) {
			account = accounts.get(accNum);
		}
		else {
			System.out.println("Account " + accNum + " does not exist\n");
		}
		return account;
	}
	
	
	// method to remove account
	public void deleteAccount(String accNum) {
		
		validateString(accNum);
		if(accounts.containsKey(accNum)){
			accounts.remove(accNum);
			System.out.println("account " + accNum + " has been removed\n");
		}
		else {
			System.out.println("Account " + accNum + " does not exist\n");
		}
	}
	
	
	// method to display account infomation
	public void displayAccountInformation(String acc) {
		
		validateString(acc);
		if(accounts.containsKey(acc)) {
			System.out.println("\nAccount number: " + accounts.get(acc).getAccNum());
			System.out.println("Account type: " + accounts.get(acc).getAccType());
			System.out.println("Name: " + accounts.get(acc).getLName() + " " + accounts.get(acc).getFName());
			System.out.println("Age: " + accounts.get(acc).getAge());
			System.out.println("address: " + accounts.get(acc).getAddress());
			System.out.println("Balance: " + accounts.get(acc).getBalance() + "\n");
		}
		else {
			System.out.println("Account " + acc + " does not exist\n");
		}
	}
	
	
	// method to display all accounts
	public void displayAllAccounts() {
		
		if(accounts.isEmpty()) {
			System.out.println("Business is bad.. Total accounts: " + accounts.size() + "\n");
		}
		else {
			for(BankAccount acc : accounts.values()) {
				System.out.println(acc.toString());
			}
		}
	}
	
	
	// method to open a new bank account
	public void openNewAccount() {
		
		BankAccount account = new BankAccount(this.name, this.address);
		
		String accNum;
		String accountNumberPromptmsg = "Account numbers must start with the letter 'C' for checking account or 'S' for savings account and contain 5 numbers. (e.g C12345)\nEnter account number: ";
		String accountNumberErrorMsg  = "Error, Please try again.\n";
		accNum = kb.readAccountNumber(accountNumberPromptmsg, accountNumberErrorMsg);
		account.setAccNum(accNum);
		
		String accType;
		String accTypePromptMsg = "Enter account type - 'checking' or 'savings':";
		String accTypeErrorMsg  = "Error, Please try again.\n";
		accType = kb.readAccountType(accTypePromptMsg, accTypeErrorMsg);
		account.setAccType(accType);
		
		String lastName;
		String lastNamePromptMsg = "Enter last name: ";
		String lastNameErrorMsg  = "Error, Please try again.\n";
		lastName = kb.readString(lastNamePromptMsg, lastNameErrorMsg);
		account.setLName(lastName);
		
		String firstName;
		String firstNamePromptMsg = "Enter first name: ";
		String firstNameErrorMsg  = "Error, Please try again.\n";
		firstName = kb.readString(firstNamePromptMsg, firstNameErrorMsg);
		account.setFName(firstName);

		int age;
		String agePromptMsg = "Enter age: ";
		String ageErrorMsg  = "Error, Please try again.\n";
		age = kb.readInteger(agePromptMsg, ageErrorMsg);
		account.setAge(age);
		
		String address;
		String addressPromptMsg = "Enter address: ";
		String addressErrorMsg  = "Error, Please try again.\n";
		address = kb.readString(addressPromptMsg, addressErrorMsg);
		account.setAddress(address);
		
		accounts.put(account.getAccNum(), account);
		System.out.println("Account: #" + account.getAccNum().toUpperCase() + " has been added to the system..\n");
	}


	@Override
	public String toString() {
		return "Bank [name=" + name + ", address=" + address + ", accounts=" + accounts + "]";
	}

}
