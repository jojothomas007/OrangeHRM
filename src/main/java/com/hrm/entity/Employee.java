package com.hrm.entity;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

public class Employee {
	String firstName;
	String lastName;
	String empId;
	User user;
	Map<String, Leave> leaves = new HashedMap();

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Map<String, Leave> getLeaves() {
		return leaves;
	}

	public void setLeaves(Map<String, Leave> leaves) {
		this.leaves = leaves;
	}

}
