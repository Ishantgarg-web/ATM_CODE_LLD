package com.example.atmMachine;

import java.util.HashMap;

import State.IdleState;

/**
 * 
 * @author ishant
 * This project is completed and well tested.
 */

public class Main {
	public static void main(String[] args) {
		HashMap<DenominationCurreny, Integer> denominationMap = new HashMap<>();
		denominationMap.put(DenominationCurreny.FIFTY, 100);
		denominationMap.put(DenominationCurreny.HUNDREDS, 10);
		denominationMap.put(DenominationCurreny.FIVE_HUNDREDS, 10);
		denominationMap.put(DenominationCurreny.THOUSANDS, 10);
		
		ATMMachine atmMachine = new ATMMachine(denominationMap);
		ATMCard atmCard = new ATMCard(new BankAccount(new User("ishant"), 6350),
					100,
					777,
					"ishant"
				);
		atmMachine.getAtmState().insertCard(atmMachine, atmCard);
		atmMachine.getAtmState().authenticateCard(atmMachine, atmCard, 100);
		atmMachine.getAtmState().SelectOptionsState(atmMachine, atmCard, ATMSelectOptionEnum.CASH_WITHDRAWL);
		atmMachine.getAtmState().cashWithdrawlState(atmMachine, atmCard, 6000);
		System.out.println("ATM Balance after despense money is: "+atmMachine.getBalance());
		System.out.println("ATM Card balance after despense money is: "+atmCard.getBankAccount().getBalance());
		atmMachine.getAtmState().SelectOptionsState(atmMachine, atmCard, ATMSelectOptionEnum.CASH_WITHDRAWL);
		atmMachine.getAtmState().cashWithdrawlState(atmMachine, atmCard, 350);
		System.out.println("ATM Balance after despense money is: "+atmMachine.getBalance());
		System.out.println("ATM Card balance after despense money is: "+atmCard.getBankAccount().getBalance());
	}
}
