package com.techlab.tictactoe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ResultAnalyserTest {
	@Test
	void testRowResult() {
		Result expectedResult = Result.WIN;
		Mark[][] inputBoard = { { Mark.X, Mark.X, Mark.X }, { Mark.NULL, Mark.NULL, Mark.NULL },
				{ Mark.NULL, Mark.NULL, Mark.NULL } };
		Result result = ResultAnalyser.currentResult(inputBoard);
		assertEquals(expectedResult, result);
	}
	
	@Test
	void testColumnResult() {
		Result expectedResult = Result.WIN;
		Mark[][] inputBoard = { { Mark.X, Mark.NULL, Mark.NULL }, { Mark.X, Mark.NULL, Mark.NULL },
				{ Mark.X, Mark.NULL, Mark.NULL } };
		Result result = ResultAnalyser.currentResult(inputBoard);
		assertEquals(expectedResult, result);
	}

	@Test
	void testDiagonalResult() {
		Result expectedResult = Result.WIN;
		Mark[][] inputBoard = { { Mark.X, Mark.NULL, Mark.NULL }, { Mark.NULL, Mark.X, Mark.NULL },
				{ Mark.NULL, Mark.NULL, Mark.X } };
		Result result = ResultAnalyser.currentResult(inputBoard);
		assertEquals(expectedResult, result);
	}
	
	@Test
	void testDrawResult() {
		Result expectedResult = Result.DRAW;
		Mark[][] inputBoard = { { Mark.X, Mark.O, Mark.X }, { Mark.O, Mark.X, Mark.X },
				{ Mark.O, Mark.X, Mark.O } };
		Result result = ResultAnalyser.currentResult(inputBoard);
		assertEquals(expectedResult, result);
	}
}
