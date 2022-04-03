package com.hrm.datagen;

import com.hrm.entity.Employee;
import com.hrm.entity.User;

public class EmployeeDatagen {
	public Employee createEmployeeWithUser(Employee employee) {
		employee.setEmpId("");
		String firstname = DatagenUtils.getname().firstName();
		String lastname = DatagenUtils.getname().lastName();
		employee.setFirstName(firstname);
		employee.setLastName(lastname);
		User user = new User();
		user.setUsername(firstname + lastname);
		user.setPassword(firstname + lastname);
		user.setStatus("Active");
		employee.setUser(user);
		return employee;
	}
}
