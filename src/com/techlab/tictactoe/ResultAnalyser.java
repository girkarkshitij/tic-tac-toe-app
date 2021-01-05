package com.techlab.tictactoe;

public class ResultAnalyser {
	public static Result currentResult(Mark[][] inputBoard) {
		Mark[][] board = inputBoard;
		if (rowsResult(board) || columnsResult(board) || diagonalsResult(board))
			return Result.WIN;
		for (Mark[] arr : board) {
			for (Mark mark : arr) {
				if (mark == Mark.NULL)
					return Result.IN_PROGRESS;
			}
		}
		return Result.DRAW;
	}

	public static boolean rowsResult(Mark[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2] && arr[i][0] != Mark.NULL)
				return true;
		}
		return false;
	}

	public static boolean columnsResult(Mark[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i] && arr[0][i] != Mark.NULL)
				return true;
		}
		return false;
	}

	public static boolean diagonalsResult(Mark[][] arr) {
		if (arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2] && arr[0][0] != Mark.NULL)
			return true;
		else if (arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0] && arr[0][2] != Mark.NULL)
			return true;
		return false;
	}
}
