package com.hrm.steps.leave;

import com.hrm.entity.Employee;
import com.hrm.entity.Leave;
import com.hrm.page.leave.AssignLeavePage;
import com.hrm.steps.BaseSteps;

import net.thucydides.core.annotations.Step;

public class AssignLeaveSteps extends BaseSteps {
	AssignLeavePage assignLeavePage;

	@Step("Assign leaves - {1} : {2}")
	public void assignLeaves(Employee employee, String leaveType, int numleaves) {
		assignLeavePage.navigateToPage();
		assignLeavePage.assignRandomLeaves(employee, leaveType, numleaves);
		Leave leave = employee.getLeaves().get(leaveType);
		leave.setBalance(leave.getBalance() - numleaves);
	}

}
