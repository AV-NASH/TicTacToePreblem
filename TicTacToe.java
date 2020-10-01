package com.cg.tictactoe;

import java.util.Scanner;

/**
 * @author Avinash
 *
 */
public class TicTacToe {

	public static void main(String[] args) {

		System.out.println("Welcome to the tic tac toe problem");

		char[] tictactoeboard = initializeBoard();
		char playerletter=chooseLetter();
		char computerletter;
		if(playerletter=='X') { 
			 computerletter='O';
			}
		else {
			 computerletter='X';
			}
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
		Scanner sc = new Scanner(System.in);
		char playerletter=' ';
		System.out.println("Please choose a letter");
		System.out.println("1. X");
		System.out.println("2. O");
		String str = sc.nextLine();
		char choice=str.charAt(0);

		switch (choice) {
			case 1: {
				playerletter = 'X';
			}
			case 2: {
				playerletter = 'O';
			}
		}
		return playerletter;
	}
}
