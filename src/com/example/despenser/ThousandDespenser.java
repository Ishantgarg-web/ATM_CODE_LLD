package com.example.despenser;

import com.example.atmMachine.ATMMachine;
import com.example.atmMachine.DenominationCurreny;

public class ThousandDespenser extends Despenser{

	public ThousandDespenser(Despenser despenser) {
		super.nextDespenser(despenser);
	}
	
	public void process(ATMMachine atmMachine,int amount) {
//		System.out.println("Thousand notes: "+atmMachine.getDenominationCurrency().get(DenominationCurreny.THOUSANDS));
		int notes = (int)Math.min(amount/1000, atmMachine.getDenominationCurrency().get(DenominationCurreny.THOUSANDS));
		if(notes!=0) {
			System.out.println(notes+" notes of 1000 Rs.");
		}
		int leftAmount = amount%1000;
		super.process(atmMachine, leftAmount);
	}
	
}
