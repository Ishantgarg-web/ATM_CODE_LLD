package State;

import com.example.atmMachine.ATMCard;
import com.example.atmMachine.ATMMachine;
import com.example.atmMachine.ATMSelectOptionEnum;
import com.example.atmMachine.ATMState;

public abstract class ATMStateAbstractClass {
	
	public void insertCard(ATMMachine atmMachine, ATMCard atmCard) {
		System.out.println("its not allowed");
	}
	
	public void authenticateCard(ATMMachine atmMachine, ATMCard atmCard, int pin) {
		System.out.println("its not allowed");
	}
	
	public void maintainceState(ATMMachine atmMachine, ATMCard atmCard) {
		System.out.println("its not allowed");
	}
	
	public void SelectOptionsState(ATMMachine atmMachine, ATMCard atmCard, ATMSelectOptionEnum atmSelectOptionEnum) {
		System.out.println("its not allowed");
	}
	
	public void cashWithdrawlState(ATMMachine atmMachine, ATMCard atmCard, int amount) {
		System.out.println("its not allowed");
	}
	
	public void checkBalanceState(ATMMachine atmMachine, ATMCard atmCard) {
		System.out.println("its not allowed");
	}
	
	public void ejectCard(ATMMachine atmMachine, ATMCard atmCard) {
		System.out.println("its not allowed");
	}
}
