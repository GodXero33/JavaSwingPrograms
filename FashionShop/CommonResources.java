import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

public class CommonResources {
	final static int fontSize1;
	final static int fontSize2;
	final static int maxTableRowCount;
	final static Font font1;
	final static Font font2;
	final static Color textColor1;
	final static Color textColor2;
	final static Color bgColor1;
	final static Color bgColor2;
	final static Color bgColor3;
	final static Color bgColor4;
	final static Color bgColor5;
	final static Color bgColor6;
	final static int btnsGap;
	final static String title;
	final static Image icon;
	final static ImageIcon cover;
	final static Cursor pointer;
	final static Cursor spinning;
	final static Cursor defaultCur;
	final static Border padding1;
	final static Border padding2;
	final static Border padding3;
	final static CompoundBorder btnsBorder;
	final static OrderManager orderManager;
	final static OrdersFileManager fileManager;
	private static ChildWindow openedChildWindow;

	static {
		fontSize1 = 18;
		fontSize2 = 25;
		maxTableRowCount = 20;
		font1 = new Font("Courier", 1, fontSize1);
		font2 = new Font("Courier", 1, fontSize2);
		textColor1 = new Color(255, 255, 255);
		textColor2 = new Color(0, 0, 0);
		bgColor1 = new Color(100, 100, 200);
		bgColor2 = new Color(100, 80, 150);
		bgColor3 = new Color(200, 100, 100);
		bgColor4 = new Color(100, 130, 220);
		bgColor5 = new Color(255, 100, 255);
		bgColor6 = new Color(255, 220, 255);
		btnsGap = 2;
		title = "Fashion Shop";
		icon = Toolkit.getDefaultToolkit().getImage("assets/icon.png");
		pointer = new Cursor(Cursor.HAND_CURSOR);
		spinning = new Cursor(Cursor.WAIT_CURSOR);
		defaultCur = new Cursor(Cursor.DEFAULT_CURSOR);
		padding1 = BorderFactory.createEmptyBorder(10, 0, 10, 0);
		padding2 = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		padding3 = BorderFactory.createEmptyBorder(0, 20, 0, 20);
		
		Image resizedImage = new ImageIcon("assets/icon.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		cover = new ImageIcon(resizedImage);

		Border border = BorderFactory.createLineBorder(new Color(150, 100, 220), 2);
		btnsBorder = new CompoundBorder(border, padding2);

		orderManager = new OrderManager();

		fileManager = new OrdersFileManager();
	}

	public static boolean isChildWindowOpened () {
		return openedChildWindow != null;
	}

	public static void closeChildWindow () {
		openedChildWindow = null;
	}

	public static void forceToCloseCurrentWindow () {
		if (openedChildWindow != null) {
			openedChildWindow.dispose();
			openedChildWindow = null;
		}
	}

	public static void secondChildWindowTryOpenAction () {
		if (openedChildWindow != null) {
			JOptionPane.showMessageDialog(null, "Please Close the " + openedChildWindow.getWindowName() + " window first!");
			openedChildWindow.toFront();
		}
	}

	public static void setOpenedChildWindow (ChildWindow window) {
		openedChildWindow = window;
	}
}
