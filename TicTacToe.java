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
		int index;
		String turn;
		boolean check = true;
		char[] tictactoeboard = initializeBoard();

		char userchoice = chooseLetter();
		char computerchoice;
		computerchoice = (userchoice == 'X') ? (computerchoice = 'O') : (computerchoice = 'X');
		showBoard(tictactoeboard);
		if (firstPlayCheck().equals(user)) {
			System.out.println("user plays first");
			turn = user;
		} else {
			System.out.println("computer plays first");
			turn = computer;
		}
		do {
			if (turn.equals(user)) {
				index = selectIndex(tictactoeboard);
				moveBoard(index, tictactoeboard, userchoice);
				showBoard(tictactoeboard);
				check = checkWinAndTie(tictactoeboard, userchoice);
				turn = computer;
			} else {
				index = computerTurn(tictactoeboard, computerchoice, userchoice);
				moveBoard(index, tictactoeboard, computerchoice);
				showBoard(tictactoeboard);
				check = checkWinAndTie(tictactoeboard, computerchoice);
				turn = user;
			}
		} while (!check);

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
		return tictactoeboard;
	}

	private static String firstPlayCheck() {
		int toss = (int) (Math.random() * 10) % 2;
		return (toss == 0) ? (user) : (computer);
	}

	private static boolean checkWinAndTie(char[] b, char letter) {
		boolean check;
		if ((b[1] == letter && b[2] == letter && b[3] == letter) || (b[4] == letter && b[5] == letter && b[6] == letter)
				|| (b[7] == letter && b[8] == letter && b[9] == letter)
				|| (b[1] == letter && b[4] == letter && b[7] == letter)
				|| (b[2] == letter && b[5] == letter && b[8] == letter)
				|| (b[3] == letter && b[6] == letter && b[9] == letter)
				|| (b[1] == letter && b[5] == letter && b[9] == letter)
				|| (b[3] == letter && b[5] == letter && b[7] == letter)) {
			check = true;
		} else {
			int valid = 0;
			for (int index = 1; index < b.length; index++) {
				if (b[index] == ' ')
					valid++;
			}
			check = (valid == 9) ? (true) : (false);

		}
		return check;
	}

	private static int computerTurn(char[] tictactoeboard, char computerchoice, char userchoice) {
		int index = 0;
		index = checkWinningMove(tictactoeboard, computerchoice);
		if (index == 0)
			index = checkWinningMove(tictactoeboard, userchoice);
		return index;
	}

	private static int checkWinningMove(char[] tictactoeboard, char letter) {
		int index;
		index = checkWinningLine(1, 2, 3, tictactoeboard, letter);
		if (index == 0)
			index = checkWinningLine(4, 5, 6, tictactoeboard, letter);
		if (index == 0)
			index = checkWinningLine(7, 8, 9, tictactoeboard, letter);
		if (index == 0)
			index = checkWinningLine(1, 4, 7, tictactoeboard, letter);
		if (index == 0)
			index = checkWinningLine(2, 5, 6, tictactoeboard, letter);
		if (index == 0)
			index = checkWinningLine(3, 6, 9, tictactoeboard, letter);
		if (index == 0)
			index = checkWinningLine(1, 5, 9, tictactoeboard, letter);
		if (index == 0)
			index = checkWinningLine(3, 5, 7, tictactoeboard, letter);
		return index;
	}

	private static int checkWinningLine(int i1, int i2, int i3, char[] b, char letter) {
		int index = 0;
		if ((b[i1] == letter && b[i2] == letter) || (b[i2] == letter && b[i3] == letter)
				|| (b[i1] == letter && b[i3] == letter)) {

			if ((b[i1] == ' ') || (b[i2] == ' ') || (b[i3] == ' ')) {
				if ((b[i1] == ' '))
					index = i1;
				if ((b[i2] == ' '))
					index = i2;
				if ((b[i3] == ' '))
					index = i3;
			}

		}
		return index;
	}

}
