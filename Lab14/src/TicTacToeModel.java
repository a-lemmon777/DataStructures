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
		//delay(500);
		if (!checkIfDone(x, y)) {
			doComputerTurn();
		}
	}

	public static void delay(int i) {
		long startTime = System.currentTimeMillis();
		while (System.currentTimeMillis() < startTime + i) {
			// just wait around
		}
	}

	private static boolean checkIfDone(int x, int y) {
		boolean isDone = columnWin(x) || rowWin(y) || diagonalWin() || (countOfMoves > 8);
		if (isDone) {
			if (countOfMoves > 8) {
				view.displayResult(2); // 2 means it was a draw
			} else if (modelBoard[x][y] == HUMAN_ICON) {
				view.displayResult(0); // 0 means human won
			} else if (modelBoard[x][y] == COMPUTER_ICON){
				view.displayResult(1); // 1 means computer won
			} else {
				System.out.println("Something went wrong.");
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
