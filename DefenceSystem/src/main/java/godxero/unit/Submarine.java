/**
 * 
 * Will help with as a beast on the Mars.. Ohh?. Good defence unit btw.
 * 
 */

package godxero.unit;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import godxero.controller.MainController;
import godxero.interfaces.DefenceUnit;
import godxero.main.DefenceWindow;
import godxero.main.Strength;

public class Submarine extends DefenceWindow implements DefenceUnit {
	private JLabel areaClearIndicator;
	private JTextArea incomingMGDisplay;
	private JCheckBox positionStateCheckBox;
	private JButton unitSendMGBtn;
	private JButton shootBtn;
	private JButton sonarBtn;
	private JButton tomahawkMissleBtn;
	private JButton trident2MissileBtn;
	private JTextField unitSendMGText;

	public Submarine () {
		super("Submarine", 678, 310);
		this.buildLayout();
		this.addEvents();
		this.setVisible(true);
	}

	@Override
	public void setControlRoom (MainController controlRoom, int unitID) {
		this.controlRoom = controlRoom;
		this.unitID = unitID;
	}

	@Override
	public void buildLayout () {
		this.areaClearIndicator = new JLabel();
		this.positionStateCheckBox = new JCheckBox();
		this.incomingMGDisplay = new JTextArea();
		this.unitSendMGText = new JTextField();
		this.unitSendMGBtn = new JButton();
		this.shootBtn = new JButton();
		this.sonarBtn = new JButton();
		this.tomahawkMissleBtn = new JButton();
		this.trident2MissileBtn = new JButton();

		final JLabel jLabel1 = new JLabel();
		final JLabel jLabel2 = new JLabel();
		final JLabel jLabel3 = new JLabel();
		final JLabel jLabel4 = new JLabel();
		final JSpinner jSpinner1 = new JSpinner();
		final JSpinner jSpinner2 = new JSpinner();
		final JScrollPane jScrollPane1 = new JScrollPane();
		final JSlider jSlider1 = new JSlider();
		final JSlider jSlider2 = new JSlider();

		this.areaClearIndicator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		this.areaClearIndicator.setText("Area Not Cleared");

		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel2.setText("Soldier Count");

		jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel3.setText("Ammo Count");

		this.shootBtn.setText("Shoot");
		this.shootBtn.setEnabled(false);

		this.sonarBtn.setText("Sonar Operation");
		this.sonarBtn.setEnabled(false);

		this.tomahawkMissleBtn.setText("Tomahawk Missile");
		this.tomahawkMissleBtn.setEnabled(false);

		this.trident2MissileBtn.setText("Trident-2 Missile");
		this.trident2MissileBtn.setEnabled(false);

		this.positionStateCheckBox.setText("Position");

		this.incomingMGDisplay.setColumns(20);
		this.incomingMGDisplay.setRows(5);
		jScrollPane1.setViewportView(this.incomingMGDisplay);

		this.unitSendMGBtn.setText("Send");

		jSlider1.setMajorTickSpacing(20);
		jSlider1.setMinorTickSpacing(2);
		jSlider1.setOrientation(javax.swing.JSlider.VERTICAL);
		jSlider1.setPaintLabels(true);
		jSlider1.setPaintTicks(true);
		jSlider1.setSnapToTicks(true);
		jSlider1.setToolTipText("");
		jSlider1.setValue(0);

		jSlider2.setMajorTickSpacing(20);
		jSlider2.setMinorTickSpacing(2);
		jSlider2.setOrientation(javax.swing.JSlider.VERTICAL);
		jSlider2.setPaintLabels(true);
		jSlider2.setPaintTicks(true);
		jSlider2.setSnapToTicks(true);
		jSlider2.setToolTipText("");
		jSlider2.setValue(100);

		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("Energy");

		jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel4.setText("Oxigen");

		final javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this.getContentPane());
		this.getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup()
						.addComponent(this.areaClearIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
					.addGroup(layout.createSequentialGroup()
						.addGap(6, 6, 6)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
							.addGroup(layout.createSequentialGroup()
								.addComponent(this.shootBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(this.sonarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(layout.createSequentialGroup()
								.addComponent(this.tomahawkMissleBtn)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(this.trident2MissileBtn)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
							.addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addComponent(this.positionStateCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
							.addComponent(jSpinner2)
							.addComponent(jSpinner1)))
					.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
					.addGroup(layout.createSequentialGroup()
						.addComponent(this.unitSendMGText)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(this.unitSendMGBtn)))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
					.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
					.addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(jSlider2, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
				.addGap(14, 14, 14))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
					.addComponent(this.areaClearIndicator, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGroup(layout.createSequentialGroup()
						.addGap(4, 4, 4)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
							.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addComponent(jLabel1)
							.addComponent(jLabel4))))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
					.addComponent(jSlider1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
							.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(this.shootBtn)
								.addComponent(this.sonarBtn)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addComponent(this.positionStateCheckBox)
							.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(this.tomahawkMissleBtn)
								.addComponent(this.trident2MissileBtn)))
						.addGap(22, 22, 22)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
							.addComponent(this.unitSendMGText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addComponent(this.unitSendMGBtn)))
					.addComponent(jSlider2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		this.pack();
	}

	@Override
	public void addEvents () {
		this.unitSendMGBtn.addActionListener(event -> this.sendMessage());
		this.positionStateCheckBox.addItemListener(event -> this.updatePositionState(event.getStateChange()));

		this.incomingMGDisplay.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped (KeyEvent event) {
				event.consume();
			}
		});
	}

	@Override
	public void updateAreaClearState (boolean isAreaClear) {
		this.areaClearIndicator.setText("Area" + (isAreaClear ? " " : " not ") + "Cleared");
	}

	@Override
	public void sendMessage () {
		if (this.unitSendMGText.getText().equals("")) return;

		this.controlRoom.recieveMessage(this.unitSendMGText.getText(), "Submarine#" + this.unitID);
		this.unitSendMGText.setText("");
	}

	@Override
	public void recieveMessage (String message) {
		this.incomingMGDisplay.setText(this.incomingMGDisplay.getText() + "\n" + message);
	}

	@Override
	public void updatePositionState (int state) {
		this.isReadyToBattel = state == 1;

		if (this.isReadyToBattel) {
			this.updateControls();
		} else {
			this.shootBtn.setEnabled(false);
			this.sonarBtn.setEnabled(false);
			this.tomahawkMissleBtn.setEnabled(false);
			this.trident2MissileBtn.setEnabled(false);
		}
	}

	@Override
	public void updateControls () {
		if (!this.isReadyToBattel) return;

		final Strength strength = this.controlRoom.getCurrentStrength();

		this.shootBtn.setEnabled(strength != Strength.LOW);
		this.sonarBtn.setEnabled(strength != Strength.LOW && strength != Strength.MEDIUM);
		this.tomahawkMissleBtn.setEnabled(strength != Strength.LOW && strength != Strength.MEDIUM && strength != Strength.HIGH);
		this.trident2MissileBtn.setEnabled(strength != Strength.LOW && strength != Strength.MEDIUM && strength != Strength.HIGH && strength != Strength.STRONG);
	}
}
