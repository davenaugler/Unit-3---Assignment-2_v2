package com.coderscampus.objects;

import java.util.Random;
import java.util.Scanner;

public class Guess {

	String guessNumber() {

		Random random = new Random();
		int randomNumber = 1 + random.nextInt(100);
		int numChancesLeft = 5;
		Scanner scanner = new Scanner(System.in);

//		Line below is for testing purposes on identifying that the correct random number is/was being chosen.
//		System.out.println("The random number is " + randomNumber);

		while (numChancesLeft >= 1) {
			System.out.println("Pick a number between 1 and 100");
			String initialNumRequest = scanner.nextLine();

			// userGets or // getsNumber | variable was named "convertedInitialNumRequest"
			Integer getsNumber = Integer.parseInt(initialNumRequest);

			// in-valid inputs
			if (getsNumber < 1 || getsNumber > 100) {
				System.out.println("Your guess is not between 1 and 100, please try again");
				continue;
			} else {
				// valid inputs
				// if guess is correct, do this
				if (getsNumber == randomNumber) {
					scanner.close();
					return "You win!";
				} else if (numChancesLeft > 1) {
					// if guess is incorrect, do this
					if (getsNumber < randomNumber) {
						System.out.println("Please pick a higher number");
					} else if (getsNumber > randomNumber) {
						System.out.println("Please pick a lower number");
					}
				}
				numChancesLeft--;

				if (numChancesLeft == 0) {
					scanner.close();
					return "You loose, the number to guess was " + randomNumber;
				}
			}
		}
		scanner.close();
		return "Application has terminated. Have a wonderful day :)";
	}
}