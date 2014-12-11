// Thomas Hagen && Aaron Lemmon && Lenny Scott

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ClickingListener implements ActionListener {

	private final int x;
	private final int y;

	public ClickingListener(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		TicTacToeModel.processTurn(x, y);
	}
}
