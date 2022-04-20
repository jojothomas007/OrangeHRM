package com.hrm.datagen;

import com.hrm.entity.Employee;
import com.hrm.entity.User;
import com.hrm.enums.UserRole;

public class UserDatagen {
	public Employee addUser(Employee employee) {
		User user = new User();
		user.setUserRole(UserRole.ESS);
		user.setUsername(employee.getFirstName() + employee.getLastName());
		user.setPassword(DatagenUtils.getPassword());
		user.setStatus("Active");
		employee.setUser(user);
		return employee;
	}

}
