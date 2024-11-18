import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SetOrderStatusWindow extends ChildWindow {
	private CustomJButton searchBtn;
	private CustomJButton changeBtn;

	private CustomTextField idValue;
	private CustomJLabel phoneValue;
	private CustomJLabel sizeValue;
	private CustomJLabel qtyValue;
	private CustomJLabel amountValue;
	private CustomJLabel statusValue;

	private String currentStatus;
	private OrderRecord currentOrder;

	SetOrderStatusWindow () {
		this.setWindowName("Set Order Status");
		this.buildLayout();
		this.addCustomEvents();
		this.pack();
	}

	private void buildLayout () {
		JPanel bodyPanel = new JPanel(new GridLayout(6, 2, CommonResources.btnsGap, CommonResources.btnsGap));
		bodyPanel.setBorder(CommonResources.padding2);
		bodyPanel.setBackground(CommonResources.bgColor2);

		// Labels
		CustomJLabel idLbl = new CustomJLabel("ID");
		CustomJLabel phoneLbl = new CustomJLabel("Phone");
		CustomJLabel sizeLbl = new CustomJLabel("Size");
		CustomJLabel qtyLbl = new CustomJLabel("Qty");
		CustomJLabel amountLbl = new CustomJLabel("Amount");
		CustomJLabel statusLbl = new CustomJLabel("Status");
		this.idValue = new CustomTextField();
		this.amountValue = new CustomJLabel();
		this.phoneValue = new CustomJLabel();
		this.sizeValue = new CustomJLabel();
		this.qtyValue = new CustomJLabel();
		this.statusValue = new CustomJLabel();

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
		bodyPanel.add(statusLbl);
		bodyPanel.add(this.statusValue);

		JPanel btnsPanel = new JPanel();
		btnsPanel.setBorder(CommonResources.padding2);
		btnsPanel.setBackground(CommonResources.bgColor2);

		this.searchBtn = new CustomJButton("Search");
		this.changeBtn = new CustomJButton("Change Status");
		this.changeBtn.disableBtn();
		
		btnsPanel.add(this.searchBtn);
		btnsPanel.add(this.changeBtn);

		this.addComponent(bodyPanel);
		this.addComponent(btnsPanel);
	}

	private void updateWindow (OrderRecord record) {
		this.phoneValue.setText(OrderRecord.getCustomer(record));
		this.sizeValue.setText(OrderRecord.getSize(record));
		this.qtyValue.setText(OrderRecord.getQTY(record) + "");
		this.amountValue.setText(String.format("%.2f", OrderRecord.getAmount(record)));
		this.statusValue.setText(OrderRecord.getStatus(record));
		
		this.currentStatus = this.statusValue.getText();
		this.currentOrder = record;

		if (this.currentStatus != OrderRecord.STATUSES[2]) {
			this.changeBtn.enableBtn();
		}
	}

	private void reset () {
		this.idValue.setText("");
		this.phoneValue.setText("");
		this.sizeValue.setText("");
		this.qtyValue.setText("");
		this.amountValue.setText("");
		this.statusValue.setText("");
	}

	private void searchOrderID () {
		String id = this.idValue.getText();

		if (id == null || !id.matches("^\\d+$")) {
			JOptionPane.showMessageDialog(null, "Invalid ID!");
			this.reset();
			return;
		}

		OrderRecord searchedRecord = CommonResources.orderManager.search(Integer.parseInt(id));

		if (searchedRecord == null) {
			JOptionPane.showMessageDialog(null, "Order is not found!");
			this.reset();
			return;
		}

		this.updateWindow(searchedRecord);
	}

	private void saveData () {
		boolean isFileSaved = CommonResources.orderManager.save();

		if (isFileSaved) {
			JOptionPane.showMessageDialog(null, "Status has updated!");
		} else {
			JOptionPane.showMessageDialog(null, "Failed to update the status! File not saved!");
		}
	}

	private void changeStatus () {
		if (this.currentStatus == OrderRecord.STATUSES[0]) {
			int response = JOptionPane.showOptionDialog(
				null,
				"Please select the status",
				"Status",
				JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE,
				null,
				new String[] { "Delivering", "Delivered" },
				"Delivering"
			);

			if (response == 0) {
				this.changeBtn.disableBtn();
				OrderRecord.setStatus(this.currentOrder, 1);
				this.saveData();
				this.updateWindow(this.currentOrder);
			} else if (response == 1) {
				this.changeBtn.disableBtn();
				OrderRecord.setStatus(this.currentOrder, 2);
				this.saveData();
				this.updateWindow(this.currentOrder);
			}
		} else if (this.currentStatus == OrderRecord.STATUSES[1]) {
			int response = JOptionPane.showOptionDialog(
				null,
				"Please select the status",
				"Status",
				JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE,
				null,
				new String[] { "Delivered" },
				"Delivered"
			);

			if (response == 0) {
				this.changeBtn.disableBtn();
				OrderRecord.setStatus(this.currentOrder, 2);
				this.saveData();
				this.updateWindow(this.currentOrder);
			}
		}
	}

	private void addCustomEvents () {
		SetOrderStatusWindow thisInstance = this;

		this.searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				thisInstance.searchOrderID();
			}
		});

		this.changeBtn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event) {
				thisInstance.changeStatus();
			}
		});
	}
}
