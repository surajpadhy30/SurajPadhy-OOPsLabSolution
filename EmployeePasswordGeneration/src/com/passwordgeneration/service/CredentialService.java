package com.passwordgeneration.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.passwordgeneration.model.Employee;

public class CredentialService {

	public String generateEmail(Employee e) {
		return e.getFirstName() + e.getLastName() + "@" + e.getDepartmentName() + ".greatlearning.com";
	}

	public String generatePassword() {

		String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String small = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String special = "!@#$%&";
		String values = caps + small + numbers + special;
		Random random = new Random();
		List<Character> pass = new ArrayList<>(8);
		pass.add(caps.charAt(random.nextInt(caps.length())));
		pass.add(small.charAt(random.nextInt(small.length())));
		pass.add(numbers.charAt(random.nextInt(numbers.length())));
		pass.add(special.charAt(random.nextInt(special.length())));
		for (int i = 4; i < 8; i++) {
			pass.add(values.charAt(random.nextInt(values.length())));
		}
		Collections.shuffle(pass);
		StringBuilder sb = new StringBuilder();
		for (Character c : pass) {
			sb.append(c);
		}
		return sb.toString();
	}

	public void showCredentials(Employee e, String email, String password) {
		System.out.println("Dear " + e.getFirstName() + " your generated credentials are as follows");
		System.out.println("Email ----> " + email);
		System.out.println("Password ----> " + password);

	}

}
