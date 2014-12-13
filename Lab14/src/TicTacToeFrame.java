// Thomas Hagen && Aaron Lemmon && Lenny Scott

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicTacToeFrame extends JFrame {
	private JButton[][] gameBoard;
	public JPanel panel;

	public TicTacToeFrame() {
		// Making JFrame
		//JFrame frame = new JFrame();
		setSize(600, 600);
		setTitle("TicTacToe (Lemmon, Lenny, and Thomas)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//Making the panel here!
		panel = (JPanel) getContentPane();
		
		GridLayout grid = new GridLayout(3, 3);
		panel.setLayout(grid);
		gameBoard = new JButton[3][3];
		
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				JButton newButton = new JButton("");
				newButton.setFont(new Font("Arial", Font.BOLD, 32));
				newButton.setBackground(new Color(100, 100, 100)); // Charcoal
				gameBoard[x][y] = newButton;
				newButton.addActionListener(new ClickingListener(x, y));
				panel.add(newButton);
			}
		}
		// This was needed to display the components in the frame on other machines (other than Falcon) for some reason
		setContentPane(panel);
	}

	public void updateButtonText(int x, int y, String buttonText, boolean buttonEnabled) {
		JButton button = gameBoard[x][y];
		button.setText(buttonText);
		button.setEnabled(buttonEnabled);
		if(!buttonEnabled) {
			button.setBackground(new Color(255, 150, 180)); // Pink
		} else {
			button.setBackground(new Color(100, 100, 100)); // Charcoal
		}
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
