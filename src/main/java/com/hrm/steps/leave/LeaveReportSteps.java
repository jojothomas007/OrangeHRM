package com.hrm.steps.leave;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import com.hrm.entity.Employee;
import com.hrm.entity.Leave;
import com.hrm.page.leave.LeaveReportPage;
import com.hrm.steps.BaseSteps;

import net.thucydides.core.annotations.Step;

public class LeaveReportSteps extends BaseSteps {
	LeaveReportPage leaveReportPage;

	@Step("Fetch report for the employee")
	public void fetchReportForEmployee(Employee employee) {
		leaveReportPage.navigateToPage();
		leaveReportPage.fetchReportForEmployee(employee);
	}

	@Step("Verify Employee Leave Report")
	public void verifyEmployeeLeaveReport(Employee employee) {
		Map<String, Leave> mapLeaves = employee.getLeaves();
		Map<String, Float> expleaveBalances = new HashedMap();
		for (String leaveType : mapLeaves.keySet()) {
			expleaveBalances.put(leaveType, mapLeaves.get(leaveType).getBalance());
		}
		leaveReportPage.navigateToPage();
		leaveReportPage.fetchReportForEmployee(employee);
		mapLeaves = employee.getLeaves();
		Map<String, Float> actualleaveBalances = new HashedMap();
		for (String leaveType : mapLeaves.keySet()) {
			actualleaveBalances.put(leaveType, mapLeaves.get(leaveType).getBalance());
		}
		assertThat(actualleaveBalances).as("Leave Balance").containsAllEntriesOf(expleaveBalances);
		assertThat(actualleaveBalances.keySet()).as("Leave Balance")
				.containsExactlyElementsOf(expleaveBalances.keySet());

	}

}
