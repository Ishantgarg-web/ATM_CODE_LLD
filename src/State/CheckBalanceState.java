package State;

import com.example.atmMachine.ATMCard;
import com.example.atmMachine.ATMMachine;

public class CheckBalanceState extends ATMStateAbstractClass{
	
	@Override
	public void checkBalanceState(ATMMachine atmMachine, ATMCard atmCard) {
		System.out.println("balance is: "+atmCard.getBankAccount().getBalance());
		atmMachine.setAtmState(new ExitState());
	}
}
