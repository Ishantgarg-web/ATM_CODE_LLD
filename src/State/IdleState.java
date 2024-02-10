package State;

import com.example.atmMachine.ATMCard;
import com.example.atmMachine.ATMMachine;
import com.example.atmMachine.ATMState;

public class IdleState extends ATMStateAbstractClass{
	
	@Override
	public void insertCard(ATMMachine atmMachine, ATMCard atmCard) {
		System.out.println("Card is inserted successfully");
		atmMachine.setAtmState(new HasCard());
	}
}
