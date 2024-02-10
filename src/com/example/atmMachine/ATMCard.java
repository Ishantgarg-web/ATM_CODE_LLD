package com.example.atmMachine;
import java.util.Random;
import java.util.UUID;

import com.example.despenser.Despenser;
import com.example.despenser.FiftyDespenser;
import com.example.despenser.FiveHundredDespenser;
import com.example.despenser.HundredDespenser;
import com.example.despenser.ThousandDespenser;

public class ATMCard {
	private int atmCardUUID;
	
	private BankAccount bankAccount;
	
	public ATMCard(BankAccount bankAccount,int pin,int cvv, String cardHolderName) {
		this.atmCardUUID = new Random().nextInt(100);
		this.bankAccount = bankAccount;
		this.pin = pin;
		this.cvv = cvv;
		this.cardHolderName = cardHolderName;
	}
	
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	private int pin;
	
	public int getPin() {
		return pin;
	}

	private String cardHolderName;
	
	private int cvv;

	public void modifyBalance(ATMMachine atmMachine, ATMCard atmCard, int amount) {
		/**
		 * 1. check if we are able to despense money according to denominations
		 * 2. if we are able to despense money, then update the denominations.
		 */
		Despenser despenser = new ThousandDespenser(new FiveHundredDespenser(new HundredDespenser(new FiftyDespenser(null))));
		System.out.println("despensed function done1");
		despenser.process(atmMachine,amount);
		System.out.println("despensed function done2");
		if(atmMachine.isMoneyAbleToDespense() || despenser.isAbleToDespense()) {
			// it means, this amount can be despense.
			System.out.println("come into this amount is: "+amount);
			atmMachine.updateDenominationsBasedOnAmount(amount);
			atmCard.updateATMCardBalance(amount);
		}else {
			// it means, this amount can not be processed.
			System.out.println("This amount can not be processed by ATM Machine");
		}
		
	}

	private void updateATMCardBalance(int amount) {
		this.bankAccount.setBalance(this.bankAccount.getBalance() - amount);
	}
}
