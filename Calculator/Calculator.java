import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Calculator extends JFrame {
	private int cols = 4;
	private int rows = 6;
	private int btnSize = 100;
	private int gap = 2;
	private char[] symbols = { '7', '8', '9', '*', '4', '5', '6', '/', '1', '2', '3', '+', '0', '.', 'C', '-' };
	private JPanel keyContainer;
	private JPanel displayContainer;
	private JTextField eqDisplay;
	private JTextField ansDisplay;
	private Font font;
	private Font fontDis1;
	private Font fontDis2;
	private Color c1;
	private Color c2;
	private Color c3;
	private Color c4;

	JButton[] btns;

	Calculator () {
		this.font = new Font("Courier", Font.BOLD, (int) (this.btnSize * 0.6));
		this.fontDis1 = new Font("Courier", Font.BOLD, (int) (this.btnSize * 0.4));
		this.fontDis2 = new Font("Courier", Font.BOLD, (int) (this.btnSize * 0.35));
		this.btns = new JButton[this.cols * this.rows];
		this.keyContainer = new JPanel();
		this.displayContainer = new JPanel();
		this.c1 = new Color(200, 200, 200);
		this.c2 = new Color(100, 200, 100);
		this.c3 = new Color(80, 80, 240);
		this.c4 = new Color(255, 255, 255);

		this.keyContainer.setSize(this.btnSize * cols + gap * (cols + 1), this.btnSize * (rows - 2) + gap * rows);
		this.keyContainer.setLayout(new GridLayout(rows - 2, cols, gap, gap));

		this.displayContainer.setSize(this.btnSize * cols, this.btnSize * 2);
		this.displayContainer.setLayout(new BorderLayout());

		this.setVisible(true);
		this.setTitle("Calculator");
		this.getContentPane().setBackground(this.c1);
		this.setSize(this.btnSize * cols + gap * (cols + 1), this.btnSize * rows + gap * (rows + 1));
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());

		this.createTextFeilds();

		for (int i = 0; i < this.symbols.length; i++) {
			this.btns[i] = this.addNewBtn(symbols[i], this.btnSize, this.btnSize);
		}

		this.add("North", displayContainer);
		this.add("Center", keyContainer);
		this.pack();
	}

	private void createTextFeilds () {
		this.eqDisplay = new JTextField();
		this.eqDisplay.setPreferredSize(new Dimension(this.btnSize * 4, this.btnSize));
		this.eqDisplay.setFont(this.fontDis1);
		this.eqDisplay.setHorizontalAlignment(JTextField.RIGHT);
		this.eqDisplay.setEditable(false);
		this.displayContainer.add("North", this.eqDisplay);

		this.ansDisplay = new JTextField();
		this.ansDisplay.setPreferredSize(new Dimension(this.btnSize * 4, this.btnSize));
		this.ansDisplay.setFont(this.fontDis2);
		this.ansDisplay.setHorizontalAlignment(JTextField.RIGHT);
		this.ansDisplay.setEditable(false);
		this.ansDisplay.setText("0.0");
		this.displayContainer.add("Center", this.ansDisplay);
	}

	private JButton addNewBtn (char symbol, int w, int h) {
		JButton btn = new JButton(symbol + "");
		btn.setFont(this.font);
		btn.setPreferredSize(new Dimension(w, h));
		btn.setBackground(this.c2);
		btn.setForeground(this.c4);
		btn.setFocusPainted(false);
		btn.setContentAreaFilled(false);
		btn.setOpaque(true);

		Color color2 = this.c2;
		Color color3 = this.c3;
		
		btn.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mousePressed (java.awt.event.MouseEvent event) {
						btn.setBackground(color3);
					}
				
					@Override
					public void mouseReleased (java.awt.event.MouseEvent event) {
				btn.setBackground(color2);
			}
		});

		JTextField eqDisplayTmp = this.eqDisplay;
		JTextField ansDisplayTmp = this.ansDisplay;

		btn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				if (symbol == 'C') {
					eqDisplayTmp.setText("");
					ansDisplayTmp.setText("0.0");
					return;
				}

				String lastStr = eqDisplayTmp.getText();

				if (lastStr.length() == 0) {
					if (!FormulaSolver.isOperatorChar(symbol)) {
						eqDisplayTmp.setText(symbol + "");
						ansDisplayTmp.setText(symbol + "");
					}
				} else {
					char lastChar = lastStr.charAt(lastStr.length() - 1);

					if (FormulaSolver.isOperatorChar(symbol)) {
						if (FormulaSolver.isDigitChar(lastChar)) {
							eqDisplayTmp.setText(lastStr + symbol);
							ansDisplayTmp.setText(FormulaSolver.solve(lastStr + symbol) + "");
						}
					} else {
						eqDisplayTmp.setText(lastStr + symbol);
						ansDisplayTmp.setText(FormulaSolver.solve(lastStr + symbol) + "");
					}
				}
			}
		});

		this.keyContainer.add(btn);
		return btn;
	}
}
