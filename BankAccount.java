package data_classes;

import validation_classes.IntegerValidationException;


public class BankAccount extends Bank {
	
	// BankAccount fields
	private String AccNum;
	private String accType;
	private String LName;
	private String FName;
	private int age;
	private String address;
	private long balance;
	
	
	// symbolic constants
	private static long DEFAULT_BALANCE;
	
	
	// initialization block
	{
		DEFAULT_BALANCE = 0;
	}
	
	
	// constructors
	public BankAccount(String bankName, String bankAddress) {
		super(bankName, bankAddress);
	}
	
	public BankAccount(String bankName, String bankAddress, String accNo, String accType, String Lname, String Fname, int age, String cutomerAddress){
		
		super(bankName, bankAddress);
		validateString(accNo);
		this.AccNum = accNo;
		validateString(accType);
		this.accType = accType;
		validateString(Lname);
		this.LName = Lname;
		validateString(Fname);
		this.FName = Fname;
		validateInteger(age);
		this.age = age;
		validateString(address);
		this.address = cutomerAddress;
		this.balance = DEFAULT_BALANCE;
	}
	
	
	// method to validate Integer
	private static void validateInteger(int value) {
		if(value < 1) {
			throw new IntegerValidationException("Invalid age: " + value);
		}
	}


	// get and set methods
	public String getAccNum() {
		return AccNum;
	}

	public void setAccNum(String accNum) {
		validateString(accNum);
		AccNum = accNum;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String acctype) {
		validateString(acctype);
		accType = acctype;
	}

	public String getLName() {
		return LName;
	}

	public void setLName(String lName) {
		validateString(lName);
		LName = lName;
	}

	public String getFName() {
		return FName;
	}

	public void setFName(String fname) {
		validateString(fname);
		this.FName = fname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		validateInteger(age);
		this.age = age;
	}

	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		validateString(address);
		this.address = address;
	}

	public long getBalance() {
		return balance;
	}
	
	
	// method to deposit amount
	public void deposit(double depositAmount) {
		
		if(depositAmount < 0) {
			System.out.println("Please insert amount to deposit: " + depositAmount);
		}
		balance += depositAmount;
	}
	
	
	// method to withdraw amount
	public void withdraw(double withdrawAmount) {
		
		if(balance - withdrawAmount >= 0) {
			balance -= withdrawAmount;
		}
		else {
			System.out.println("Insufficient funds: " + balance);
		}
	}
	
	
	// method to transfer amount
	public void transfer(Double transferAmount, BankAccount acc) {
		
		if(balance - transferAmount >= 0) {
			balance -= transferAmount;
			acc.deposit(transferAmount);
		}
		else {
			System.out.println("Insufficient funds: " + balance);
		}
	}

	
	// toString method
	@Override
	public String toString() {
		return "\nAccount Information:\nAccount Number: " + AccNum + "\nAccount Type: " + accType + "\nLast Name: " + LName + "\nFirst Name: " + FName
				+ "\nAge: " + age + "\nAddress: " + address + "\nBalance: " + balance + "\nBranch: " + getName() + "\n";
	}

	
}
