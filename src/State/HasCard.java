package State;

import com.example.atmMachine.ATMCard;
import com.example.atmMachine.ATMMachine;

public class HasCard extends ATMStateAbstractClass{
	
	@Override
	public void authenticateCard(ATMMachine atmMachine, ATMCard atmCard, int pin) {
		if(atmCard.getPin() == pin) {
			System.out.println("Card is authenticated successfully");
			atmMachine.setAtmState(new SelectOptionState());
		}else {
			System.out.println("Card is not authenticated");
			atmMachine.setAtmState(new ExitState());
		}
	}
	
}
