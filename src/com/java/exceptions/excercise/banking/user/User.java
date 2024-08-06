package com.java.exceptions.excercise.banking.user;

import com.java.exceptions.excercise.banking.exceptions.DepositException;
import com.java.exceptions.excercise.banking.exceptions.WithdrawException;

public class User {
	
	private String name;
	private double balance;
	
	public User(String name) {
		this.name = name;
		this.balance = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double balanceEnquiry() {
		return this.balance;
	}

	public void depositBalance(double balance) throws DepositException{
		
		if(balance < 0)
			throw new DepositException("You cannot deposit balance less than 0");
		
		if(balance == 0)
			throw new DepositException("You cannot deposit balance equal to 0");
	
		this.balance += balance;
		
		System.out.println("Rs. " + balance + " has been successfully deposited to your account");
	}
	
	public void withdrawBalance(double balance) throws WithdrawException{
		
		if(balance < 0)
			throw new WithdrawException("You cannot withdraw balance less than 0");
		
		if(balance == 0)
			throw new WithdrawException("You cannot withdraw balance equal to 0");
		
		if(balance > this.balance)
			throw new WithdrawException("You do not have enough balance to withdraw this amount");		
		
		this.balance -= balance;
		
		System.out.println("Rs. " + balance + " has been successfully withdrawn from your account");
		
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", balance=" + balance + "]";
	}
		
}