package com.hrm.entity;

public class Leave {
	String type;
	Float entitlement;
	Float balance;

	public Leave(String type, Float entitlement, Float balance) {
		this.type = type;
		this.entitlement = entitlement;
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float getEntitlement() {
		return entitlement;
	}

	public void setEntitlement(Float entitlement) {
		this.entitlement = entitlement;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

}
