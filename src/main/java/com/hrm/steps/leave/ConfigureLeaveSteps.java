package com.hrm.steps.leave;

import java.util.List;
import java.util.Random;

import com.hrm.page.leave.LeaveTypesPage;
import com.hrm.steps.BaseSteps;

import net.thucydides.core.annotations.Step;

public class ConfigureLeaveSteps extends BaseSteps {
	LeaveTypesPage leaveTypesPage;

	@Step
	public String getRandomLeaveType() {
		leaveTypesPage.navigateToPage();
		List<String> leaveTypes = leaveTypesPage.getLeaveTypes();
		int index = new Random().nextInt(leaveTypes.size());
		return leaveTypes.get(index);
	}

}
