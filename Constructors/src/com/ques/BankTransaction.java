package com.ques;
import java.util.Scanner;
 
public class BankTransaction {
 
	private static int accountBalance;
    private static boolean isAccountCreated = false;
    private static boolean isLoggedIn = false;
 
	public static void createAccount(Scanner sc) {
		System.out.println("Enter your first name:");
		String firstName = sc.next();
		System.out.println("Enter your last name:");
		String lastName = sc.next();
		System.out.println("Enter your account balance:");
		int accountBalance = sc.nextInt();
		isAccountCreated = true;
		System.out.println("Account Details:");
		System.out.println(firstName + " " + lastName + " " +  accountBalance);
	}
	
	public static void login() {
		if(!isAccountCreated) {
			System.out.println("No Account found. Please create an account: ");
			return;
		}else {
			System.out.println("Enter Credentials: ");
			isLoggedIn = true;
		}
	}
	
	public static void transfer(Scanner sc) {
		if(isLoggedIn) {
			System.out.println("Enter amount to transfer: ");
			int transferAmount = sc.nextInt();
			
			int remainingBalance = accountBalance - transferAmount;
			System.out.println("Remaining Balance : " + remainingBalance);
		}else {
			System.out.println("Please Log in first.");
		}
	}
	
	public static void withdraw(Scanner sc) {
		if(isLoggedIn) {
			System.out.println("Enter amount to withdraw: ");
			int withdrawAmount = sc.nextInt();
			
			int remainingBalance = accountBalance - withdrawAmount;
			System.out.println("Remaining Balance : " + remainingBalance);
		}else {
			System.out.println("Please Log in first.");
		}
	}
	
	public static void checkBalance() {
		if(isLoggedIn) {
			System.out.println("Balance amount is: " + accountBalance);
		}else {
			System.out.println("Please Log in first.");
		}
	}
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 
			System.out.println("===== Bank Menu =====");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Transfer");
            System.out.println("4. Withdraw");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");
 
		int n = sc.nextInt();
		switch(n) {
			case 1:
				createAccount(sc);
				break;
			case 2:
				login();
				break;
			case 3:
				transfer(sc);
				break;
			case 4:
				withdraw(sc);
				break;
			case 5:
				checkBalance();
				break;
			default:
				System.out.println("Choose correct transaction");
		}
			
	}
 
}
 