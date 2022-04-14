package com.hrm.steps.leave;

import com.hrm.entity.Employee;
import com.hrm.entity.LeaveEntitlement;
import com.hrm.page.leave.AssignLeavePage;
import com.hrm.steps.BaseSteps;

import net.thucydides.core.annotations.Step;

public class AssignLeaveSteps extends BaseSteps {
	AssignLeavePage assignLeavePage;

	@Step
	public void assignLeaves(Employee employee, String leaveType, int numleaves) {
		assignLeavePage.navigateToPage();
		assignLeavePage.assignLeaves(employee, leaveType, numleaves);
		LeaveEntitlement leaveEntitlement = employee.getLeaves().get(leaveType);
		leaveEntitlement.setBalance(leaveEntitlement.getBalance() - numleaves);
	}

}
