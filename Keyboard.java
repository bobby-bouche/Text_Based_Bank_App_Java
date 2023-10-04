package keyboard_class;

import java.util.NoSuchElementException;
import java.util.Scanner;


public class Keyboard {
	
	// keyboard field
	private Scanner input;
	
	
	// constructor
	public Keyboard(){
		
		input = new Scanner(System.in);
	}

	
	// method to validate integer from user
	public int readInteger(String promptMsg, String errorMsg) {
		
		int num = 0;
		String strInput;
		boolean valid = false;
		
		while(valid == false) {
			
			System.out.println(promptMsg);
			strInput = input.nextLine();
			
			try {
				num = Integer.parseInt(strInput);
				valid = true;
			}
			catch(NumberFormatException e) {
				System.out.println(errorMsg);
			}
		}
		return num;
	}
	
	
	// overloaded method to validate integer from user
	public int readInteger(String errorMsg) {
		
		int num = 0;
		String strInput;
		boolean valid = false;
		
		while(valid == false) {
			
			strInput = input.nextLine();
			
			try {
				num = Integer.parseInt(strInput);
				valid = true;
			}
			catch(NumberFormatException e) {
				System.out.println(errorMsg);
			}
		}
		return num;
	}
	
	
	// overloaded method to validate integer from user
	public int readInteger(String promptMsg, String errorMsg, int low, int high) {
		
		int num = 0;
		String strInput;
		boolean valid = false;
		
		while(valid == false) {
			
			System.out.println(promptMsg);
			strInput = input.nextLine();
			
			try {
				num = Integer.parseInt(strInput);
				if(num >= low && num <= high) {
					valid = true;
				}
				else {
					System.out.println(errorMsg);
				}
			}
			catch(NumberFormatException e) {
				System.out.println(errorMsg);
			}
		}
		return num;
	}
	
	
	// overloaded method to validate integer from user
	public int readInteger(String errorMsg, int low, int high) {
		
		int num = 0;
		String strInput;
		boolean valid = false;
		
		while(valid == false) {
			
			strInput = input.nextLine();
			
			try {
				num = Integer.parseInt(strInput);
				if(num >= low && num <= high) {
					valid = true;
				}
				else {
					System.out.println(errorMsg);
				}
			}
			catch(NumberFormatException e) {
				System.out.println(errorMsg);
			}
		}
		return num;
	}
	
	
	// method to validate double from user
	public Double readDouble(String promptMsg, String errorMsg) {
		
		Double num = 0.0;
		String strInput;
		boolean valid = false;
		
		while(valid == false) {
			
			System.out.println(promptMsg);
			strInput = input.nextLine();
			
			try {
				num = Double.parseDouble(strInput);
				valid = true;
			}
			catch(NumberFormatException e) {
				System.out.println(errorMsg);
			}
		}
		return num;
	}
	
	
	// method to validate string from user
	public String readString(String errorMsg) {
		
		String strInput = null;
		boolean valid = false;
		
		while(valid == false) {
			
			strInput = input.nextLine();
			
			try {
				if(!(strInput == null) && !strInput.isBlank()) {
					valid = true;
				}
				else {
					System.out.println(errorMsg);
				}
			}
			catch(Exception e) {
					System.out.println(errorMsg);
			}	
		}
		return strInput;
	}
	
	
	// overloaded method to validate string from user
	public String readString(String promptMsg, String errorMsg) {
		
		String strInput = null;
		boolean valid = false;
		
		while(valid == false) {
			
			System.out.println(promptMsg);
			strInput = input.nextLine();
			
			try {
				if(!(strInput == null) && !strInput.isBlank()) {
					valid = true;
				}
				else {
					System.out.println(errorMsg);
				}
			}
			catch(Exception e) {
					System.out.println(errorMsg);
			}	
		}
		return strInput;
	}
	
	
	// method to validate account number from user
	public String readAccountNumber(String promptMsg, String errorMsg) {
		
		String accNum = null;
		boolean valid = false;
		
		while(valid == false ) {
			
			System.out.println(promptMsg);
			accNum = input.nextLine();
			
			try {
				if(!(accNum == null) && !accNum.isBlank() && (accNum.toLowerCase().startsWith("c") || accNum.toLowerCase().startsWith("s")) && accNum.length() < 7) {
					valid = true;
				}
				else {
					System.out.println(errorMsg);
				}
			}
			catch(NoSuchElementException e) {
				System.out.println(errorMsg);
			}	
			catch(Exception e) {
					System.out.println(errorMsg);
			}	
		}
		return accNum;
	}
	
	
	// overloaded method to validate account number from user
	public String readAccountNumber(String promptMsg, String errorMsg, String accType) {
		
		String accNum = null;
		boolean valid = false;
		
		while(valid == false) {
			
			System.out.println(promptMsg);
			accNum = input.nextLine();
			
			try {
				if(!(accNum == null) && !accNum.isBlank() && accNum.toLowerCase().startsWith(accType.toLowerCase()) && accNum.length() < 7) {
					valid = true;
				}
				else {
					System.out.println(errorMsg);
				}
			}
			catch(NoSuchElementException e) {
				System.out.println(errorMsg);
			}
			catch(Exception e) {
					System.out.println(errorMsg);
			}	
		}
		return accNum;
	}
	
	
	// method to validate account type from user
	public String readAccountType(String promptMsg, String errorMsg) {
		
		String strInput = null;
		boolean valid = false;
		
		while(valid == false) {
			
			System.out.println(promptMsg);
			strInput = input.nextLine();
			
			try {
				if(strInput.equalsIgnoreCase("savings") || strInput.equalsIgnoreCase("checking")) {
					valid = true;
				}
				else {
					System.out.println(errorMsg);
				}
			}
			catch(Exception e) {
					System.out.println(errorMsg);
			}	
		}
		return strInput;
	}
	
	
}
