package com.hrm.datagen;

import java.util.Locale;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class DatagenUtils {
	private static Faker faker = new Faker();
	private static Locale locale = new Locale("en-GB");

	public static Address getAddress() {
		return faker.address();
	}

	public static String getEmail() {
		FakeValuesService fakeValuesService = new FakeValuesService(locale, new RandomService());
		return fakeValuesService.bothify("????##@gmail.com");
	}

	public static Name getname() {
		return faker.name();
	}
}
