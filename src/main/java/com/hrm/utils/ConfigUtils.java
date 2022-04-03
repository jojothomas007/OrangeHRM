package com.hrm.utils;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class ConfigUtils {
	private static EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

	public static String getEssUsername() {
		return variables.getProperty("user.ess.name");
	}

	public static String getEssUserPassword() {
		return variables.getProperty("user.ess.password");
	}

	public static String getAdminUsername() {
		return variables.getProperty("user.admin.name");
	}

	public static String getAdminUserPassword() {
		return variables.getProperty("user.admin.password");
	}
}
