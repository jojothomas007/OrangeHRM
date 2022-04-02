package com.hrm.utils;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class configUtils {
	private static EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

	public static String getUsername() {
		return variables.getProperty("user.standard.name");
	}

	public static String getUserPassword() {
		return variables.getProperty("user.standard.password");
	}
}
