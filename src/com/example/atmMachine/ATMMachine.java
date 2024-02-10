package com.example.atmMachine;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import State.ATMStateAbstractClass;
import State.IdleState;

public class ATMMachine {
	
	private int atmMachineUUID;
	
	/**
	 * This is used for balance of ATM Machine.
	 */
	private int balance;
	
	private boolean moneyAbleToDespense;
	
	public void setMoneyAbleToDespense(boolean moneyAbleToDespense) {
		this.moneyAbleToDespense = moneyAbleToDespense;
	}



	public boolean isMoneyAbleToDespense() {
		return moneyAbleToDespense;
	}

	private HashMap<DenominationCurreny, Integer> denominationCurrency;
	
	private ATMStateAbstractClass atmStateAbstractClass;

	public ATMStateAbstractClass getAtmState() {
		return atmStateAbstractClass;
	}
	
	

	public void setAtmState(ATMStateAbstractClass atmStateAbstractClass) {
		this.atmStateAbstractClass = atmStateAbstractClass;
	}
	
	public int giveBalanceBasedOnDenominations(HashMap<DenominationCurreny, Integer> denominationCurrency) {
		return denominationCurrency.get(DenominationCurreny.FIFTY)*50+
				denominationCurrency.get(DenominationCurreny.HUNDREDS)*100+
				denominationCurrency.get(DenominationCurreny.FIVE_HUNDREDS)*500+
				denominationCurrency.get(DenominationCurreny.THOUSANDS)*1000;
	}
	
	public ATMMachine(HashMap<DenominationCurreny, Integer> denominationCurrency) {
		this.balance = giveBalanceBasedOnDenominations(denominationCurrency);
		System.out.println("balance is: "+this.balance);
		this.atmStateAbstractClass = new IdleState();
		this.atmMachineUUID = new Random().nextInt(100);
		this.denominationCurrency = denominationCurrency;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public HashMap<DenominationCurreny, Integer> getDenominationCurrency() {
		return denominationCurrency;
	}

	public void updateDenominationsBasedOnAmount(int amount) {
		int leftAmount = amount;
		int usedThousandNotes = (int)Math.min(this.denominationCurrency.get(DenominationCurreny.THOUSANDS),leftAmount/1000);
		leftAmount = leftAmount%1000;
		int usedFiveHundredNotes = (int)Math.min(this.denominationCurrency.get(DenominationCurreny.FIVE_HUNDREDS),leftAmount/500);
		leftAmount = leftAmount%500;
		int usedHundredNotes = (int)Math.min(this.denominationCurrency.get(DenominationCurreny.HUNDREDS),leftAmount/100);
		leftAmount = leftAmount%100;
		int usedFiftyNotes = (int)Math.min(this.denominationCurrency.get(DenominationCurreny.FIFTY),leftAmount/50);
		leftAmount = leftAmount%50;
		this.denominationCurrency.put(DenominationCurreny.FIFTY, this.getDenominationCurrency().get(DenominationCurreny.FIFTY)-usedFiftyNotes);
		this.denominationCurrency.put(DenominationCurreny.HUNDREDS, this.getDenominationCurrency().get(DenominationCurreny.HUNDREDS)-usedHundredNotes);
		this.denominationCurrency.put(DenominationCurreny.FIVE_HUNDREDS, this.getDenominationCurrency().get(DenominationCurreny.FIVE_HUNDREDS)-usedFiveHundredNotes);
		this.denominationCurrency.put(DenominationCurreny.THOUSANDS, this.getDenominationCurrency().get(DenominationCurreny.THOUSANDS)-usedThousandNotes);
		this.balance = giveBalanceBasedOnDenominations(this.denominationCurrency);
	}
	
}
