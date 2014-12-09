// Thomas Hagen && Aaron Lemmon && Lenny Scott

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class TicTacToeFrame extends JFrame {
	private JButton[][] gameBoard;

	public TicTacToeFrame() {
		// Making JFrame
		//JFrame frame = new JFrame();
		setSize(600, 600);
		setTitle("TicTacToe (Lemmon, Lenny, and Thomas)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		// Making JPanel
		JPanel panel = (JPanel) getContentPane();
		GridLayout grid = new GridLayout(3, 3);
		panel.setLayout(grid);
		
		gameBoard = new JButton[3][3];
		
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				JButton newButton = new JButton("");
				gameBoard[x][y] = newButton;
				newButton.addActionListener(new ClickingListener(x, y));
				panel.add(newButton);
			}
		}
		
		
//		panel.add(gameBoard[0][0]);
//		panel.add(gameBoard[1][0]);
//		panel.add(gameBoard[2][0]);
//		panel.add(gameBoard[0][1]);
//		panel.add(gameBoard[1][1]);
//		panel.add(gameBoard[2][1]);
//		panel.add(gameBoard[0][2]);
//		panel.add(gameBoard[1][2]);
//		panel.add(gameBoard[2][2]);
	}

	public void updateButtonText(int x, int y, String buttonText, boolean buttonEnabled) {
		JButton button = gameBoard[x][y];
		button.setText(buttonText);
		button.setEnabled(buttonEnabled);
//		TicTacToeModel.delay(500);
	}

	public void displayResult(int i) {
		String message = "";
		if (i == 0) {
			message = "You won!";
		} else if (i == 1) {
			message = "The computer beat you...you moron!";
		} else {
			message = "Draw!";
		}
		message += "\nWould you like to play again?";
		int choice = JOptionPane.showConfirmDialog(this, message, "", JOptionPane.YES_NO_OPTION);
		if (choice == 0) { // Play another game
			TicTacToeModel.reset();
		} else { // Exit program
			System.exit(0);
		}
	}
	
	
}
