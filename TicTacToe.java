package com.cg.tictactoe;

import java.util.Scanner;

/**
 * @author Avinash
 *
 */
public class TicTacToe {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Welcome to the tic tac toe problem");

		char[] tictactoeboard = initializeBoard();
		char userchoice = chooseLetter();
		char computerchoice;
		if (userchoice == 'X') {
			computerchoice = 'O';
		} else {
			computerchoice = 'X';
		}
		scanner.close();
	}

	/**
	 * method to create tictactoe board
	 */
	public static char[] initializeBoard() {
		char[] tictactoeboard = new char[10];

		for (int index = 1; index < tictactoeboard.length; index++) {
			tictactoeboard[index] = ' ';
		}

		return tictactoeboard;
	}

	/**
	 * method to allow player to choose letter
	 */
	public static char chooseLetter() {

		char userchoice = ' ';
		System.out.println("Please choose a letter\n" + "1. X\n" + "2. O");
		String str = scanner.nextLine();
		char choice = str.charAt(0);

		switch (Character.toLowerCase(choice)) {
		case 'x': {
			userchoice = 'X';
			break;
		}
		case 'o': {
			userchoice = 'O';
			break;
		}
		default: {
			System.out.println("Enter a valid characteraner");
		}
		}
		return userchoice;
	}
}
