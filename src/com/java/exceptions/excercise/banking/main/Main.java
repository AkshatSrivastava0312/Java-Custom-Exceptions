package com.java.exceptions.excercise.banking.main;

import java.util.Scanner;

import com.java.exceptions.excercise.banking.atm.AtmPrompt;
import com.java.exceptions.excercise.banking.exceptions.DepositException;
import com.java.exceptions.excercise.banking.exceptions.WithdrawException;
import com.java.exceptions.excercise.banking.user.User;

public class Main {
	
	

	public static void main(String[] args) {
		
		System.out.println("************ Welcome to ATM ************");	
		
		AtmPrompt[] prompts = AtmPrompt.values();
		
		Scanner sc = new Scanner(System.in);
				
		System.out.println("Enter your name: ");
		String username = sc.nextLine();
		
		User user = new User(username);
		
		System.out.println("Welcome " + user.getName());
			
		boolean isRunning = true;
		
		while(isRunning) {
			
			for(int i=0; i<prompts.length;i++) {
				System.out.println("Press `" + (i+1) + "` for `" + prompts[i].name());				
			}
			
			System.out.println("Press `e` to exit");
			
			String choice = sc.nextLine();
			double amount;
			
			switch (choice) {
			
			case "1": {
				System.out.println("Enter amount to withdraw: ");		
				amount = sc.nextDouble();
				sc.nextLine();
				try {
					user.withdrawBalance(amount);
					break;
				} catch (WithdrawException e) {
					System.out.println(e.getMessage());
					break;
				}			
			}	
			case "2":{
				System.out.println("Enter amount to deposit: ");		
				amount = sc.nextDouble();
				sc.nextLine();
				try {
					user.depositBalance(amount);
					break;
				} catch (DepositException e) {
					System.out.println(e.getMessage());
					break;
				}			
			}
			case "3":{
				amount = user.balanceEnquiry(); 
				System.out.println("You have Rs. " + amount + " in your account");
				break;
			}		
			case "4":{
				System.out.println("Name: " + user.getName());
				System.out.println("Account Balance: Rs. " + user.balanceEnquiry());
				break;
			}		
			case "e":{ 
				isRunning = false;			
				break;
			}
			default: System.out.println("Invalid choice");
			
			}
			
			System.out.println(" ------------------------------- ");
			
			
		}	
		
		System.out.println("************ Thanks for using the ATM ************");
		
		sc.close();
		
	}

}