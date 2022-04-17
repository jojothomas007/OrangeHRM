package com.hrm.datagen;

import com.hrm.entity.Employee;
import com.hrm.entity.User;

public class EmployeeDatagen {
	public Employee createEmployeeWithUser(Employee employee) {
		employee = createEmployeeWithoutUser(employee);
		User user = new User();
		user.setUsername(employee.getFirstName() + employee.getLastName());
		user.setPassword(DatagenUtils.getPassword());
		user.setStatus("Active");
		employee.setUser(user);
		return employee;
	}

	public Employee createEmployeeWithoutUser(Employee employee) {
		employee.setEmpId("");
		String firstname = DatagenUtils.getname().firstName();
		String lastname = DatagenUtils.getname().lastName();
		employee.setFirstName(firstname);
		employee.setLastName(lastname);
		return employee;
	}
}
