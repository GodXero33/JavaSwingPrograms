import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToe extends JFrame {
	private TicTacToeBtn[][] btns;
	private int[][] grid;
	private int player;

	{
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(new Color(200, 200, 200));
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(3, 3, 2, 2));
		this.setTitle("Tic Tac Toe");

		this.player = 1;
		this.grid = new int[3][3];
		this.btns = new TicTacToeBtn[3][3];

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				TicTacToeBtn btn = new TicTacToeBtn(x, y);
				this.btns[y][x] = btn;
				this.add(btn);
			}
		}

		this.pack();
	}

	TicTacToe () {
		this.addClickEvents();
	}

	private void click (TicTacToeBtn btn) {
		if (btn.getLabelValue() != 0) return;

		btn.setLabelValue(this.player);
		this.grid[btn.getCellY()][btn.getCellX()] = this.player;
		this.update();
		this.player = this.player == 1 ? 2 : 1;
	}

	private void addClickEvents () {
		TicTacToe thisGameWindow = this;

		for (TicTacToeBtn[] btnRow : this.btns) {
			for (TicTacToeBtn btn : btnRow) {
				btn.addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent event) {
						thisGameWindow.click(btn);
					}
				});
			}
		}
	}

	private int[] getCheckedLine () {
		int diagonalTopLeftMarks = 0;
		int diagonalTopRightMarks = 0;

		for (int i = 0; i < 3; i++) {
			int rowPlayerMarks = 0;
			int columnPlayerMarks = 0;

			for (int j = 0; j < 3; j++) {
				if (this.grid[i][j] == this.player) rowPlayerMarks++;
				if (rowPlayerMarks == 3) return new int[] { 0, i };
				if (this.grid[j][i] == this.player) columnPlayerMarks++;
				if (columnPlayerMarks == 3) return new int[] { 1, i };
			}

			if (this.grid[i][i] == this.player) diagonalTopLeftMarks++;
			if (diagonalTopLeftMarks == 3) return new int[] { 2 };
			if (this.grid[i][2 - i] == this.player) diagonalTopRightMarks++;
			if (diagonalTopRightMarks == 3) return new int[] { 3 };
		}

		return null;
	}

	private void reset () {
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				this.btns[y][x].setLabelValue(0);
				this.grid[y][x] = 0;
			}
		}

		this.player = 1;
	}

	private boolean checkDraw () {
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				if (this.grid[y][x] == 0) return false;
			}
		}

		return true;
	}

	private boolean isPlayerWin () {
		int[] checkedLine = this.getCheckedLine();

		if (checkedLine == null) return false;

		if (checkedLine[0] == 0) {
			for (int x = 0; x < 3; x++) {
				this.btns[checkedLine[1]][x].setCrossed(this.player);
			}

			return true;
		}

		if (checkedLine[0] == 1) {
			for (int y = 0; y < 3; y++) {
				this.btns[y][checkedLine[1]].setCrossed(this.player);
			}

			return true;
		}

		if (checkedLine[0] == 2) {
			for (int i = 0; i < 3; i++) {
				this.btns[i][i].setCrossed(this.player);
			}

			return true;
		}

		for (int i = 0; i < 3; i++) {
			this.btns[i][2 - i].setCrossed(this.player);
		}

		return true;
	}

	private void update () {
		boolean winner = this.isPlayerWin();

		if (winner) {
			int response = JOptionPane.showConfirmDialog(null, "The player " + (this.player == 1 ? "'X'" : "'O'") + " has won the match. Wanna play again? Click on 'yes' to play again. Click on 'no' to Exit.");

			if (response == 0) {
				this.reset();
				return;
			} else {
				System.exit(0);
			}
		}

		if (this.checkDraw()) {
			int response = JOptionPane.showConfirmDialog(null, "The match is draw. Wanna play again? Click on 'yes' to play again. Click on 'no' to Exit.");

			if (response == 0) {
				this.reset();
				return;
			} else {
				System.exit(0);
			}
		}
	}
}
