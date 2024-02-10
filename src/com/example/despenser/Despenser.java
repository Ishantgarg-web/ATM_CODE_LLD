package com.example.despenser;

import com.example.atmMachine.ATMMachine;

public abstract class Despenser {
	
	private Despenser nextDespenser;
	
	private boolean ableToDespense;
	
//	private ATMMachine atmMachine;
	
	public boolean isAbleToDespense() {
		return ableToDespense;
	}
	
	public void nextDespenser(Despenser nextDespenser) {
		this.nextDespenser = nextDespenser;
	}
	
	public void process(ATMMachine atmMachine,int amount) {
		if(nextDespenser!=null) {
			this.nextDespenser.process(atmMachine,amount);
		}else {
			if(amount!=0) {
				this.ableToDespense = false;
				System.out.println("We can not process the given amount");
			}else {
				System.out.println("update ableToDespense");
				atmMachine.setMoneyAbleToDespense(true);
				this.ableToDespense = true;
			}
		}
	}
}
