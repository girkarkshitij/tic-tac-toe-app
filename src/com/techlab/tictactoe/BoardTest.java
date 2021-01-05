package com.techlab.tictactoe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardTest {
	@Test
	void testInsertion() throws CellIsAlreadyFilled {
		Mark[][] expectedArray = { { Mark.X, Mark.NULL, Mark.NULL }, { Mark.NULL, Mark.O, Mark.NULL },
				{ Mark.NULL, Mark.NULL, Mark.NULL } };
		Board board = new Board();
		board.insert(0, 0, Mark.X);
		board.insert(1, 1, Mark.O);
		Mark[][] arr = board.getBoard();

		for (int i = 0; i < expectedArray.length; i++) {
			for (int j = 0; j < expectedArray[i].length; j++)
				assertEquals(expectedArray[i][j], arr[i][j]);
		}
	}

}
