package com.coderscampus.objects;

import java.util.Random;
import java.util.Scanner;

public class Guess {

	// String
	String guessNumber() {

		Random random = new Random();
		int theRandomNumber;
		int numChancesLeft = 5;
		Scanner scanner = new Scanner(System.in);

		theRandomNumber = 1 + random.nextInt(100);
		System.out.println("The random number is " + theRandomNumber);

		while (numChancesLeft >= 1) {
			System.out.println("Pick a number between 1 and 100");
			String initialNumRequest = scanner.nextLine();
			Integer convertedInitialNumRequest = Integer.parseInt(initialNumRequest);

			if (convertedInitialNumRequest == theRandomNumber) {
				scanner.close();
				return "You win!";
			} else if (numChancesLeft == 1) {
				scanner.close();
				return "You loose, the number to guess was " + theRandomNumber;
			} else if (convertedInitialNumRequest < 1 || convertedInitialNumRequest > 100) {
				System.out.println("Your guess is not between 1 and 100, please try again");
			} else if (convertedInitialNumRequest < theRandomNumber) {
				numChancesLeft = numChancesLeft - 1;
				System.out.println("Please pick a higher number");
			} else if (convertedInitialNumRequest > theRandomNumber) {
				numChancesLeft = numChancesLeft - 1;
				System.out.println("Please pick a lower number");
			}
		}
		scanner.close();
		return "Application has terminated. Have a wonderful day :)";
	}

}
