package com.example.despenser;

import com.example.atmMachine.ATMMachine;
import com.example.atmMachine.DenominationCurreny;

public class FiftyDespenser extends Despenser{

	public FiftyDespenser(Despenser despenser) {
		this.nextDespenser(despenser);
	}
	
	public void process(ATMMachine atmMachine,int amount) {
		int notes = (int)Math.min(amount/50, atmMachine.getDenominationCurrency().get(DenominationCurreny.FIFTY));
		if(notes!=0) {
			System.out.println(notes+" notes of 50 Rs.");
		}
		super.process(atmMachine,amount%50);
	}
}
