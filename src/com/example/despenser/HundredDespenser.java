package com.example.despenser;

import com.example.atmMachine.ATMMachine;
import com.example.atmMachine.DenominationCurreny;

public class HundredDespenser extends Despenser{

	public HundredDespenser(Despenser despenser) {
		super.nextDespenser(despenser);
	}
	
	public void process(ATMMachine atmMachine,int amount) {
		int notes = (int)Math.min(amount/100, atmMachine.getDenominationCurrency().get(DenominationCurreny.HUNDREDS));
		if(notes!=0) {
			System.out.println(notes+" notes of 100 Rs.");
			
		}
		int leftAmount = amount%100;
		super.process(atmMachine,leftAmount);
	}
	
}
