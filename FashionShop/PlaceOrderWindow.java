import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PlaceOrderWindow extends ChildWindow {
	private CustomJButton placeBtn;

	private CustomTextField phoneValue;
	private CustomTextField sizeValue;
	private CustomTextField qtyValue;

	private CustomJLabel idValue;
	private CustomJLabel amountValue;

	PlaceOrderWindow () {
		this.setWindowName("Place Order");
		this.buildLayout();
		this.addCustomEvents();
		this.pack();
	}

	private void buildLayout () {
		JPanel bodyPanel = new JPanel(new GridLayout(5, 2, CommonResources.btnsGap, CommonResources.btnsGap));
		bodyPanel.setBorder(CommonResources.padding2);
		bodyPanel.setBackground(CommonResources.bgColor2);

		// Labels
		CustomJLabel idLbl = new CustomJLabel("ID");
		CustomJLabel phoneLbl = new CustomJLabel("Phone");
		CustomJLabel sizeLbl = new CustomJLabel("Size");
		CustomJLabel qtyLbl = new CustomJLabel("Qty");
		CustomJLabel amountLbl = new CustomJLabel("Amount");
		this.idValue = new CustomJLabel(CommonResources.orderManager.getNextOrderID() + "");
		this.amountValue = new CustomJLabel("0.00");

		// Text Fields
		this.phoneValue = new CustomTextField();
		this.sizeValue = new CustomTextField();
		this.qtyValue = new CustomTextField();

		bodyPanel.add(idLbl);
		bodyPanel.add(this.idValue);
		bodyPanel.add(phoneLbl);
		bodyPanel.add(this.phoneValue);
		bodyPanel.add(sizeLbl);
		bodyPanel.add(this.sizeValue);
		bodyPanel.add(qtyLbl);
		bodyPanel.add(this.qtyValue);
		bodyPanel.add(amountLbl);
		bodyPanel.add(this.amountValue);

		JPanel placeBtnPanel = new JPanel();
		placeBtnPanel.setBorder(CommonResources.padding2);
		placeBtnPanel.setBackground(CommonResources.bgColor2);

		this.placeBtn = new CustomJButton("Place");
		placeBtnPanel.add(this.placeBtn);

		this.addComponent(bodyPanel);
		this.addComponent(placeBtnPanel);
	}

	private void placeOrder () {
		int response = CommonResources.orderManager.add(
			CommonResources.orderManager.getNextOrderID(),
			this.phoneValue.getText(),
			this.sizeValue.getText(),
			this.qtyValue.getText()
		);

		if (response == OrderManager.ADD_RECORD_SUCCESS) {
			this.idValue = new CustomJLabel(CommonResources.orderManager.getNextOrderID() + "");
			this.phoneValue.setText("");
			this.sizeValue.setText("");
			this.qtyValue.setText("");
			this.amountValue.setText("");

			// this.setCursor(CommonResources.spinning);
			
			boolean isFileSaved = CommonResources.orderManager.save();

			if (isFileSaved) {
				JOptionPane.showMessageDialog(null, "Order placement is success!");
			} else {
				JOptionPane.showMessageDialog(null, "Order placement is failed! File not saved!");
			}

			// this.setCursor(CommonResources.defaultCur);
			return;
		}

		if (response == OrderManager.ADD_RECORD_INVALID_PHONE) {
			JOptionPane.showMessageDialog(null, "Invalid Phone Number!");
			return;
		}

		if (response == OrderManager.ADD_RECORD_INVALID_SIZE) {
			JOptionPane.showMessageDialog(null, "Invalid Size! Valid Sizes are XS, S, M, L, XL, XXL");
			return;
		}

		if (response == OrderManager.ADD_RECORD_INVALID_QTY) {
			JOptionPane.showMessageDialog(null, "Invalid quantity!");
		}
	}

	private void calculateAmount () {
		String size = this.sizeValue.getText();
		String qty = this.qtyValue.getText();
		int sizeIndex = OrderRecord.getSizeIndex(size);
		double amount = 0.0;

		if (sizeIndex != -1 && OrderRecordVilidater.isValidQTY(qty)) {
			amount = OrderRecord.getAmount(sizeIndex, Integer.parseInt(qty));
		}

		this.amountValue.setText(amount + "");
	}

	private void addCustomEvents () {
		PlaceOrderWindow thisInstance = this;

		this.placeBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				thisInstance.placeOrder();
			}
		});

		KeyAdapter textFieldsKeyListener = new KeyAdapter() {
			public void keyReleased (KeyEvent event) {
				thisInstance.calculateAmount();
			}
		};

		this.sizeValue.addKeyListener(textFieldsKeyListener);
		this.qtyValue.addKeyListener(textFieldsKeyListener);
	}
}
