package State;

import com.example.atmMachine.ATMCard;
import com.example.atmMachine.ATMMachine;

public class ExitState extends ATMStateAbstractClass{
	
	@Override
	public void ejectCard(ATMMachine atmMachine, ATMCard atmCard) {
		System.out.println("Card is ejected successfully");
		atmMachine.setAtmState(new IdleState());
	}
	
}
