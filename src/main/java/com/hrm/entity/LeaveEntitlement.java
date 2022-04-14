package com.hrm.entity;

public class LeaveEntitlement {
	String type;
	Float balance;

	public LeaveEntitlement(String type, Float balance) {
		this.type = type;
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

}
