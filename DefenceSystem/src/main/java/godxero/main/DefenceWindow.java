/**
 * 
 * Customer JFrame class with extra defencive abilities.
 * We all make this class for every swing project right...
 * 
 */

package godxero.main;

import javax.swing.JFrame;

import godxero.controller.MainController;

public abstract class DefenceWindow extends JFrame {
	protected MainController controlRoom;
	protected int unitID;
	protected boolean isReadyToBattel;

	public DefenceWindow (String title, int width, int height) {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setTitle("Defence System - " + title);
		this.setSize(width, height);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}

	public abstract void buildLayout();
	public abstract void addEvents();
}
