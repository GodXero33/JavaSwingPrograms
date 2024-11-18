import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class TicTacToeBtn extends JButton {
	private final static Color background1 = new Color(0, 0, 0);
	private final static Color background2 = new Color(0, 250, 0);
	private final static Color background3 = new Color(0, 0, 250);
	private final static Color background4 = new Color(250, 0, 20);
	private final static Color background5 = new Color(250, 0, 250);
	private final static Color text = new Color(255, 255, 255);
	private final static Font font = new Font("", 1, 20);
	private final static Dimension size = new Dimension(100, 100);

	private final int cellX;
	private final int cellY;
	private int labelValue;

	TicTacToeBtn (int x, int y) {
		this.cellX = x;
		this.cellY = y;

		this.setBackground(TicTacToeBtn.background1);
		this.setForeground(TicTacToeBtn.text);
		this.setFont(TicTacToeBtn.font);
		this.setPreferredSize(TicTacToeBtn.size);
	}

	public void setLabelValue (int labelValue) {
		if (labelValue < 0 || labelValue > 2) return;

		this.labelValue = labelValue;
		this.setText(labelValue == 0 ? "" : labelValue == 1 ? "X" : "O");
		this.setBackground(labelValue == 0 ? TicTacToeBtn.background1 : labelValue == 1 ? TicTacToeBtn.background2 : TicTacToeBtn.background3);
	}

	
	public int getLabelValue () {
		return this.labelValue;
	}

	public void setCrossed (int player) {
		if (player == 1) {
			this.setBackground(TicTacToeBtn.background4);
		} else {
			this.setBackground(TicTacToeBtn.background5);
		}
	}

	public int getCellX () {
		return this.cellX;
	}

	public int getCellY () {
		return this.cellY;
	}
}
