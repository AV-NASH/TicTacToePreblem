package com.cg.tictactoe;

public class TicTacToe {

	public static void main(String[] args) {

		System.out.println("Welcome to the tic tac toe problem");
		
		char[] tictactoeboard = initializeBoard();
		
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
}
