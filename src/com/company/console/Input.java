package com.jfdeveloper.ui;

import java.util.Scanner;

public class Input {

	
	private static Scanner input=new Scanner(System.in);
	
	public static String inputStringText(String string) {
		System.out.print(string);
		return input.next();
	}
	public static int inputNumberText(String string) {
		System.out.print(string);
		return input.nextInt();
	}
	public static String inputString() {
		return input.next();
	}

	public static int inputNumber() {
		return input.nextInt();
	}
	
	    public static int getInt(String prompt, int min, int max, String errorMsg) {
        int option = min - 1;
        do {
            System.out.println(prompt);
            String input = scanner.nextLine();
            try{
                option = Integer.parseInt(input);
            } catch (NumberFormatException err) {
                System.out.println(errorMsg);
            }
        } while (option < min || option > max);
        return option;
    }

	
}
