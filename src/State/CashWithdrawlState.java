package State;

import com.example.atmMachine.ATMCard;
import com.example.atmMachine.ATMMachine;

public class CashWithdrawlState extends ATMStateAbstractClass{
	
	@Override
	public void cashWithdrawlState(ATMMachine atmMachine, ATMCard atmCard, int amount) {
		if(atmMachine.getBalance() < amount) {
			System.out.println("ATM does not have sufficient balance");
			atmMachine.setAtmState(new ExitState());
		}else if(atmCard.getBankAccount().getBalance() < amount){
			System.out.println("Account does not have sufficient balance");
			atmMachine.setAtmState(new ExitState());
		}else {
			atmCard.modifyBalance(atmMachine,atmCard,amount);
			atmMachine.setAtmState(new SelectOptionState());
		} 
	}
}
