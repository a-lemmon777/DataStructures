// Thomas Hagen && Aaron Lemmon && Lenny Scott

import java.util.Random;

import javax.swing.JButton;

public class TicTacToeModel {

	private static final String HUMAN_ICON = "\\(^-^)/";
	private static final String COMPUTER_ICON = ">[*~*]<";
	private static String[][] modelBoard = new String[3][3];
	private static int countOfMoves = 0;
	public static TicTacToeFrame view;

	public static void processTurn(int x, int y) {
		doHumanTurn(x, y);
		if (!checkIfDone(x, y)) {
			doComputerTurn();
		}
	}

	private static boolean checkIfDone(int x, int y) {
		boolean gameWon = columnWin(x) || rowWin(y) || diagonalWin();
		boolean isDone = gameWon || (countOfMoves > 8);
		if (isDone) {
			if (gameWon && modelBoard[x][y] == HUMAN_ICON) {
				view.displayResult(0); // 0 means human won
			} else if (gameWon && modelBoard[x][y] == COMPUTER_ICON){
				view.displayResult(1); // 1 means computer won
			} else {
				view.displayResult(2); // 2 means it was a draw
			}
		}
		return isDone;
	}

	private static boolean diagonalWin() {
		boolean negativeSlopeWin = (modelBoard[0][0] == modelBoard[1][1]) && (modelBoard[1][1] == modelBoard[2][2]);
		boolean positiveSlopeWin = (modelBoard[0][2] == modelBoard[1][1]) && (modelBoard[1][1] == modelBoard[2][0]);
		return (negativeSlopeWin || positiveSlopeWin) && (modelBoard[1][1] != null);
	}

	private static boolean rowWin(int y) {
		// TODO Auto-generated method stub
		return (modelBoard[0][y] == modelBoard[1][y]) && (modelBoard[1][y] == modelBoard[2][y]);
	}

	private static boolean columnWin(int x) {
		return (modelBoard[x][0] == modelBoard[x][1]) && (modelBoard[x][1] == modelBoard[x][2]);
	}

	private static void doComputerTurn() {
		Random random = new Random();
		int computerX;
		int computerY;
		do {
			computerX = random.nextInt(3);
			computerY = random.nextInt(3);

		} while (modelBoard[computerX][computerY] != null);
		markBoard(computerX, computerY, COMPUTER_ICON);

		checkIfDone(computerX, computerY);
	}

	private static void doHumanTurn(int x, int y) {
		markBoard(x, y, HUMAN_ICON); 
		//checkWin(x, y);
	}

	private static void markBoard(int x, int y, String c) {
		modelBoard[x][y] = c;
		view.updateButtonText(x, y, c, c == null); // Disables button if we're adding text to button.
		countOfMoves++;
	}

	public static void reset() {
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				markBoard(x, y, null);
			}
		}
		countOfMoves = 0;
	}
}
