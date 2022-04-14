package com.hrm.steps.leave;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.Random;

import org.apache.commons.collections.map.HashedMap;

import com.hrm.entity.Employee;
import com.hrm.entity.LeaveEntitlement;
import com.hrm.page.admin.AddUserPage;
import com.hrm.page.admin.SystemUsersPage;
import com.hrm.page.leave.AddLeaveEntitlementPage;
import com.hrm.page.leave.EmployeeEntitlementsPage;
import com.hrm.page.pim.EmployeeListPage;
import com.hrm.steps.BaseSteps;

import net.thucydides.core.annotations.Step;

public class LeaveEntitlementSteps extends BaseSteps {
	SystemUsersPage systemUsersPage;
	AddUserPage addUserPage;
	EmployeeListPage employeeListPage;
	AddLeaveEntitlementPage addLeaveEntitlementPage;
	EmployeeEntitlementsPage employeeEntitlementsPage;

	@Step("Fetch the Employee Leave entitlement")
	public void fetchTheEmployeeLeaveEntitlement(Employee employee) {
		employeeEntitlementsPage.navigateToPage();
		employeeEntitlementsPage.getLeaveEntitlements(employee);
	}

	@Step("Add leave Entitlement for Employee {1} {2}")
	public void addEntitlement(Employee employee, String leaveType, float numleaves) {
		addLeaveEntitlementPage.navigateToPage();
		addLeaveEntitlementPage.addLeaves(employee, leaveType, numleaves);
		employeeEntitlementsPage.shouldBeDisplayed();
		LeaveEntitlement leaveEntitlement;
		if (employee.getLeaves().containsKey(leaveType)) {
			leaveEntitlement = employee.getLeaves().get(leaveType);
			leaveEntitlement.setBalance(leaveEntitlement.getBalance() + numleaves);
		} else {
			leaveEntitlement = new LeaveEntitlement(leaveType, numleaves);
		}
		employee.getLeaves().put(leaveType, leaveEntitlement);
	}

	@Step("Verify Employee Leave Entitlement")
	public void verifyEmployeeLeaveEntitlement(Employee employee) {
		Map<String, LeaveEntitlement> mapLeaveEntitlement = employee.getLeaves();
		Map<String, Float> expleaveEntitlements = new HashedMap();
		for (String leaveType : mapLeaveEntitlement.keySet()) {
			expleaveEntitlements.put(leaveType, mapLeaveEntitlement.get(leaveType).getBalance());
		}
		employeeEntitlementsPage.navigateToPage();
		mapLeaveEntitlement = employeeEntitlementsPage.getLeaveEntitlements(employee);
		Map<String, Float> actualleaveEntitlements = new HashedMap();
		for (String leaveType : mapLeaveEntitlement.keySet()) {
			actualleaveEntitlements.put(leaveType, mapLeaveEntitlement.get(leaveType).getBalance());
		}
		assertThat(actualleaveEntitlements).as("Leave Entitlement").containsAllEntriesOf(expleaveEntitlements);
		assertThat(actualleaveEntitlements.keySet()).as("Leave Entitlement")
				.containsExactlyElementsOf(expleaveEntitlements.keySet());

	}

	@Step
	public LeaveEntitlement getRandomLeaveEntitlement(Employee employee) {
		Map<String, LeaveEntitlement> leaves = employee.getLeaves();
		int num = new Random().nextInt(leaves.size());
		LeaveEntitlement aLeaveEntitlement = (LeaveEntitlement) leaves.values().toArray()[num];
		return aLeaveEntitlement;

	}

}
