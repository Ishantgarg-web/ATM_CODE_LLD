package com.example.atmMachine;

/**
 * 
 * @author ishant
 * Here, we will descibe each new screen a state.
 */

public enum ATMState {
	IDLE,
	HAS_CARD,
	MAINTAINANCE,
	SELECT_OPTION_STATE,
	WITHDRAW_STATE,
	BALANCE_ENQUIRY,
	EXIT
}
