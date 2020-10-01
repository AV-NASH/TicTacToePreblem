package com.cg.tictactoe;

import java.util.Scanner;

/**
 * @author Avinash
 *
 */
public class TicTacToe {

	static Scanner scanner = new Scanner(System.in);
	private static String user = "user";
	private static String computer = "computer";

	public static void main(String[] args) {

		System.out.println("Welcome to the tic tac toe problem");

		char[] tictactoeboard = initializeBoard();
		int index;
		char userchoice = chooseLetter();
		char computerchoice;
		computerchoice = (userchoice == 'X') ? (computerchoice = 'O') : (computerchoice = 'X');
		showBoard(tictactoeboard);
		if(firstPlayCheck().equals(user)) System.out.println("user plays first");
		else System.out.println("computer plays first");
		index = selectIndex(tictactoeboard);
		moveBoard(index, tictactoeboard, userchoice);
		index = selectIndex(tictactoeboard);
		moveBoard(index, tictactoeboard, userchoice);
		
		scanner.close();
	}

	/**
	 * method to create tictactoe board
	 */
	private static char[] initializeBoard() {
		char[] tictactoeboard = new char[10];

		for (int index = 1; index < tictactoeboard.length; index++) {
			tictactoeboard[index] = ' ';
		}

		return tictactoeboard;
	}

	/**
	 * Method for showing board
	 */
	private static void showBoard(char[] tictactoeboard) {
		{
			System.out.println(
					tictactoeboard[1] + " | " + tictactoeboard[2] + " | " + tictactoeboard[3] + "\n-----------");
			System.out.println(
					tictactoeboard[4] + " | " + tictactoeboard[5] + " | " + tictactoeboard[6] + "\n-----------");
			System.out.println(
					tictactoeboard[7] + " | " + tictactoeboard[8] + " | " + tictactoeboard[9] + "\n-----------");
		}
	}

	/**
	 * method to allow player to choose letter
	 */
	private static char chooseLetter() {

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

	/**
	 * Method for taking index from user
	 */
	private static int selectIndex(char[] tictactoeboard) {
		int index;
		int valid = 0;
		do {
			System.out.println("Please select index from positions 1-9");
			index = scanner.nextInt();
			if ((index < 1 || index > 9)) {
				System.out.println("invalid index");

			} else {
				if (!(tictactoeboard[index] == ' '))
					System.out.println("this index is not free please select a valid one");

				else
					break;
			}

		} while (true);

		return index;
	}

	private static char[] moveBoard(int index, char[] tictactoeboard, char letter) {
		tictactoeboard[index] = letter;
		showBoard(tictactoeboard);
		return tictactoeboard;
	}

	private static String firstPlayCheck() {
		int toss = (int) (Math.random() * 10) % 2;
		return (toss == 0) ? (user) : (computer);
	}

}
