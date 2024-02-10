package State;

import com.example.atmMachine.ATMCard;
import com.example.atmMachine.ATMMachine;
import com.example.atmMachine.ATMSelectOptionEnum;
import com.example.atmMachine.ATMState;

public class SelectOptionState extends ATMStateAbstractClass{
	
	public SelectOptionState() {
		System.out.println("Please Select options from the following:\n1. Cash Withdrawl\n2. Display balance");
	}
	
	@Override
	public void SelectOptionsState(ATMMachine atmMachine, ATMCard atmCard, ATMSelectOptionEnum atmSelectOptionEnum) {
		if(atmSelectOptionEnum.equals(ATMSelectOptionEnum.CASH_WITHDRAWL)) {
			atmMachine.setAtmState(new CashWithdrawlState());
		}else if(atmSelectOptionEnum.equals(ATMSelectOptionEnum.DISPLAY_BALANCE)) {
			atmMachine.setAtmState(new CheckBalanceState());
		}else {
			System.out.println("incorrect options");
		}
	}
	
}
