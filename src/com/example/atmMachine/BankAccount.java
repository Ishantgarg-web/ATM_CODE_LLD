package com.example.atmMachine;
import java.util.Random;
import java.util.UUID;

public class BankAccount {
	private int bankAccountUUID;
		
	private User user;
	
	private int balance;
	
	public BankAccount(User user, int bal) {
		this.bankAccountUUID = new Random().nextInt(100);
		this.user = user;
		this.balance = bal;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getBankAccountUUID() {
		return bankAccountUUID;
	}

	public User getUser() {
		return user;
	}

	public int getBalance() {
		return balance;
	}
	
}
