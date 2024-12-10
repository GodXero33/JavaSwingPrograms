/**
 * 
 * The Control Room where Elon Musk lead his army.
 * 
 */

package godxero.controller;

import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import godxero.interfaces.DefenceUnit;
import godxero.main.ArrayList;
import godxero.main.DefenceWindow;
import godxero.main.Strength;

public class MainController extends DefenceWindow {
	private JCheckBox areaClearCheckBox;
	private JSlider positionSlider;
	private JTextArea unitRecieveMGDisplay;
	private JButton unitSendMGBtn;
	private JTextArea unitSendMGText;
	
	private ArrayList<DefenceUnit> defenceUnits;
	private int lastID = 1;
	private Strength currentStrength = Strength.LOW;

	public MainController () {
		super("control room", 701, 455);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.buildLayout();
		this.addEvents();
		this.setVisible(true);

		this.defenceUnits = new ArrayList<>();
	}

	public void addUnit (DefenceUnit ...units) {
		for (int g = 0; g < units.length; g++) {
			DefenceUnit unit = units[g];

			unit.setControlRoom(this, g + this.lastID);
			this.defenceUnits.append(unit);
		}

		this.lastID += units.length;
	}

	@Override
	public void buildLayout () {
		this.areaClearCheckBox = new javax.swing.JCheckBox();
		this.unitSendMGText = new JTextArea();
		this.unitSendMGBtn = new JButton();
		this.positionSlider = new JSlider();
		this.unitRecieveMGDisplay = new JTextArea();

		final JComboBox<String> defenceSelectBox = new JComboBox<>();
		final JButton collectInfoBtn = new JButton();
		final JScrollPane jScrollPane1 = new JScrollPane();
		final JCheckBox sendPrivateCheckBox = new JCheckBox();
		final JScrollPane jScrollPane2 = new JScrollPane();
		final JTextArea jTextArea2 = new JTextArea();
		final JScrollPane jScrollPane3 = new JScrollPane();
		final JLabel jLabel1 = new JLabel();
		final JLabel jLabel2 = new JLabel();
		final JLabel jLabel3 = new JLabel();
		final JLabel jLabel4 = new JLabel();
		final JLabel soldierCountDisplay = new JLabel();
		final JLabel fuelAmountDisplay = new JLabel();
		final JLabel ammoAmountDisplay = new JLabel();
		final Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
		final Border labelsBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);

		defenceSelectBox.setModel(new DefaultComboBoxModel<>(new String[] { "Helicopter", "Tank", "Submarine" }));
		defenceSelectBox.setCursor(handCursor);

		collectInfoBtn.setText("Collect Informations");
		collectInfoBtn.setCursor(handCursor);

		this.areaClearCheckBox.setText("Area Clear");
		this.areaClearCheckBox.setCursor(handCursor);

		this.unitSendMGText.setColumns(20);
		this.unitSendMGText.setRows(5);
		jScrollPane1.setViewportView(this.unitSendMGText);

		sendPrivateCheckBox.setText("Send Private");
		sendPrivateCheckBox.setCursor(handCursor);

		jLabel4.setText("Posotion");

		this.positionSlider.setMajorTickSpacing(20);
		this.positionSlider.setMinorTickSpacing(2);
		this.positionSlider.setPaintLabels(true);
		this.positionSlider.setPaintTicks(true);
		this.positionSlider.setSnapToTicks(true);
		this.positionSlider.setValue(0);
		this.positionSlider.setCursor(handCursor);

		jTextArea2.setColumns(20);
		jTextArea2.setRows(5);
		jTextArea2.setEnabled(false);
		jScrollPane2.setViewportView(jTextArea2);

		this.unitRecieveMGDisplay.setColumns(20);
		this.unitRecieveMGDisplay.setRows(5);
		jScrollPane3.setViewportView(this.unitRecieveMGDisplay);

		this.unitSendMGBtn.setText("Send");
		this.unitSendMGBtn.setCursor(handCursor);

		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel1.setText("Fuel Amount");
		jLabel1.setBorder(labelsBorder);
		jLabel1.setOpaque(true);

		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel2.setText("Soldier Count");
		jLabel2.setBorder(labelsBorder);
		jLabel2.setOpaque(true);

		jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel3.setText("Ammo Amount");
		jLabel3.setBorder(labelsBorder);
		jLabel3.setOpaque(true);

		soldierCountDisplay.setBorder(labelsBorder);
		soldierCountDisplay.setOpaque(true);

		fuelAmountDisplay.setBorder(labelsBorder);
		fuelAmountDisplay.setOpaque(true);

		ammoAmountDisplay.setBorder(labelsBorder);
		ammoAmountDisplay.setOpaque(true);

		final javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this.getContentPane());
		this.getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
					.addGroup(layout.createSequentialGroup()
						.addGap(16, 16, 16)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(layout.createSequentialGroup()
								.addComponent(defenceSelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(collectInfoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(this.areaClearCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
							.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
									.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
											.addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
											.addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
											.addComponent(ammoAmountDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(soldierCountDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(fuelAmountDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
									.addComponent(this.positionSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
									.addGroup(layout.createSequentialGroup()
										.addComponent(sendPrivateCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(this.unitSendMGBtn))
									.addGroup(layout.createSequentialGroup()
										.addGap(12, 12, 12)
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
					.addGroup(layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addGap(18, 18, 18))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
				.addGap(14, 14, 14)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
					.addComponent(defenceSelectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(collectInfoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(this.areaClearCheckBox))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
							.addComponent(soldierCountDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(13, 13, 13)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
							.addComponent(fuelAmountDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
							.addComponent(jLabel3)
							.addComponent(ammoAmountDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
					.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
					.addComponent(sendPrivateCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(jLabel4)
					.addComponent(this.unitSendMGBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(this.positionSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
					.addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
					.addComponent(jScrollPane3))
				.addGap(17, 17, 17))
		);

		this.pack();
	}

	@Override
	public void addEvents () {
		this.areaClearCheckBox.addItemListener(event -> this.areaClearCheckBoxAction(event.getStateChange()));
		this.unitSendMGBtn.addActionListener(event -> this.sendMGToUnits());
		this.positionSlider.addChangeListener(event -> this.updateStrength());

		this.unitRecieveMGDisplay.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped (KeyEvent event) {
				event.consume();
			}
		});
	}

	private void areaClearCheckBoxAction (int state) {
		for (int g = 0; g < this.defenceUnits.size(); g++) this.defenceUnits.get(g).updateAreaClearState(state == 1);
	}

	private void sendMGToUnits () {
		String message = this.unitSendMGText.getText();

		if (message.equals("")) return;

		for (int g = 0; g < this.defenceUnits.size(); g++) this.defenceUnits.get(g).recieveMessage(message);

		this.unitSendMGText.setText("");
	}

	public void recieveMessage (String message, String unit) {
		message = unit + ": " + message;
		this.unitRecieveMGDisplay.setText(unitRecieveMGDisplay.getText() + "\n" + message);
	}

	public Strength getCurrentStrength () {
		return this.currentStrength;
	}

	public void updateStrength () {
		final int strengthValue = this.positionSlider.getValue();
		this.currentStrength = strengthValue < 20 ? Strength.LOW : strengthValue < 40 ? Strength.MEDIUM : strengthValue < 60 ? Strength.HIGH : strengthValue < 80 ? Strength.STRONG : Strength.CLOSED;

		for (int g = 0; g < this.defenceUnits.size(); g++) this.defenceUnits.get(g).updateControls();
	}
}
