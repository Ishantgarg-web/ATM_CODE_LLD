package com.example.despenser;

import com.example.atmMachine.ATMMachine;
import com.example.atmMachine.DenominationCurreny;

public class FiveHundredDespenser extends Despenser{

	public FiveHundredDespenser(Despenser despenser) {
		super.nextDespenser(despenser);
	}
	
	public void process(ATMMachine atmMachine,int amount) {
		int notes = (int)Math.min(amount/500, atmMachine.getDenominationCurrency().get(DenominationCurreny.FIVE_HUNDREDS));
		if(notes!=0) {
			System.out.println(notes+" notes of 500 Rs.");
			
		}
		int leftAmount = amount%500;
		super.process(atmMachine,leftAmount);
	}

}
