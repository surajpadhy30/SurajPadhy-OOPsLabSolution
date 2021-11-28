package com.passwordgeneration.main;

import java.util.Scanner;

import com.passwordgeneration.model.Employee;
import com.passwordgeneration.service.CredentialService;

public class Driver {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your First name");
		String firstName = sc.next();
		System.out.println("Enter your Last name");
		String lastName = sc.next();

		String departmentName = getDepartmentName(sc);
		String email = null;
		String password = null;

		Employee e = new Employee(firstName, lastName, departmentName);
		CredentialService credentialService = new CredentialService();

		email = credentialService.generateEmail(e);
		password = credentialService.generatePassword();
		credentialService.showCredentials(e, email, password);

	}

	private static String getDepartmentName(Scanner sc) {
		System.out.println("Please enter the Department from the following:");
		System.out.println("1.Technical");
		System.out.println("2.Admin");
		System.out.println("3.Human Resource");
		System.out.println("4.Legal");
		int departOption = sc.nextInt();
		if (departOption == 1) {
			return "Technical";
		} else if (departOption == 2) {
			return "Admin";
		} else if (departOption == 3) {
			return "Human Resource";
		} else if (departOption == 4) {
			return "Legal";
		} else {
			System.out.println("Please enter correct Department option");
			return getDepartmentName(sc);
		}
	}

}
