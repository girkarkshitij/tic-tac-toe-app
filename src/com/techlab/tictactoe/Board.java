package com.techlab.tictactoe;

import java.util.Scanner;

public class Board {
	private final Scanner sc = new Scanner(System.in);
	private static final int ROWS = 3;
	private static final int COLS = 3;
	public Mark[][] board;

	public Board() {
		board = new Mark[ROWS][COLS];
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				board[i][j] = Mark.NULL;
			}
		}
	}

	public void insert(int rowPos, int colPos, Mark mark) throws CellIsAlreadyFilled {
		if (board[rowPos][colPos] == Mark.NULL)
			board[rowPos][colPos] = mark;
		else
			throw new CellIsAlreadyFilled("Cell is already filled.");
	}

	public void printBoard() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				System.out.print(board[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	public Mark[][] getBoard() {
		return board;
	}

	public void startGame() {
		int counter = 0;
		Mark currentPlayer;
		printBoard();

		while (true) {
			if (counter % 2 == 0)
				currentPlayer = Mark.X;
			else
				currentPlayer = Mark.O;

			System.out.print("Enter Player Name: ");
			String playerName = sc.nextLine();

			while (true) {
				try {
					System.out.print(playerName + " Enter row[1-3] and column[1-3]");
					String[] input = sc.nextLine().split(" ");
					int row = Integer.parseInt(input[0]) - 1;
					int col = Integer.parseInt(input[1]) - 1;
					insert(row, col, currentPlayer);
					break;
				} catch (CellIsAlreadyFilled e) {
					System.err.println("This cell is already filled.");
				} catch (ArrayIndexOutOfBoundsException e) {
					System.err.println("Invalid input.");
				} catch (NumberFormatException e) {
					System.err.println("Invalid input.");
				}
			}

			printBoard();
			Result currentResult = ResultAnalyser.currentResult(board);

			if (currentResult == Result.WIN) {
				System.out.println(playerName + " has won!");
				break;
			} else if (currentResult == Result.DRAW) {
				System.out.println("It's a draw!");
				break;
			}
			counter++;
		}
		sc.close();

	}
}
