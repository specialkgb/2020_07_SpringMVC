package com.biz.read.exec;

import java.util.Map;
import java.util.Scanner;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class SecurityTest {

	public static void main(String[] args) {

		StandardPBEStringEncryptor pbe = new StandardPBEStringEncryptor();
		Scanner scan = new Scanner(System.in);
		
		Map<String, String> envList = System.getenv();

		System.out.println("문자열 >> ");
		String planText = scan.nextLine();

		pbe.setAlgorithm("PBEWithMD5AndDES");

		pbe.setPassword(envList.get("BIZ.NET"));

		for (int i = 0; i < 10; i++) {
			String encText = pbe.encrypt(planText);
			System.out.printf("P :%s, E : %s\t", planText, encText);

			String dencText = pbe.decrypt(encText);
			System.out.printf("E :%s, P : %s\n", dencText, planText);
		}
	}

}
